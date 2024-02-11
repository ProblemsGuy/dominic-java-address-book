package com.addressbook.app;
import java.util.List;

public class AddressBook {
    List<Contact> contactList;

    public AddressBook(List<Contact> c_list){
        contactList = c_list;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact){
        //Inserts a contact into the list.
        contactList.add(contact);
    }

    public Contact getContactByName(String name) throws IndexOutOfBoundsException{
        //For the list of contacts...
        for(Contact current: contactList){
            //If there's a Contact with your name on...
            if(current.getName().equals(name)){
                //Return it.
                return current;
            }
        }
        //Else, throw an exception as you go out of bounds.
        throw new IndexOutOfBoundsException();
    }
    public void removeContact(String name) throws IndexOutOfBoundsException{
        //Find the contact with the given name. (Throws the exception)
        Contact oldContact = this.getContactByName(name);
        //Remove that contact from the contact list.
        contactList.remove(oldContact);
    }

    public void editContact(Contact oldContact, Contact newContact) throws IndexOutOfBoundsException{
        //Replaces an old contact with a new contact, "editing" it.
        contactList.set(contactList.indexOf(oldContact),newContact);
    }

    public boolean checkDuplicatedName(String name){
        try {
            //Check if there's a contact with your name.
            this.getContactByName(name);
            return true;
        } catch (IndexOutOfBoundsException e){
            //If getContactByName throws an exception, then there must be no contact with that name.
            return false;
        }
    }

    public boolean checkDuplicatedNumber(String number){
        boolean returnValue = false;
        //For all Contacts in the list...
        for (Contact current : contactList) {
            //Say if they have the same phone number as the parameter.
            returnValue = current.getNumber().equals(number);
        }
        //Returns true if the number is present, false if not.
        return returnValue;
    }

    public boolean checkDuplicatedEmail(String email){
        boolean returnValue = false;
        //For all contacts in the list...
        for (Contact current : contactList) {
            //Say if they have the same email as the parameter.
            returnValue = current.getEmail().equals(email);
        }
        //Returns true if the email is present, false if not.
        return returnValue;
    }
}
