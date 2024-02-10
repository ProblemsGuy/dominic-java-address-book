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

    public void removeContact(Contact contact) throws IndexOutOfBoundsException{
        boolean removedSomething = false;
        for(Contact current: contactList){
            if(contact.getName().equals(current.getName()) && contact.getNumber().equals(current.getNumber()) && contact.getEmail().equals(current.getEmail())){
                contactList.remove(current);
                removedSomething = true;
                break;
            }
        }
        if (!removedSomething){throw new IndexOutOfBoundsException();}
    }

    public void editContact(Contact oldContact, Contact newContact) throws IndexOutOfBoundsException{
        contactList.set(contactList.indexOf(oldContact),newContact);
    }

    public boolean checkDuplicatedName(String name){
        boolean returnValue = false;
        for (Contact current : contactList) {
            returnValue = current.getName().equals(name);
        }
        return returnValue;
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
