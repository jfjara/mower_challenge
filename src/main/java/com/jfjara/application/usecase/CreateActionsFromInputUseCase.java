package com.jfjara.application.usecase;

import com.jfjara.domain.model.MowerDirectionsEnum;

import java.util.ArrayList;
import java.util.List;

public class CreateActionsFromInputUseCase {

    public List<List<MowerDirectionsEnum>> execute(final List<String> input) {
        List<List<MowerDirectionsEnum>> result = new ArrayList<>();
        for (int i = 2; i < input.size(); i = i + 2) {
            String lineCommands = input.get(i);
            List<MowerDirectionsEnum> eachAction = new ArrayList<>();
            for (int j = 0; j < lineCommands.length(); j++) {
                eachAction.add(MowerDirectionsEnum.fromChar(lineCommands.charAt(j)));
            }
            result.add(eachAction);
        }
        return result;
    }
}
