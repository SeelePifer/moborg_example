package com.example.moborg.adapter.in.web;


import com.example.moborg.adapter.in.web.domain.Huddle;
import com.example.moborg.adapter.in.web.domain.HuddleRepositoryInMemoryImpl;
import com.example.moborg.adapter.in.web.domain.HuddleService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DashBoardControllerTest {

    @Test
    public void givenOneHuddleResultsInHuddlePutIntoModel() throws Exception{
        HuddleRepositoryInMemoryImpl huddleRepository = new HuddleRepositoryInMemoryImpl();
        HuddleService huddleService = new HuddleService(huddleRepository);
        huddleRepository.save(new Huddle("Name", ZonedDateTime.now()));


        DashBoardController dashBoardController = new DashBoardController(huddleService);

        Model model = new ConcurrentModel();
        dashBoardController.dashBoardView(model);

        List<HuddleSummary> huddels = (List<HuddleSummary>) model.getAttribute("huddles");


        assertThat(huddels)
                .hasSize(1);
        
    }
    @Test
    public void scheludeNewHuddleResultsInHuddleCreatedInRepository() throws Exception{

        HuddleRepositoryInMemoryImpl huddleRepository = new HuddleRepositoryInMemoryImpl();
        HuddleService huddleService = new HuddleService(huddleRepository);

        DashBoardController dashBoardController = new DashBoardController(huddleService);

        String pageName = dashBoardController.scheludeHuddle(new ScheludeHuddleForm("Name", "2021-04-30",""));

        assertThat(pageName)
                .isEqualTo("redirect:/dashboard");
        assertThat(huddleRepository.findAll())
                .hasSize(1);
    }
}
