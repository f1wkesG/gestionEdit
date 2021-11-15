package com.exam.gestionEdit.enums;

import java.util.ArrayList;
import java.util.List;

public enum Theme {
    HISTOIRE, MODE, SCIENCE, SPORT, POLITIQUE, ACTUALITE, ENVIRONNEMENT;

    public static List<String> getThemes(){
        ArrayList<String> themes = new ArrayList<String>();
        for (Theme theme : Theme.values()) {
            themes.add(theme.toString());
        }
        return themes;
    }

}
