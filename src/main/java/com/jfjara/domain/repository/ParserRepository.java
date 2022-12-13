package com.jfjara.domain.repository;

import com.jfjara.domain.model.CommandsInput;

import java.util.List;

public interface ParserRepository {

    CommandsInput parse(List<String> inputData);

}
