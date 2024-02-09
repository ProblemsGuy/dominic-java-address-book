package com.addressbook.app;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Contact> contactList;

    public AddressBook(){
        contactList = new ArrayList<>();
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }

    public void removeContact(Contact contact) throws IndexOutOfBoundsException{
       if (!contactList.remove(contact)){throw new IndexOutOfBoundsException("removeContact removes object that isn't present.");}
    }

    public void editContact(Contact oldContact, Contact newContact) throws IndexOutOfBoundsException{
        contactList.set(contactList.indexOf(oldContact),newContact);
    }

    public boolean checkDuplicatedName(String name){
        return false;
    }

    public boolean checkDuplicatedNumber(String number){
        return false;
    }

    public boolean checkDuplicatedEmail(String email){
        return false;
    }
}
