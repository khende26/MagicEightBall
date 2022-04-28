package com.detroitlabs.magiceightball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Magic8BallResponses {
    List<String> responses = new ArrayList<>();

    public Magic8BallResponses() {
        responses.add("It is certain");
        responses.add(" Without a doubt");
        responses.add("You may rely on it");
        responses.add("Yes definitely");
        responses.add("It is decidedly so");
        responses.add("As I see it, yes");
        responses.add("Most likely Yes");
        responses.add("Outlook Good");
        responses.add("Signs point to yes");
        responses.add("It could happen");
        responses.add("Response hazy, try again");
        responses.add("Better not tell you now");
        responses.add("Ask again later");
        responses.add("Cannot predict now");
        responses.add("Concentrate and ask again");
        responses.add("Maybe");
        responses.add("No, Don't count on it");
        responses.add("Outlook not so good");
        responses.add("My sources say No");
        responses.add("Very doubtful");
        responses.add("My reply is no");

    }



    public String randomResponse() {
        Random rand = new Random();
        int randomRoll = rand.nextInt(responses.size());
        return responses.get(randomRoll);

    }

}
