package com.detroitlabs.magiceightball.controller;

import com.detroitlabs.magiceightball.model.Fortune;
import com.detroitlabs.magiceightball.service.DailyFortune;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FortuneController {
    DailyFortune dailyFortune = new DailyFortune();


    @RequestMapping(value = {"/info"})



    public String displayFortune(@ModelAttribute(value = "sign")String sign, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("sign", sign);
        Fortune fortune = dailyFortune.fetchDailyFortune(sign);
        modelMap.addAttribute("day", fortune.getDay());
        modelMap.addAttribute("dailyfortune",fortune.getDayFortune());
        modelMap.addAttribute("commpatibility", fortune.getCompatible());
        modelMap.addAttribute("mood", fortune.getMood());
        modelMap.addAttribute("color", fortune.getColor());
        modelMap.addAttribute("lucky_number", fortune.getLuckyNo());
        modelMap.addAttribute("lucky_time", fortune.getLuckyTime());


        return "info";
//                "Current Date: " + fortune.getDay() + ".  " +
//                        sign + ":  your daily horoscope:  "  + fortune.getDayFortune();

    }

}




