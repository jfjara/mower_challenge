package com.jfjara.mocks;

import com.jfjara.domain.repository.InputRepository;

import java.util.Arrays;
import java.util.List;

public class MockInputRepository implements InputRepository {


    private List<String> data = Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM");

    public MockInputRepository() {  }

    public MockInputRepository(List<String> data) {
        this.data = data;
    }
    @Override
    public List<String> readData() {
        return data;
    }
}
