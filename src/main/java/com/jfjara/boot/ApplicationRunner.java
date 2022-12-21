package com.jfjara.boot;

import com.jfjara.application.usecase.*;
import com.jfjara.application.validation.FormatValidationFactory;
import com.jfjara.application.validation.InputDataFormatValidator;
import com.jfjara.application.validation.MowerStartPositionValidator;
import com.jfjara.domain.exception.IllegalMowerStartPositionException;
import com.jfjara.domain.exception.InputFormatException;
import com.jfjara.infraestructure.keyboard.KeyboardInputRepository;
import com.jfjara.infraestructure.terminal.TerminalOutputRepository;

public class ApplicationRunner {

    private static final int TOTAL_MOWERS = 1;

    private final InputDataUseCase inputDataUseCase = new InputDataUseCase(new KeyboardInputRepository());
    private final ObtainAreaUseCase obtainAreaUseCase = new ObtainAreaUseCase();
    private final CreateMowersFromInputUseCase createMowersFromInputUseCase = new CreateMowersFromInputUseCase();
    private final CreateActionsFromInputUseCase createActionsFromInputUseCase = new CreateActionsFromInputUseCase();
    private final OutputDataUseCase outputDataUseCase = new OutputDataUseCase(new TerminalOutputRepository());

    public void run() {

        final var inputData = inputDataUseCase.execute(TOTAL_MOWERS);

        InputDataFormatValidator validators = FormatValidationFactory.build(inputData.size() - 1);
        if (!validators.validate(inputData, 0)) {
            throw new InputFormatException("Formato de entrada no correcto");
        }

        final var areaDimension = obtainAreaUseCase.execute(inputData.get(0));
        var mowers = createMowersFromInputUseCase.execute(inputData);

        var checkMowersStartPosition = new MowerStartPositionValidator();
        if (!checkMowersStartPosition.validate(areaDimension, mowers)) {
            throw new IllegalMowerStartPositionException("Error positioning mower outside area");
        }

        final var actions = createActionsFromInputUseCase.execute(inputData);

        for (int i = 0; i < mowers.size(); i++) {
            for (var action : actions.get(i)) {
                mowers.get(i).apply(areaDimension, action);
            }
        }

        outputDataUseCase.execute(mowers);
    }

}
