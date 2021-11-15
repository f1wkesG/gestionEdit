package com.exam.gestionEdit.dtos;

public class ArticleDTO {

    private int idArticle;
    private String titre;
    private String contenu;
    private String contenuModifie;
    private int numero;
    private String theme;
    private String etat;

    public ArticleDTO() {
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getContenuModifie() {
        return contenuModifie;
    }

    public void setContenuModifie(String contenuModifie) {
        this.contenuModifie = contenuModifie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
