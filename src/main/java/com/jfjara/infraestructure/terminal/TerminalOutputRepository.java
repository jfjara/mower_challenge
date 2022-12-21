package com.jfjara.infraestructure.terminal;

import com.jfjara.domain.model.Mower;
import com.jfjara.domain.repository.OutputRepository;

import java.util.List;

public class TerminalOutputRepository implements OutputRepository {

    @Override
    public void show(final List<Mower> mowers) {
        for (Mower mower : mowers) {
            System.out.println(mower.getMowerPosition().getX() + " " +
                    mower.getMowerPosition().getY() + " " +
                    mower.getCardinalDirection().getValueText());
        }
    }

    @Override
    public void error(String msg) {
        System.out.println(msg);
    }
}
