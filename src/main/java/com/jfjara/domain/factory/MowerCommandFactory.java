package com.jfjara.domain.factory;

import com.jfjara.domain.model.MowerCommand;
import com.jfjara.domain.model.MowerDirectionCommand;
import com.jfjara.domain.model.MowerMovementCommand;

public class MowerCommandFactory {

    public static MowerCommand createCommand(final char c) {

        if ('L' == c || 'R' == c) {
            return new MowerDirectionCommand(c);
        } else if ('M' == c) {
            return new MowerMovementCommand();
        }
        return null;
    }

}
