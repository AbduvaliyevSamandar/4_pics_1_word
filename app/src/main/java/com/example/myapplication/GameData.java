package com.example.myapplication;

public class GameData {
    private int imageId;
    private String answer;
    private String variant;

    public final static int INITIAL_COIN=400;

    public GameData(int imageId, String answer, String variant) {
        this.imageId = imageId;
        this.answer = answer;
        this.variant = variant;
    }

    public int getImageId() {
        return imageId;
    }

    public String getAnswer() {
        return answer;
    }

    public String getVariant() {
        return variant;
    }
}
