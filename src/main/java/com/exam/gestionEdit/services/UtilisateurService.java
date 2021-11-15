package com.exam.gestionEdit.services;

import com.exam.gestionEdit.dtos.UtilisateurDTO;
import com.exam.gestionEdit.entities.Article;
import com.exam.gestionEdit.entities.Utilisateur;
import com.exam.gestionEdit.enums.EtatArticle;
import com.exam.gestionEdit.exceptions.ContributeurAlreadyExists;
import com.exam.gestionEdit.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public Utilisateur findByLogin(String login){
        return utilisateurRepository.getById(login);
    }

    public void ajouterContributeur(UtilisateurDTO userDTO) throws ContributeurAlreadyExists {
        if(!utilisateurRepository.findById(userDTO.getLogin()).isPresent()){
            Utilisateur utilisateur = new Utilisateur(userDTO.getLogin(), userDTO.getPassword(), userDTO.getNom(), userDTO.getPrenom());
            utilisateurRepository.save(utilisateur);
        }else {
            throw new ContributeurAlreadyExists();
        }
    }

    public boolean verifierLogin(String login, String password) {
        if(utilisateurRepository.findById(login).isPresent()){
            return utilisateurRepository.getById(login).getPassword().equals(password);
        }else {
            return false;
        }
    }

    public List<Article> recupererArticlesParContributeur(String login){
        Utilisateur utilisateur = utilisateurRepository.findById(login).orElse(null);
        System.out.println(utilisateur.getNom());
        System.out.println(utilisateur.getArticles().toString());
        return utilisateur.getArticles();
    }

    public List<Article> recupererArticlesModifiesParContributeur(String courant) {
        ArrayList<Article> articles = new ArrayList<Article>();
        for (Article a : recupererArticlesParContributeur(courant)){
            if (a.getEtat().equals(EtatArticle.ARTICLE_MODIFIE.toString())){
                articles.add(a);
            }
        }
        return articles;
    }
}
