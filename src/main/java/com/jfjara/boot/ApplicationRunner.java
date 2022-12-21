package com.jfjara.boot;

import com.jfjara.application.usecase.*;
import com.jfjara.infraestructure.keyboard.KeyboardInputRepository;
import com.jfjara.infraestructure.terminal.TerminalOutputRepository;

import java.util.List;

public class ApplicationRunner {

    private final InputDataUseCase inputDataUseCase = new InputDataUseCase(
            new KeyboardInputRepository(),
            new TerminalOutputRepository());
    private final ObtainAreaUseCase obtainAreaUseCase = new ObtainAreaUseCase();
    private final CreateMowersFromInputUseCase createMowersFromInputUseCase = new CreateMowersFromInputUseCase();
    private final CreateActionsFromInputUseCase createActionsFromInputUseCase = new CreateActionsFromInputUseCase();
    private final OutputDataUseCase outputDataUseCase = new OutputDataUseCase(new TerminalOutputRepository());

    public void run() {

        final List<String> inputData = inputDataUseCase.execute();
        final var areaDimension = obtainAreaUseCase.execute(inputData.get(0));
        var mowers = createMowersFromInputUseCase.execute(inputData);
        final var actions = createActionsFromInputUseCase.execute(inputData);

        for (int i = 0; i < mowers.size(); i++) {
            mowers.get(i).apply(areaDimension, actions.get(i));
        }

        outputDataUseCase.execute(mowers);
    }

}
