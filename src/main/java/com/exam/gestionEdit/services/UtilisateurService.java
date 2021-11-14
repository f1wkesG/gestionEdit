package com.exam.gestionEdit.services;

import com.exam.gestionEdit.dtos.UtilisateurDTO;
import com.exam.gestionEdit.entities.Article;
import com.exam.gestionEdit.entities.Utilisateur;
import com.exam.gestionEdit.exceptions.ContributeurAlreadyExists;
import com.exam.gestionEdit.repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public Utilisateur findByLogin(String login){
        return utilisateurRepository.getById(login);
    }

    public void ajouterContributeur(UtilisateurDTO userDTO) throws ContributeurAlreadyExists {
        if(!(utilisateurRepository.findById(userDTO.getLogin())==null)){
            Utilisateur utilisateur = new Utilisateur(userDTO.getLogin(), userDTO.getPassword(), userDTO.getNom(), userDTO.getPrenom());
            utilisateurRepository.save(utilisateur);
        }else {
            throw new ContributeurAlreadyExists();
        }
    }

    public boolean verifierLogin(String login, String password) {
        if(!(utilisateurRepository.getById(login) == null)){
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

}
