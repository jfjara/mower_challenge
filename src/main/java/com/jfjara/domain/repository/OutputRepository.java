package com.jfjara.domain.repository;

import com.jfjara.domain.model.Mower;

import java.util.List;

public interface OutputRepository {

    void show(List<Mower> positions);
    void error(String msg);
}
