package com.ensah.dao;

import com.ensah.bo.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ContactDao extends JpaRepository<Contact,Long> {

    public List<Contact> findByLastName(String name);
    public List<Contact> findByfirstName(String name);
    public List<Contact>  findByproNum(String num);
    public List<Contact>  findByperNum(String num);
    public Set<Contact> findAllByOrderByLastNameAscFirstNameAsc();

    @Query("SELECT c FROM Contact c WHERE FUNCTION('SOUNDEX', CONCAT(c.firstName, ' ', c.lastName)) = FUNCTION('SOUNDEX', :name)")
    List<Contact> searchByPhoneticName(String name);


}
