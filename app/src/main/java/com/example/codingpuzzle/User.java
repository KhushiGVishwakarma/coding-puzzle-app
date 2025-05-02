package com.example.codingpuzzle;

public class User {
    private String name;
    private int score;
    private int avatarUrl;

    public User(String name, int score, int avatarUrl) {
        this.name = name;
        this.score = score;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAvatarUrl() {
        return avatarUrl;
    }
}
