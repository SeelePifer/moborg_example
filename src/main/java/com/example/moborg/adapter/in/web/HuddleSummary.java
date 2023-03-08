package com.example.moborg.adapter.in.web;

import com.example.moborg.adapter.in.web.domain.Huddle;

import java.util.List;

public record HuddleSummary(String name,
                            String dateTime,
                            int numberRegistered) {
    public static List<HuddleSummary> from(List<Huddle> huddles){
        return huddles.stream()
                .map(HuddleSummary::toView)
                .toList();
    }
    public static HuddleSummary toView(Huddle huddle){
        return new HuddleSummary(huddle.name(), huddle.startDateTime().toString(), huddle.numberRegistered());
    }
}
