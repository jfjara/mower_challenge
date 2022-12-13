package com.jfjara.domain.model;

public class MowerMovementCommand implements MowerCommand {

    public MowerMovementCommand() {

    }

    public MowerPosition execute(final MowerPosition currentPosition, final BoardDimension boardDimension) {
        switch (currentPosition.getDirection()) {
            case N -> {
                return isAlignToAxis(currentPosition.getY(), boardDimension.getHeight()) ?
                        currentPosition :
                        currentPosition.builder().y(currentPosition.getY() + 1).build();
            }
            case S -> {
                return isAlignToAxis(currentPosition.getY(), 0) ?
                        currentPosition :
                        currentPosition.builder().y(currentPosition.getY() - 1).build();
            }
            case W -> {
                return isAlignToAxis(currentPosition.getX(), 0) ?
                        currentPosition:
                        currentPosition.builder().x(currentPosition.getX() - 1).build();
            }
            case E -> {
                return isAlignToAxis(currentPosition.getX(), boardDimension.getWidth()) ?
                        currentPosition :
                        currentPosition.builder().x(currentPosition.getX() + 1).build();
            }
        }
        return currentPosition;
    }

    private boolean isAlignToAxis(final int mowerValue, final int boardValue) {
        return mowerValue == boardValue;
    }

}
