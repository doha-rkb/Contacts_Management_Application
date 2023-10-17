package com.ensah.services;

import com.ensah.bo.Contact;
import com.ensah.bo.Groupes;

import java.util.List;
import java.util.Set;

public interface IGroupService {
    public List<Groupes> getAll();
    public void addGroup(Groupes groupes);
    public void deleteGroup(Groupes groupes);

    public void addContactTogroupe(Groupes grp, Contact contact );
    public Groupes getGroupByName(String name);


}
