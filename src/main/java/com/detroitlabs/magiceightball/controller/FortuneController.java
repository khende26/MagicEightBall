package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.model.Fortune;
import com.detroitlabs.magiceightball.service.DailyFortune;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FortuneController {
    DailyFortune dailyFortune = new DailyFortune();

    @RequestMapping("/")
    @ResponseBody

    public String displayFortune() throws IOException {
        Fortune fortune = dailyFortune.fetchDailyFortune();

        return
                "Is your sign accurate" + fortune.getSign() + ": Current Date" + fortune.getDay() +
                        "Here is your daily horoscope " + fortune.getDayFortune();

    }
}




