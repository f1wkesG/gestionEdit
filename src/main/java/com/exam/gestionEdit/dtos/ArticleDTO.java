package com.exam.gestionEdit.dtos;

public class ArticleDTO {

    private String titre;
    private String contenu;
    private String theme;

    public ArticleDTO() {
    }

    public ArticleDTO(String titre, String contenu, String theme) {
        this.titre = titre;
        this.contenu = contenu;
        this.theme = theme;
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
}
