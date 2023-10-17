package com.ensah.dao;

import com.ensah.bo.Groupes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupDao extends JpaRepository<Groupes,Long> {
    public Groupes findBygname(String gname);

}
