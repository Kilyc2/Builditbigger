package com.example;

public class JokeDispatcher {

    public static String getJoke() {
        int x = Double.valueOf(Math.random() * 10).intValue();
        switch (x) {
            case 1:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Canoe.\n" +
                        "Canoe who?\n" +
                        "Canoe help me with my homework?";
            case 2:
                return "Knock, knock\n" +
                        "Who’s there?\n" +
                        "Merry.\n" +
                        "Merry who?\n" +
                        "Merry Christmas!";
            case 3:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Orange.\n" +
                        "Orange who?\n" +
                        "Orange you going to let me in?";
            case 4:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Anee.\n" +
                        "Anee,who?\n" +
                        "Anee one you like!";
            case 5:
                return "Knock, knock\n" +
                        "Who’s there?\n" +
                        "Iva.\n" +
                        "Iva who?\n" +
                        "I’ve a sore hand from knocking!";
            case 6:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Dozen.\n" +
                        "Dozen who?\n" +
                        "Dozen anybody want to let me in?";
            case 7:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Needle.\n" +
                        "Needle who?\n" +
                        "Needle little money for the movies.";
            case 8:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Henrietta.\n" +
                        "Henrietta who?\n" +
                        "Henrietta worm that was in his apple.";
            case 9:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Avenue.\n" +
                        "Avenue who?\n" +
                        "Avenue knocked on this door before?";
            default:
                return "Knock, knock.\n" +
                        "Who’s there?\n" +
                        "Harry.\n" +
                        "Harry who?\n" +
                        "Harry up, it’s cold out here!";
        }
    }
}
