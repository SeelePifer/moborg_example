package com.example.moborg.adapter.in.web.domain;

import java.util.List;

public interface HuddleRepository {
    Huddle save(Huddle huddle);

    List<Huddle> findAll();
}
