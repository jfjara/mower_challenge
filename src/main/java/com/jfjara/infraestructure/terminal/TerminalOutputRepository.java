package com.jfjara.infraestructure.terminal;

import com.jfjara.domain.model.MowerPosition;
import com.jfjara.domain.repository.OutputRepository;

import java.util.List;

public class TerminalOutputRepository implements OutputRepository {

    @Override
    public void show(List<MowerPosition> positions) {
        for (MowerPosition position : positions) {
            System.out.println(position.getX() + " " + position.getY() + " " + position.getDirection().getValueText());
        }
    }

    @Override
    public void error(String msg) {
        System.out.println(msg);
    }
}
