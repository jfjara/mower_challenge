package com.jfjara.domain.model;

import java.util.List;

public class MowerCommandsInput {

    private MowerPosition mowerPosition;
    private List<MowerCommand> mowerCommands;

    private MowerCommandsInput(Builder builder) {
        this.mowerCommands = builder.mowerCommands;
        this.mowerPosition = builder.mowerPosition;
    }

    public MowerPosition getMowerPosition() {
        return mowerPosition;
    }

    public List<MowerCommand> getMowerCommands() {
        return mowerCommands;
    }

    public static class Builder {
        private MowerPosition mowerPosition;
        private List<MowerCommand> mowerCommands;

        public Builder() { }

        public Builder mowerPosition(MowerPosition mowerPosition) {
            this.mowerPosition = mowerPosition;
            return this;
        }

        public Builder mowerCommands(List<MowerCommand> mowerCommands) {
            this.mowerCommands = mowerCommands;
            return this;
        }

        public MowerCommandsInput build() {
            return new MowerCommandsInput(this);
        }
    }
}
