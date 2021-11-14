package com.exam.gestionEdit.services;

import com.exam.gestionEdit.entities.Article;
import com.exam.gestionEdit.enums.EtatArticle;
import com.exam.gestionEdit.enums.Theme;
import com.exam.gestionEdit.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UtilisateurService utilisateurService;

    public void proposerArticle(String loginContributeur, String titre, String contenu, String theme){
        Article article = new Article();

        article.setTitre(titre);
        article.setContenu(contenu);
        article.setContributeur(utilisateurService.findByLogin(loginContributeur));
        article.setTheme(theme);
        article.setEtat(EtatArticle.ARTICLE_PROPOSE.toString());

        articleRepository.save(article);
    }

    public List<Article> recupererArticles(){
        return articleRepository.findAll();
    }

}
