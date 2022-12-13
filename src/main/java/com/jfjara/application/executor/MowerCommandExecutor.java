package com.jfjara.application.executor;

import com.jfjara.domain.model.BoardDimension;
import com.jfjara.domain.model.MowerCommand;
import com.jfjara.domain.model.MowerCommandsInput;
import com.jfjara.domain.model.MowerPosition;

public class MowerCommandExecutor {

    public MowerPosition executeMowerCommand(final MowerCommandsInput commands, final BoardDimension boardDimension) {
        MowerPosition currentPosition = commands.getMowerPosition();
        for (MowerCommand command : commands.getMowerCommands()) {
            currentPosition = command.execute(currentPosition, boardDimension);
        }
        return currentPosition;
    }

}
