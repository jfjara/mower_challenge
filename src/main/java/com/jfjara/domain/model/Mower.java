package com.jfjara.domain.model;

public class Mower {

    private MowerPosition mowerPosition;
    private CardinalDirectionsEnum cardinalDirection;

    public MowerPosition getMowerPosition() {
        return mowerPosition;
    }

    public CardinalDirectionsEnum getCardinalDirection() {
        return cardinalDirection;
    }

    public Mower(MowerPosition mowerPosition, CardinalDirectionsEnum cardinalDirection) {
        this.mowerPosition = mowerPosition;
        this.cardinalDirection = cardinalDirection;
    }

    private void rotate(final MowerDirectionsEnum mowerDirection) {
        cardinalDirection = cardinalDirection.rotate(cardinalDirection, mowerDirection);
    }

    private void move(final BoardDimension boardDimension) {
        mowerPosition.moveTo(cardinalDirection, boardDimension);
    }

    public void apply(final BoardDimension boardDimension, final MowerDirectionsEnum action) {
        switch (action) {
            case L -> rotate(MowerDirectionsEnum.L);
            case R -> rotate(MowerDirectionsEnum.R);
            case M -> move(boardDimension);
        }
    }

}
