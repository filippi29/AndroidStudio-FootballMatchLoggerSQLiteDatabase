package com.example.lab5;

import java.util.ArrayList;

public class Game {
    private String text;
    private int num1;
    private int num2;

    public Game(String text, int num1, int num2) {
        this.text = text;
        this.num1 = num1;
        this.num2 = num2;
    }

    public String getText() {
        return text;
    }

    public String winner(){

        if (num1 > num2){
            return text.split(" - ")[0];
        }
        else return text.split(" - ")[1];
    }

    public String getTeam1(){
        return text.split("-")[0];

    }

    public String getTeam2(){
        return text.split("-")[1];

    }
}
