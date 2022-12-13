package com.jfjara.application.usecase;

import com.jfjara.domain.model.CommandsInput;
import com.jfjara.domain.repository.ParserRepository;

import java.util.List;

public class ParseDataUseCase {

    private final ParserRepository parserRepository;

    public ParseDataUseCase(final ParserRepository parserRepository) {
        this.parserRepository = parserRepository;
    }

    public CommandsInput execute(final List<String> inputData) {
        return parserRepository.parse(inputData);
    }
}
