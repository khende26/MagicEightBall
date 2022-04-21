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
    public String getDayFortune() {
        return dayFortune;
    }
    @JsonProperty("description")
    public void setDayFortune(String dayFortune) {
        this.dayFortune = dayFortune;
    }
}
