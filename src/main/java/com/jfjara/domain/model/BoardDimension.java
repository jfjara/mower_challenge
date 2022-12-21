package com.jfjara.domain.model;

public class BoardDimension {

    private final int width;
    private final int height;

    private BoardDimension(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean contains(MowerPosition mowerPosition) {
        if ((mowerPosition.getX() < 0 || mowerPosition.getX() > width) ||
                (mowerPosition.getY() < 0 || mowerPosition.getY() > height)) {
            return false;
        }
        return true;
    }

    public static class Builder {

        protected int width;
        protected int height;

        public Builder() {

        }

        public Builder width(int w) {
            this.width = w;
            return this;
        }

        public Builder height(int h) {
            this.height = h;
            return this;
        }

        public BoardDimension build() {
            return new BoardDimension(this);
        }

    }
}
