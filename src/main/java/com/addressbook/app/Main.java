package com.addressbook.app;

import java.util.Scanner;

public class Main {
    public AddressBook book;

    public Main(){
        book = new AddressBook();
    }

    public void menu(Scanner scanner){
        p("Welcome to your Address Book! Please enter a number to select an option below.");
        p("------------------------------------------------------------------------------");
        p("1. Add a new contact to your Address Book.");
        p("2. Remove an existing contact from your Address Book.");
        p("3. Search for a specific contact by name.");
        p("4. Edit an existing contact in your Address Book.");
        p("5. Display the content of your Address Book to view.");
        p("Enter any other number to exit this application");
        switch( scanner.nextInt() ){
            case 1:
                addContact(scanner);
                break;
            case 2:
                removeContact(scanner);
                break;
            case 3:
                showContactByName(scanner);
                break;
            case 4:
                editContact(scanner);
                break;
            case 5:
                printAddressBook(scanner);
                break;
            default:
                break;
        }
    }

    private void addContact(Scanner scanner){
        Contact newContact = new Contact();
        p("Enter the new Contact's name:");
        newContact.setName(scanner.next());
        p("Enter the new Contact's number:");
        newContact.setNumber(scanner.next());
        p("Enter the new Contact's email:");
        newContact.setEmail(scanner.next());
        book.addContact(newContact);
        p("Contact is added!");
    }

    private Contact findContactByName(Scanner scanner){
        p("Enter the Contact's name:");
        try{
            return book.getContactByName(scanner.next());
        } catch (IndexOutOfBoundsException e){
            p("No Contact found with that name.");
            return null;
        }
    }

    private void removeContact(Scanner scanner){
        Contact foundContact = findContactByName(scanner);
        if(foundContact != null) {
            book.removeContact(findContactByName(scanner).getName());
            p("Contact is removed!");
        }
    }

    private void showContactByName(Scanner scanner){
        Contact foundContact = findContactByName(scanner);
        if(foundContact != null){
            printContact(foundContact);
        }
    }

    private void editContact(Scanner scanner){
    }

    private void editName(Scanner scanner){

    }

    private void editNumber(Scanner scanner){

    }

    private void editEmail(Scanner scanner){

    }

    private void printAddressBook(Scanner scanner){

    }

    static private void p(String str){
        System.out.println(str);
    }

    static private void printContact(Contact cont){
        p("Contact");
        p("-------");
        p("Name: "+ cont.getName());
        p("Number: "+ cont.getNumber());
        p("Email: "+ cont.getEmail());
    }
}
