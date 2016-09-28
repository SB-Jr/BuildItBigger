package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {


    ArrayList<String> jokes;
    String joke;
     public Jokes(){
         jokes = new ArrayList<>();
         jokes.add("Why do men find it difficult to make eye contact? Breasts don't have eyes");
         jokes.add("A computer once beat me at chess, but it was no match for me at kick boxing");
         jokes.add("How do you get a sweet 80-year-old lady to say the F word?\n" +
                 "Get another sweet little 80-year-old lady to yell *BINGO*!");
         jokes.add("As long as there are tests, there will be prayer in schools");
         jokes.add("What did one ocean say to the other ocean? Nothing, they just waved");
         jokes.add("For Sale: Parachute. Only used once, never opened");
         jokes.add("A bank is a place that will lend you money, if you can prove that you don't need it");
         jokes.add("Whenever I find the key to success, someone changes the lock");

         Random r = new Random();
         int i = r.nextInt(jokes.size());
         while(i>8&&i<=0){
             i = r.nextInt(jokes.size());
         }
         joke = jokes.get(i);
     }


    public String getJoke(){
        return joke;
    }

}
