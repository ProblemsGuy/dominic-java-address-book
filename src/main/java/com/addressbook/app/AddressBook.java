package com.addressbook.app;

import java.util.ArrayList;
import java.util.Iterator;
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

    public Contact getContactByName(String name) throws IndexOutOfBoundsException{
        for(Contact current: contactList){
            if(current.getName().equals(name)){
                return current;
            }
        }
        throw new IndexOutOfBoundsException();
    }
    public void removeContact(String name) throws IndexOutOfBoundsException{
        Contact oldContact = this.getContactByName(name);
        contactList.remove(oldContact);
    }

    public void editContact(Contact oldContact, Contact newContact) throws IndexOutOfBoundsException{
        contactList.set(contactList.indexOf(oldContact),newContact);
    }

    public boolean checkDuplicatedName(String name){
        try {
            this.getContactByName(name);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public boolean checkDuplicatedNumber(String number){
        boolean returnValue = false;
        for (Contact current : contactList) {
            returnValue = current.getNumber().equals(number);
        }
        return returnValue;
    }

    public boolean checkDuplicatedEmail(String email){
        boolean returnValue = false;
        for (Contact current : contactList) {
            returnValue = current.getEmail().equals(email);
        }
        return returnValue;
    }
}
