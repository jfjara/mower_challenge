package com.jfjara.application.usecase;

import com.jfjara.application.executor.MowerCommandExecutor;
import com.jfjara.domain.model.CommandsInput;
import com.jfjara.domain.model.MowerPosition;

import java.util.List;
import java.util.stream.Collectors;

public class MainUseCase {

    private final InputDataUseCase inputDataUseCase;
    private final ParseDataUseCase parseDataUseCase;
    private final OutputDataUseCase outputDataUseCase;
    private final MowerCommandExecutor mowerExecutor = new MowerCommandExecutor();

    public MainUseCase(final InputDataUseCase inputDataUseCase,
                       final ParseDataUseCase parseDataUseCase,
                       final OutputDataUseCase outputDataUseCase) {
        this.inputDataUseCase = inputDataUseCase;
        this.parseDataUseCase = parseDataUseCase;
        this.outputDataUseCase = outputDataUseCase;
    }

    public List<MowerPosition> execute() {
        final List<String> inputData = inputDataUseCase.execute();
        final CommandsInput commandsParsed = parseDataUseCase.execute(inputData);
        final List<MowerPosition> endPositions = commandsParsed.getMowerCommandsInputs().stream()
                .map(ci -> mowerExecutor.executeMowerCommand(ci, commandsParsed.getBoardDimension()))
                .collect(Collectors.toList());
        outputDataUseCase.execute(endPositions);
        return endPositions;
    }

}
