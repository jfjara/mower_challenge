package com.jfjara.domain.model;

public class MowerDirectionCommand implements MowerCommand {

    private MowerDirectionsEnum mowerDirection;


    public MowerDirectionCommand(final char command) {
        mowerDirection = MowerDirectionsEnum.fromChar(command);
    }

    @Override
    public MowerPosition execute(final MowerPosition currentPosition, final BoardDimension boardDimension) {
        return currentPosition.builder()
                .direction(CardinalDirectionsEnum.rotate(currentPosition.getDirection(), mowerDirection))
                .build();
    }
}
