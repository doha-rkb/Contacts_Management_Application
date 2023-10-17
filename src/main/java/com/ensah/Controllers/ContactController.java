package com.ensah.Controllers;

import com.ensah.bo.Contact;
import com.ensah.bo.Groupes;
import com.ensah.services.IContactService;
import com.ensah.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Controller

public class ContactController {
    protected final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private IContactService contactServices;
    @Autowired
    private IGroupService groupServices;
    @Autowired
    private ServletContext appContext;
    @Autowired
    private HttpSession session;
    @GetMapping({"/", "/home"})
    public String showHome(Model model) {
        appContext.setAttribute("test","bonjour");
        session.setAttribute("test","bonjour");
        model.addAttribute("welcomme");
        return "home";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        System.out.println(appContext.getAttribute("test"));
        System.out.println( session.getAttribute("test"));
        model.addAttribute("contactModel", new Contact());
        return "form";
    }

    @PostMapping("/addContact")
    public String addContact(@Valid @ModelAttribute("contactModel") Contact contact, BindingResult bindingResult,
                             ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMsg", "invalid informations");
        } else {
            if (!contactServices.getContactByProNum(contact.getProNum()).isEmpty()){
                model.addAttribute("errorMsg", "We already have a record of this professional number in our system.");
            }else if(!contactServices.getContactByPerNum(contact.getPerNum()).isEmpty()){
                model.addAttribute("errorMsg", "We already have a record of this personnal number in our system.");
            }
                else{
                contactServices.addContact(contact);
                if (groupServices.getGroupByName(contact.getLastName()) == null) {
                    groupServices.addGroup(new Groupes(contact.getLastName()));
                    contact.getGroups().add(groupServices.getGroupByName(contact.getLastName()));
                    groupServices.getGroupByName(contact.getLastName()).getContacts().add(contact);

                } else {
                    contact.getGroups().add(groupServices.getGroupByName(contact.getLastName()));
                    groupServices.getGroupByName(contact.getLastName()).getContacts().add(contact);

                    System.out.println("jajajaaj" + groupServices.getGroupByName(contact.getLastName()));
                }
                model.addAttribute("infoMsg", "Contact has been added seccesfully");
            }
        }

        return "form";
    }

    @GetMapping("/showAllContacts")
    public String showAllContacts(Model model) {
        Set<Contact> list = contactServices.findAllSorted();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("option") String option, @RequestParam("deleteterm") String deleteTerm, Model model) {
        List<Contact> search = null;
        List<Contact> updatedlist = contactServices.getAllContact();

        if (option.equals("lname")) {
            search = contactServices.getContactByLastName(deleteTerm);
        } else if (option.equals("fname")) {
            search = contactServices.getContactByFirstName(deleteTerm);

        } else if (option.equals("pronumber")) {
            search = contactServices.getContactByProNum(deleteTerm);

        } else if (option.equals("pernumber")) {
            search = contactServices.getContactByPerNum(deleteTerm);
            System.out.println(search);
        }

        if (search != null && search.size() == 0) {
            model.addAttribute("infoMsg", "no contact found please check your informations");
        } else if(search == null){
            model.addAttribute("updatedlist",updatedlist);
        }
        else {
            for (Contact contact : search) {
                System.out.println(contact);
                contactServices.deleteContact(contact);
            }
        }
        updatedlist = contactServices.getAllContact();
        model.addAttribute("updatedlist",updatedlist);
        return "delete";
    }


    @GetMapping("/search")
    public String sear(@RequestParam("option") String option, @RequestParam("searchterm") String searchTerm, Model model) {
        List<Contact> search = null;
        if (option.equals("lname")) {
            search = contactServices.getContactByLastName(searchTerm);
        } else if (option.equals("fname")) {
            search = contactServices.getContactByFirstName(searchTerm);

        } else if (option.equals("pronumber")) {
            search = contactServices.getContactByProNum(searchTerm);

        } else if (option.equals("pernumber")) {
            search = contactServices.getContactByPerNum(searchTerm);
            System.out.println(search);
        }
        if (search != null && search.size() == 0) {
            model.addAttribute("infoMsg", "no contact found");
        } else {
            model.addAttribute("searchRes", search);
        }
        return "search";
    }
    @GetMapping("/groupes")
    public String grp(Model model){

        return "groupes";
    }
    @GetMapping("/ShowGroupForm")
    public String showgrpForm(Model model){
        model.addAttribute("AllContact",contactServices.getAllContact());
        model.addAttribute("groupemodel",new Groupes());
        return "groupeform";
    }
    @PostMapping("/creategrp")
    public String creategrp(@Valid @ModelAttribute("groupemodel") Groupes groupe,
                            @RequestParam(value = "contacts", required = false) Set<Contact> contacts
            ,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errorMsg","Invalid Informations");
          //  System.out.println("hahaah");
        }
        else{
            if(groupe.getGname().equals("")||groupServices.getGroupByName(groupe.getGname())!=null){
                model.addAttribute("errorMsg"," please check your groupe name ");
            }
            else{
             groupe.setContacts(contacts);
            for (Contact c:contacts) {
                c.getGroups().add(groupe);
                groupe.getContacts().add(c);
            }
            groupServices.addGroup(groupe);
            model.addAttribute("infoMsg","group created succesfully");
        }}
        model.addAttribute("AllContact",contactServices.getAllContact());
        return "groupeform";
    }
    @GetMapping("/Showgroups")
    public String showgroups(Model model ){
        model.addAttribute("Allgroups",groupServices.getAll());
        System.out.println(groupServices.getAll());
        model.addAttribute("infoMsg","group created succesfully");
        return "groupList";
    }
    @GetMapping("/deletegrp")
    public String deletegrp(Model model, @RequestParam("grpname") String grpname){
        if(!grpname.equals("")){
        if(groupServices.getGroupByName(grpname)!=null){
            for (Contact c:contactServices.getAllContact()) {
                c.getGroups().remove(groupServices.getGroupByName(grpname));
            }
            groupServices.deleteGroup(groupServices.getGroupByName(grpname));
            model.addAttribute("infoMsg"," group deleted seccesfully");
            model.addAttribute("updatedgrouplist",groupServices.getAll());
        }else{
            model.addAttribute("errorMsg"," There is no group with this name");
        }
    }
        return "groupdelete";
    }
    @GetMapping("/searchgrp")
    public String searchgrp(Model model, @RequestParam("grpname") String grpname){
        if(!grpname.equals("")){
            if(groupServices.getGroupByName(grpname)!=null){
                model.addAttribute("grpres",groupServices.getGroupByName(grpname));
            }else{
                model.addAttribute("errorMsg"," There is no group with this name");
            }
        }
        return "groupSearch";
    }

    @RequestMapping("/phonetique")

    public String phonetique(@RequestParam(name="phonetiqueName") String name ,Model model){
        if(!name.equals("")) {
            model.addAttribute("searchRes", contactServices.searchContactsByPhoneticName(name));

        }
        return "phonetique";

    }






}
