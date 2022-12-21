package com.jfjara.application.usecase;

import com.jfjara.domain.model.BoardDimension;

public class ObtainAreaUseCase {

    public BoardDimension execute(final String line) {
        return parseBoardDimension(line);
    }

    private BoardDimension parseBoardDimension(final String s) {
        String[] values = s.split(" ");
        return new BoardDimension.Builder()
                .width(Integer.parseInt(values[0]))
                .height(Integer.parseInt(values[1])).build();
    }

}
