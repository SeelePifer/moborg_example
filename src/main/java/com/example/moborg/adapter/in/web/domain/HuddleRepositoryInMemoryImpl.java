package com.example.moborg.adapter.in.web.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuddleRepositoryInMemoryImpl implements HuddleRepository {
    private final List<Huddle> huddles = new ArrayList<>();
    @Override
    public Huddle save(Huddle huddle) {
        huddles.add(huddle);
        return huddle;
    }

    @Override
    public List<Huddle> findAll() {
        return List.copyOf(huddles);
    }
}
