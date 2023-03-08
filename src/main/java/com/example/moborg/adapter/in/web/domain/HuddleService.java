package com.example.moborg.adapter.in.web.domain;

import java.time.ZonedDateTime;
import java.util.List;

public class HuddleService {
    private final HuddleRepository huddleRepository;

    public HuddleService(HuddleRepository huddleRepository) {
        this.huddleRepository = huddleRepository;
    }

    public void scheludeHuddle(String name, ZonedDateTime now) {
        Huddle huddle = new Huddle(name, now);
        huddleRepository.save(huddle);
    }

    public List<Huddle> allHuddles() {
        return huddleRepository.findAll();
    }
}
