package com.example.codingpuzzle;

public class Player {
    public String name;
    public int score;

    // Required empty constructor for Firebase
    public Player() {}

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
