package com.jfjara.application.validation;

import com.jfjara.domain.model.BoardDimension;
import com.jfjara.domain.model.Mower;

import java.util.List;

public class MowerStartPositionValidator extends LogicDataValidator {

    public boolean validate(BoardDimension areaDimension, List<Mower> mowers) {
        for (Mower mower : mowers) {
            if (!areaDimension.contains(mower.getMowerPosition())) {
                return false;
            }
        }
        return true;
    }

}
