package com.jfjara.infraestructure.parser;

import com.jfjara.domain.factory.MowerCommandFactory;
import com.jfjara.domain.model.*;
import com.jfjara.domain.repository.ParserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomParserRepository implements ParserRepository {

    @Override
    public CommandsInput parse(List<String> commandTexts) {
        BoardDimension boardDimension = parseBoardDimension(commandTexts.get(0));
        List<MowerCommandsInput> mowerCommandsInputs = new ArrayList<>();
        //read two input data line for mower
        for (int i = 1; i < commandTexts.size(); i = i + 2) {
            mowerCommandsInputs.add(new MowerCommandsInput.Builder()
                    .mowerPosition(parseMowerPosition(commandTexts.get(i)))
                    .mowerCommands(parseMowerCommands(commandTexts.get(i + 1)))
                    .build());
        }
        return new CommandsInput.Builder()
                .boardDimension(boardDimension)
                .mowerCommandsInput(mowerCommandsInputs)
                .build();
    }

    private List<MowerCommand> parseMowerCommands(final String s) {
        return s.chars()
                .mapToObj(c -> (char) c).toList()
                .stream()
                    .map(this::parseMowerCommand)
                    .collect(Collectors.toList());
    }

    private MowerCommand parseMowerCommand(final char c) {
        return MowerCommandFactory.createCommand(c);
    }

    private MowerPosition parseMowerPosition(final String s) {
        String[] values = s.split(" ");
        return new MowerPosition.Builder()
                .x(Integer.parseInt(values[0]))
                .y(Integer.parseInt(values[1]))
                .direction(CardinalDirectionsEnum.valueOf(values[2])).build();
    }

    private BoardDimension parseBoardDimension(final String s) {
        String[] values = s.split(" ");
        return new BoardDimension.Builder()
                .width(Integer.parseInt(values[0]))
                .height(Integer.parseInt(values[1])).build();
    }

}
