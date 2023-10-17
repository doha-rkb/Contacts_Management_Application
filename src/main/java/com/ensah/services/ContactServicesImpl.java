package com.ensah.services;

import com.ensah.bo.Contact;
import com.ensah.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
//@Transactional
public class ContactServicesImpl implements IContactService {

    @Autowired
    private ContactDao contactDao;

    public void addContact(Contact contact) {
        contactDao.save(contact);
    }

    public List<Contact> getAllContact() {
        return contactDao.findAll();
    }

    public void deleteContact(Contact contact) {
        contactDao.delete(contact);
    }

    public void updateContact(Contact contact) {
        contactDao.save(contact);
    }

    public List<Contact> getContactByLastName(String name) {
        return contactDao.findByLastName(name);
    }

    public List<Contact> getContactByFirstName(String name) {
        return contactDao.findByfirstName(name);
    }


    public List<Contact> getContactByProNum(String num) {
        return contactDao.findByproNum(num);
    }

    public List<Contact> getContactByPerNum(String num) {
        return contactDao.findByperNum(num);
    }

    public Set<Contact> findAllSorted() {
        return contactDao.findAllByOrderByLastNameAscFirstNameAsc();
    }

    public List<Contact> searchContactsByPhoneticName(String name) {
        return contactDao.searchByPhoneticName(name);
    }






}
