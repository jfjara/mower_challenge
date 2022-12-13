package com.jfjara.mocks;

import com.jfjara.domain.model.MowerPosition;
import com.jfjara.domain.repository.OutputRepository;

import java.util.List;

public class MockOutputRepository implements OutputRepository {
    @Override
    public void show(List<MowerPosition> positions) {
        //do nothing
    }

    @Override
    public void error(String msg) {
        //do nothing
    }
}
