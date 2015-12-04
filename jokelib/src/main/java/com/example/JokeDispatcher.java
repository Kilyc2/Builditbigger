package com.example;

public class JokeDispatcher {

    public static String getJoke() {
        int x = Double.valueOf(Math.random() * 2).intValue();
        switch (x) {
            case 1:
                return "La marmota perdió las botas";
            default:
                return "Maria no es graciosa";
        }
    }
}
