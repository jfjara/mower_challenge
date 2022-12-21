package com.jfjara.domain.model;

public class MowerPosition {

    private int x;
    private int y;
    private Builder builder;

    private MowerPosition(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.builder = builder;
    }

    private MowerPosition() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Builder builder() {
        return builder;
    }

    private boolean isAlignToAxis(final int mowerValue, final int boardValue) {
        return mowerValue == boardValue;
    }

    public void moveTo(final CardinalDirectionsEnum cardinalDirection, final BoardDimension boardDimension) {
        switch (cardinalDirection) {
            case N -> {
                if (!isAlignToAxis(this.getY(), boardDimension.getHeight())) {
                    y++;
                }
            }
            case S -> {
                if (!isAlignToAxis(this.getY(), 0)) {
                    y--;
                }
            }
            case W -> {
                if (!isAlignToAxis(this.getX(), 0)) {
                    x--;
                }
            }
            case E -> {
                if (!isAlignToAxis(this.getX(), boardDimension.getWidth())) {
                    x++;
                }
            }
        }
    }

    public static class Builder {
        private int x;
        private int y;

        public Builder() {

        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public MowerPosition build() {
            return new MowerPosition(this);
        }
    }
}
