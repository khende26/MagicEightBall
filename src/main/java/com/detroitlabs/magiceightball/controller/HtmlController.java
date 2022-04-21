package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.service.DailyFortune;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HtmlController {
    DailyFortune dailyFortune = new DailyFortune();

    @RequestMapping("/home")

    public String displayHtml() {
        return "HomeHtml";
    }
}
