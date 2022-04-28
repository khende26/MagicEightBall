package com.detroitlabs.magiceightball.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fortune {
    List<String> sign = new ArrayList<>();
    String day;
    String dayFortune;
    String compatible;
    String mood;
    String color;
    String luckyNo;
    String luckyTime;

   @JsonProperty("sign")
    public List<String> getSign() {
        return sign;
    }
    @JsonProperty("sign")
    public void setSign(List<String> sign) {
        this.sign = sign;
    }
    @JsonProperty("current_date")
    public String getDay() {
        return day;
    }
    @JsonProperty("current_date")
    public void setDay(String day) {
        this.day = day;
    }
    @JsonProperty("description")
    public String getDayFortune() {return dayFortune;}
    @JsonProperty("description")
    public void setDayFortune(String dayFortune) {this.dayFortune = dayFortune;}
    @JsonProperty("compatibility")
    public String getCompatible() {return compatible;}
    @JsonProperty("compatibility")
    public void setCompatible(String compatible) {this.compatible = compatible; }
    @JsonProperty("mood")
    public String getMood() {return mood;}
    @JsonProperty("mood")
    public void setMood(String mood) {this.mood = mood;}
    @JsonProperty("color")
    public String getColor() {return color;}
    @JsonProperty("color")
    public void setColor(String color) {this.color = color;}
    @JsonProperty("lucky_number")
    public String getLuckyNo() {return luckyNo;}
    @JsonProperty("lucky_number")
    public void setLuckyNo(String luckyNo) {this.luckyNo = luckyNo;}
    @JsonProperty("lucky_time")
    public String getLuckyTime() {return luckyTime;}
    @JsonProperty("lucky_time")
    public void setLuckyTime(String luckyTime) {this.luckyTime = luckyTime;}
}
