package br.com.library.data.book.config;

import java.util.Random;

public enum GenreEnum {
    SCI_FI("SCI-Fi"), HISTORY("history"), FANTASY("fantasy"), RANDON("randon"),
    HORROR("horror"), DRAMA("drama"), DOCUMENTARY("documentary"), WAR("war");

    GenreEnum(String s) {
    }

    public GenreEnum generateAleatoryGenre(){
        var i = new Random().nextInt(values().length);
        return values()[i];
    }
}
