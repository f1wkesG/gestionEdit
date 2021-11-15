package com.exam.gestionEdit.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    private String login;

    private String password;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "utilisateur")
    private List<Article> articles;

    public Utilisateur() {
    }

    public Utilisateur(String login, String password, String nom, String prenom, List<Article> articles) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.articles = articles;
    }

    public Utilisateur(String login, String password, String nom, String prenom){
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.articles = null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
