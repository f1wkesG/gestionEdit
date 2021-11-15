package com.exam.gestionEdit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Numero {

    @Id
    @GeneratedValue
    private int num;

    private boolean boucle;

    @OneToMany(mappedBy = "numero")
    List<Article> articles;

    public Numero() {
    }

    public Numero(int num, boolean boucle, List<Article> articles) {
        this.num = num;
        this.boucle = boucle;
        this.articles = articles;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public boolean isBoucle() {
        return boucle;
    }

    public void setBoucle(boolean boucle) {
        this.boucle = boucle;
    }
}
