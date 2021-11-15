package com.exam.gestionEdit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private int idArticle;
    private String titre;
    private String contenu;
    private String contenuModifie;
    private String theme;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Numero numero;

    private String etat;

    public Article(){
    }

    public Article(int idArticle, String titre, String contenu, String contenuModifie, String theme, Utilisateur utilisateur, Numero numero, String etat) {
        this.idArticle = idArticle;
        this.titre = titre;
        this.contenu = contenu;
        this.contenuModifie = contenuModifie;
        this.theme = theme;
        this.utilisateur = utilisateur;
        this.numero = numero;
        this.etat = etat;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
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
}
