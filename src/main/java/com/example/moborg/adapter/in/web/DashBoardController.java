package com.example.moborg.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashBoardController {
    @GetMapping("/dashboard")
    public String dashBoardView(Model model){


        HuddleSummary huddleSummary = new HuddleSummary("Name", "Date/Time",
                2);
        model.addAttribute("huddles", List.of(huddleSummary));
        return "dashboard";
    }
}
