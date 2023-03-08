package com.example.moborg.adapter.in.web;


import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DashBoardControllerTest {

    @Test
    public void givenOneHuddleResultsInHuddlePutIntoModel() throws Exception{
        DashBoardController dashBoardController = new DashBoardController();

        Model model = new ConcurrentModel();
        dashBoardController.dashBoardView(model);

        List<HuddleSummary> huddels = (List<HuddleSummary>) model.getAttribute("huddles");


        assertThat(huddels)
                .hasSize(1);
        
    }
}
