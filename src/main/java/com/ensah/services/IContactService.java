package com.ensah.services;

import com.ensah.bo.Contact;

import java.util.List;
import java.util.Set;

public interface IContactService {
    public void addContact( Contact contact);
    public List<Contact> getAllContact();
    public void deleteContact(Contact contact);
    public void updateContact(Contact contact);
    public List<Contact> getContactByLastName(String name);
    public List<Contact> getContactByFirstName(String name);
    public  List<Contact>  getContactByPerNum(String num);
    public  List<Contact>  getContactByProNum(String num);
    public Set<Contact> findAllSorted();

    public  List<Contact> searchContactsByPhoneticName(String name);


}
