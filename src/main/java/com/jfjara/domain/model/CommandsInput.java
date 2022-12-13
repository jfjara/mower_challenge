package com.jfjara.domain.model;

import java.util.List;

public class CommandsInput {

    private final BoardDimension boardDimension;
    private final List<MowerCommandsInput> mowerCommandsInputs;

    private CommandsInput(Builder builder) {
        this.boardDimension = builder.boardDimension;
        this.mowerCommandsInputs = builder.mowerCommandsInputs;
    }

    public BoardDimension getBoardDimension() {
        return boardDimension;
    }

    public List<MowerCommandsInput> getMowerCommandsInputs() {
        return mowerCommandsInputs;
    }

    public static class Builder {
        private BoardDimension boardDimension;
        private List<MowerCommandsInput> mowerCommandsInputs;

        public Builder() {
        }

        public Builder boardDimension(BoardDimension boardDimension) {
            this.boardDimension = boardDimension;
            return this;
        }

        public Builder mowerCommandsInput(List<MowerCommandsInput> mowerCommandsInputs) {
            this.mowerCommandsInputs = mowerCommandsInputs;
            return this;
        }

        public CommandsInput build() {
            return new CommandsInput(this);
        }

    }


}
