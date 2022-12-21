package com.jfjara.application.usecase;

import com.jfjara.domain.model.MowerDirectionsEnum;

import java.util.ArrayList;
import java.util.List;

public class CreateActionsFromInputUseCase {

    public List<MowerDirectionsEnum> execute(final List<String> input) {
        List<MowerDirectionsEnum> result = new ArrayList<>();
        for (int i = 2; i < input.size(); i = i + 2) {
            String lineCommands = input.get(i);
            for (int j = 0; j < lineCommands.length(); j++) {
               result.add(MowerDirectionsEnum.fromChar(lineCommands.charAt(j)));
            }
        }
        return result;
    }
}
