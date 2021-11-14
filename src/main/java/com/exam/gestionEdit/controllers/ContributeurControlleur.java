package com.exam.gestionEdit.controllers;


import com.exam.gestionEdit.dtos.UtilisateurDTO;
import com.exam.gestionEdit.enums.Theme;
import com.exam.gestionEdit.exceptions.ContributeurAlreadyExists;
import com.exam.gestionEdit.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("courant")
@RequestMapping("/contributeur")
public class ContributeurControlleur {

    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("")
    public String login(Model model){
        model.addAttribute(new UtilisateurDTO());
        return "loginContributeur";
    }

    @RequestMapping("inscription")
    public String inscrire(Model model){
        model.addAttribute(new UtilisateurDTO());
        return "inscription";
    }

    @PostMapping("inscription")
    public String ajouterContributeur(UtilisateurDTO userDto, BindingResult result, Model model){
        try{
          utilisateurService.ajouterContributeur(userDto);
        }catch (ContributeurAlreadyExists c){
            System.out.println(c.getMessage());
            result.addError(new ObjectError("user","Les informations saisies ne correspondent pas à un utilisateur connu."));
        }
        return "inscription";
    }

    @PostMapping("login")
    public String checkLogin(UtilisateurDTO userDto, BindingResult result, Model model){
        if (utilisateurService.verifierLogin(userDto.getLogin(), userDto.getPassword())) {
            model.addAttribute("courant", userDto.getLogin());
            model.addAttribute("nom", userDto.getNom());
            model.addAttribute("themes", Theme.getThemes());
            return "articles";
        } else {
            result.addError(new ObjectError("user","Les informations saisies ne correspondent pas à un utilisateur connu."));
            System.out.println(result.hasErrors());
            return "login";
        }
    }

}
