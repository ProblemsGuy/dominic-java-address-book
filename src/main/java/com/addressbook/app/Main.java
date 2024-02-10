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
        this.next(scanner);
    }

    private void next(Scanner scanner){
        p("1. Add a new contact to your Address Book.");
        p("2. Remove an existing contact from your Address Book.");
        p("3. Search for a specific contact by name.");
        p("4. Edit an existing contact in your Address Book.");
        p("5. Display the content of your Address Book to view.");
        p("Enter any other number to exit this application");
        p("");
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
        String newInput = scanner.next();
        if(book.checkDuplicatedName(newInput)){
            p("Name is already used.");
            p("");
            this.next(scanner);
            return;
        }
        newContact.setName(newInput);
        p("Enter the new Contact's number:");
        newInput = scanner.next();
        if(book.checkDuplicatedNumber(newInput)){
            p("Number is already used.");
            p("");
            this.next(scanner);
            return;
        }
        newContact.setNumber(newInput);
        p("Enter the new Contact's email:");
        newInput = scanner.next();
        if(book.checkDuplicatedEmail(newInput)){
            p("Email is already used.");
            p("");
            this.next(scanner);
            return;
        }
        newContact.setEmail(newInput);
        book.addContact(newContact);
        p("Contact is added!");
        p("");
        this.next(scanner);
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
            book.removeContact(foundContact.getName());
            p("Contact is removed!");
        }
        p("");
        this.next(scanner);
    }

    private void showContactByName(Scanner scanner){
        Contact foundContact = findContactByName(scanner);
        if(foundContact != null){
            printContact(foundContact);
        }
        p("");
        this.next(scanner);
    }

    private void editContact(Scanner scanner){
        Contact foundContact = findContactByName(scanner);
        if (foundContact == null){
            return;
        }
        p("Which would you like to edit? Please enter the corresponding number.");
        p("1. Name");
        p("2. Number");
        p("3. Email");
        switch (scanner.nextInt()){
            case 1:
                editName(scanner, foundContact);
                break;
            case 2:
                editNumber(scanner,foundContact);
                break;
            case 3:
                editEmail(scanner,foundContact);
                break;
            default:
                p("");
                this.next(scanner);
                break;
        }
    }

    private void editName(Scanner scanner,Contact edit){
        Contact oldContact = edit;
        p("Enter the Contact's new name:");
        edit.setName(scanner.next());
        book.editContact(oldContact,edit);
        p("");
        this.next(scanner);
    }

    private void editNumber(Scanner scanner,Contact edit){
        Contact oldContact = edit;
        p("Enter the Contact's new number:");
        edit.setNumber(scanner.next());
        book.editContact(oldContact,edit);
        p("");
        this.next(scanner);
    }

    private void editEmail(Scanner scanner,Contact edit){
        Contact oldContact = edit;
        p("Enter the Contact's new email:");
        edit.setEmail(scanner.next());
        book.editContact(oldContact,edit);
        p("");
        this.next(scanner);
    }

    private void printAddressBook(Scanner scanner){
        for(Contact current: book.getContactList()){
            printContact(current);
            p("");
        }
        this.next(scanner);
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
