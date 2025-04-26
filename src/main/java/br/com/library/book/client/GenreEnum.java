package br.com.library.book.client;

import java.util.Random;

public enum GenreEnum {
    SCI_FI("SCI-Fi"),
    HISTORY("history"),
    FANTASY("fantasy"),
    HORROR("horror"),
    DRAMA("drama"),
    DOCUMENTARY("documentary"),
    WAR("war");

    GenreEnum(String s) {
    }

    GenreEnum(){}

    static String generateAleatoryGenre(){
        var i = new Random().nextInt(values().length);
        return values()[i].toString();
    }
}
