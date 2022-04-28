package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.model.Fortune;
import com.detroitlabs.magiceightball.model.Magic8BallResponses;
import com.detroitlabs.magiceightball.service.DailyFortune;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HtmlController {
    DailyFortune dailyFortune = new DailyFortune();
    Magic8BallResponses answer = new Magic8BallResponses();


    @RequestMapping("/")

    public String displayHtml(ModelMap modelMap) {
        modelMap.addAttribute("answer", answer.randomResponse());
        return "HomeHtml";
    }

}
