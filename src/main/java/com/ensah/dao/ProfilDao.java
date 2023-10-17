package com.ensah.dao;

import com.ensah.bo.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilDao  extends JpaRepository<Profil,Long> {
         Profil findByIdP(int id);


}