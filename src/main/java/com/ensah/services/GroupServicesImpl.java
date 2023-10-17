package com.ensah.services;

import com.ensah.bo.Contact;
import com.ensah.bo.Groupes;
import com.ensah.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GroupServicesImpl implements IGroupService {
    @Autowired
    private GroupDao groupDao;

    public void addGroup(Groupes groupe) {
        groupDao.save(groupe);
    }
    public void addContactTogroupe(Groupes grp, Contact contact){
    }

    public void deleteGroup(Groupes groupe) {
        groupDao.delete(groupe);
    }
    public List<Groupes> getAll(){
        return groupDao.findAll();
    }


    public Groupes getGroupByName(String name) {
        return groupDao.findBygname(name);
    }




}
