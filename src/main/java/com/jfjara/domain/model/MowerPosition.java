package com.jfjara.domain.model;

public class MowerPosition {

    private int x;
    private int y;
    private CardinalDirectionsEnum direction;

    private Builder builder;

    private MowerPosition(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.direction = builder.direction;
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

    public CardinalDirectionsEnum getDirection() {
        return direction;
    }

    public static class Builder {
        private int x;
        private int y;
        private CardinalDirectionsEnum direction;

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

        public Builder direction(CardinalDirectionsEnum d) {
            this.direction = d;
            return this;
        }

        public MowerPosition build() {
            return new MowerPosition(this);
        }
    }
}
