package com.exam.gestionEdit.enums;

import java.util.ArrayList;
import java.util.List;

public enum EtatArticle {
    ARTICLE_PROPOSE, ARTICLE_REJETE,
    ARTICLE_ENATTENTE, ARTICLE_POSITIONNE,
    ARTICLE_PUBLIE, ARTICLE_MODIFIE,
    MODIFICATION_REFUSEE, MODIFICATION_VALIDEE;

    public static List<String> getEtatsNonBoucles(){
        ArrayList<String> etats = new ArrayList<String>();
        etats.add(EtatArticle.ARTICLE_PROPOSE.toString());
        etats.add(EtatArticle.ARTICLE_ENATTENTE.toString());
        etats.add(EtatArticle.ARTICLE_POSITIONNE.toString());
        return etats;
    }

    public static List<String> getEtatsPositionnes(){
        ArrayList<String> etats = new ArrayList<String>();
        etats.add(EtatArticle.ARTICLE_POSITIONNE.toString());
        return etats;
    }

    public static List<String> getEtatsModifies(){
        ArrayList<String> etats = new ArrayList<String>();
        etats.add(EtatArticle.ARTICLE_MODIFIE.toString());
        return etats;
    }

    public static List<String> getEtatsModifiesValides(){
        ArrayList<String> etats = new ArrayList<String>();
        etats.add(EtatArticle.MODIFICATION_VALIDEE.toString());
        return etats;
    }

    public static List<String> getEtatsModifiesRefuses(){
        ArrayList<String> etats = new ArrayList<String>();
        etats.add(EtatArticle.MODIFICATION_REFUSEE.toString());
        return etats;
    }

    public static List<String> getEtatsAssistant(){
        ArrayList<String> etatsAssistant = new ArrayList<String>();
        etatsAssistant.add(EtatArticle.ARTICLE_ENATTENTE.toString());
        etatsAssistant.add(EtatArticle.ARTICLE_POSITIONNE.toString());
        etatsAssistant.add(EtatArticle.ARTICLE_REJETE.toString());
        return etatsAssistant;
    }

    public static List<String> getEtatsRedacteur(){
        ArrayList<String> etatsAssistant = new ArrayList<String>();
        etatsAssistant.add(EtatArticle.ARTICLE_ENATTENTE.toString());
        etatsAssistant.add(EtatArticle.ARTICLE_REJETE.toString());
        return etatsAssistant;
    }

    public static List<String> getEtatsRejetes() {
        ArrayList<String> etats = new ArrayList<String>();
        etats.add(EtatArticle.ARTICLE_REJETE.toString());
        return etats;
    }
}
