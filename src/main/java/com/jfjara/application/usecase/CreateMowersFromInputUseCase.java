package com.jfjara.application.usecase;

import com.jfjara.domain.model.CardinalDirectionsEnum;
import com.jfjara.domain.model.Mower;
import com.jfjara.domain.model.MowerPosition;

import java.util.ArrayList;
import java.util.List;

public class CreateMowersFromInputUseCase {

    public List<Mower> execute(List<String> input) {
        List<Mower> mowers = new ArrayList<>();
        for (int i = 1; i < input.size(); i = i + 2) {
            String[] values = input.get(i).split(" ");
            mowers.add(new Mower(parseMowerPosition(values), parseCardinalDirection(values[2])));
        }
        return mowers;
    }

    private CardinalDirectionsEnum parseCardinalDirection(final String cd) {
        return CardinalDirectionsEnum.valueOf(cd);
    }

    private MowerPosition parseMowerPosition(final String[] values) {

        return new MowerPosition.Builder()
                .x(Integer.parseInt(values[0]))
                .y(Integer.parseInt(values[1])).build();
    }
}
