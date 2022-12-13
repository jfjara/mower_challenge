package com.jfjara.domain.model;

public interface MowerCommand {

    MowerPosition execute(final MowerPosition currentPosition, final BoardDimension boardDimension);

}
