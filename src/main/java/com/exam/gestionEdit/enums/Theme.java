package com.exam.gestionEdit.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Theme {
    HISTOIRE, MODE, SCIENCE, SPORT, POLITIQUE, ACTUALITE, ENVIRONNEMENT;

    public static List<String> getThemes(){
        ArrayList<String> themes = new ArrayList<String>();
        for (Theme day : Theme.values()) {
            themes.add(day.toString());
        }
        return themes;
    }

}
