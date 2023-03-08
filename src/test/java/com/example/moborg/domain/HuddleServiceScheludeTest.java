package com.example.moborg.domain;

import com.example.moborg.adapter.in.web.domain.HuddleRepositoryInMemoryImpl;
import com.example.moborg.adapter.in.web.domain.HuddleService;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;
public class HuddleServiceScheludeTest {
    @Test
    public void createHuddleIsReturnedForAlHuddles() throws Exception{

        HuddleService huddleService = new HuddleService(new HuddleRepositoryInMemoryImpl());

        huddleService.scheludeHuddle("Name", ZonedDateTime.now());

        assertThat(huddleService.allHuddles())
                .hasSize(1);
    }
}
