package com.ensah.services;

import com.ensah.bo.Profil;
import com.ensah.dao.ProfilDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProfilServicesImpl implements IprofilService{
    @Autowired
    private ProfilDao profilDao;

    public Profil getProfil() {
        return profilDao.findByIdP(1);
    }
}
