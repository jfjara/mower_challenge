package com.jfjara.domain.repository;

import com.jfjara.domain.model.MowerPosition;

import java.util.List;

public interface OutputRepository {

    void show(List<MowerPosition> positions);
    void error(String msg);
}
