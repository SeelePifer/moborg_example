package com.example.moborg.adapter.in.web;

import com.example.moborg.adapter.in.web.domain.Huddle;
import com.example.moborg.adapter.in.web.domain.HuddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.ZonedDateTime;
import java.util.List;

@Controller
public class DashBoardController {

    private final HuddleService huddleService;
    @Autowired
    public DashBoardController(HuddleService huddleService){

        this.huddleService = huddleService;
    }
    @GetMapping("/dashboard")
    public String dashBoardView(Model model){

        List<Huddle> huddles = huddleService.allHuddles();

        List<HuddleSummary> huddleSummary = HuddleSummary.from(huddles);
        model.addAttribute("huddles", huddleSummary);
        model.addAttribute("scheludeHuddleForm", new ScheludeHuddleForm());
        return "dashboard";
    }

    @GetMapping("huddle")
    public String huddleDetailView(Model model){

        HuddleDetailView huddleDetailView = new HuddleDetailView("Name","04/24/2021 10am PDT",
                "90 minutes", "Blackjack", 4);
        model.addAttribute("huddle", huddleDetailView);
        return "huddle-detail";
    }

    @PostMapping("/schelude")
    public String scheludeHuddle(ScheludeHuddleForm scheludeHuddleForm) {
        ZonedDateTime dateTime= ZonedDateTime.now(); //TODO Impl
        huddleService.scheludeHuddle(scheludeHuddleForm.name(), dateTime);
        return "redirect:/dashboard";
    }
}
