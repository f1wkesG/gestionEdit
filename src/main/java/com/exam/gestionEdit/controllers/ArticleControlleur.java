package com.exam.gestionEdit.controllers;

import com.exam.gestionEdit.dtos.ArticleDTO;
import com.exam.gestionEdit.enums.Theme;
import com.exam.gestionEdit.services.ArticleService;
import com.exam.gestionEdit.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("courant")
@RequestMapping("/articles")
public class ArticleControlleur {

    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("")
    public String afficherToutArticle(Model model, @SessionAttribute String courant) {
        model.addAttribute("courant", courant);
        model.addAttribute("articles",articleService.recupererArticles());
        model.addAttribute("themes", Theme.getThemes());
        return("interfaceContributeur");
    }

    @PostMapping("")
    public String ajouterArticle(ArticleDTO articleDTO,Model model, @SessionAttribute String courant) {
        articleService.proposerArticle(courant, articleDTO.getTitre(), articleDTO.getContenu(), articleDTO.getTheme());
        model.addAttribute("articlesUtilisateur",utilisateurService.recupererArticlesParContributeur(courant));
        model.addAttribute("themes", Theme.getThemes());
        return("interfaceContributeur");
    }

}
