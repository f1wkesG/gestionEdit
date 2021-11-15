package com.exam.gestionEdit.services;

import com.exam.gestionEdit.dtos.ArticleDTO;
import com.exam.gestionEdit.entities.Article;
import com.exam.gestionEdit.enums.EtatArticle;
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

    @Autowired
    NumeroService numeroService;

    public void proposerArticle(String loginContributeur, String titre, String contenu, String theme){
        Article article = new Article();

        article.setTitre(titre);
        article.setContenu(contenu);
        article.setUtilisateur(utilisateurService.findByLogin(loginContributeur));
        article.setTheme(theme);
        article.setEtat(EtatArticle.ARTICLE_PROPOSE.toString());

        articleRepository.save(article);
    }

    public List<Article> recupererArticles(){
        return articleRepository.findAll();
    }

    public List<Article> recupererArticlesRejetes() {
        return articleRepository.findArticlesByEtatIn(EtatArticle.getEtatsRejetes());
    }

    public List<Article> recupererArticlesNonBoucles(){
        return articleRepository.findArticlesByEtatIn(EtatArticle.getEtatsNonBoucles());
    }

    public List<Article> recupererArticlesPositionnes(){
        return articleRepository.findArticlesByEtatIn(EtatArticle.getEtatsPositionnes());
    }

    public List<Article> recupererArticlesModifies(){
        return articleRepository.findArticlesByEtatIn(EtatArticle.getEtatsModifies());
    }

    public List<Article> recupererArticlesModifiesValides(){
        return articleRepository.findArticlesByEtatIn(EtatArticle.getEtatsModifiesValides());
    }

    public List<Article> recupererArticlesModifiesRefuses(){
        return articleRepository.findArticlesByEtatIn(EtatArticle.getEtatsModifiesRefuses());
    }

    public void modifierEtat(ArticleDTO articleDTO){
       Article article = articleRepository.findById(articleDTO.getIdArticle()).orElse(null);
       article.setEtat(articleDTO.getEtat());
       articleRepository.save(article);
    }

    public void modifierContenu(ArticleDTO articleDTO){
        Article article = articleRepository.findById(articleDTO.getIdArticle()).orElse(null);
        article.setContenuModifie(articleDTO.getContenuModifie());
        article.setEtat(EtatArticle.ARTICLE_MODIFIE.toString());
        articleRepository.save(article);
    }

    public void validerModification(ArticleDTO articleDTO) {
        Article article = articleRepository.findById(articleDTO.getIdArticle()).orElse(null);
        article.setContenu(article.getContenuModifie());
        article.setContenuModifie(null);
        article.setEtat(EtatArticle.MODIFICATION_VALIDEE.toString());
        articleRepository.save(article);
    }

    public void refuserModification(ArticleDTO articleDTO) {
        Article article = articleRepository.findById(articleDTO.getIdArticle()).orElse(null);
        article.setEtat(EtatArticle.MODIFICATION_REFUSEE.toString());
        articleRepository.save(article);
    }

    public void publierArticle(ArticleDTO articleDTO) {
        Article article = articleRepository.findById(articleDTO.getIdArticle()).orElse(null);
        article.setEtat(EtatArticle.ARTICLE_PUBLIE.toString());
        article.setNumero(numeroService.recupererNumero(articleDTO.getNumero()));
        articleRepository.save(article);
    }
}
