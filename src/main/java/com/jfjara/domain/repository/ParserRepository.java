package com.jfjara.domain.repository;

import java.util.List;

public interface ParserRepository {

    CommandsInput parse(List<String> inputData);

}
