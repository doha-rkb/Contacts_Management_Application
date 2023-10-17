package com.ensah.Controllers;

import com.ensah.bo.Profil;
import com.ensah.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilController {

    @Autowired
    private IContactService profil;

    @GetMapping("/showProfil")
    public String showProfil(Model model){
        model.addAttribute("profil",new Profil());
        return "profil";
    }


}
