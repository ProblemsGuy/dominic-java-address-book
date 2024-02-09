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

    public void removeContact(Contact contact){
    }
}
