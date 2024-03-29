package com.addressbook.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public AddressBook book;

    public Main(){
        book = new AddressBook(new ArrayList<>());
    }

    //psvm; runs the menu and starts a functional loop that only exits when the user enters a non-valid input.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.menu(scanner);
    }

    //Simple Intro text.
    public void menu(Scanner scanner){
        p("Welcome to your Address Book! Please enter a number to select an option below.");
        p("------------------------------------------------------------------------------");
        this.next(scanner);
    }

    //Presets a list of options and then moves the user where they selected.
    private void next(Scanner scanner){
        p("1. Add a new contact to your Address Book.");
        p("2. Remove an existing contact from your Address Book.");
        p("3. Search for a specific contact by name.");
        p("4. Edit an existing contact in your Address Book.");
        p("5. Display the content of your Address Book to view.");
        p("6. Clear all Contacts.");
        p("Enter any thing else to exit this application");
        p("");
        switch( scanner.next() ){
            case "1":
                addContact(scanner);
                break;
            case "2":
                removeContact(scanner);
                break;
            case "3":
                showContactByName(scanner);
                break;
            case "4":
                editContact(scanner);
                break;
            case "5":
                printAddressBook(scanner);
                break;
            case "6":
                clearAll(scanner);
                break;
            default:
                break;
        }
    }

    private void addContact(Scanner scanner) {
        //Creates a new Contact
        Contact newContact = new Contact();
        boolean validInputGiven;
        String newInput;
        do {
            p("Enter the new Contact's name:");
            newInput = scanner.next();
            validInputGiven = checkName(newInput);
        } while (!validInputGiven);
        newContact.setName(newInput);
        do {
            p("Enter the new Contact's email:");
            newInput = scanner.next();
            validInputGiven = checkEmail(newInput);
        } while (!validInputGiven);
        newContact.setEmail(newInput);
        do {
            p("Enter the new Contact's number:");
            newInput = scanner.next();
            validInputGiven = checkNumber(newInput);
        } while (!validInputGiven);
        newContact.setNumber(newInput);
        //Adds the contact to the Address Book
        book.addContact(newContact);
        p("Contact is added!");
        p("");
        this.next(scanner);
    }

    //Checks the name isn't already in the Contact
    private boolean checkName(String newInput){
        if(!book.checkDuplicatedName(newInput) && regexValidName(newInput)){
            return true;
        }
        p("Name either already in used, or contains invalid characters.");
        p("");
        return false;
    }

    private boolean regexValidName(String newInput){
        return newInput.matches("^[a-zA-Z\\s]+");
    }

    private boolean checkNumber(String newInput){
        if(!book.checkDuplicatedNumber(newInput) && regexValidNumber(newInput)){
            return true;
        }
        p("Number is already used, or number contains non-digit characters.");
        p("");
        return false;
    }

    private boolean regexValidNumber(String newInput){
        return newInput.matches("^[0-9\\s]+$");
    }

    private boolean checkEmail(String newInput){
        if(!book.checkDuplicatedEmail(newInput) && regexValidEmail(newInput)){
            return true;
        }
        p("Email is already used, or doesn't fit the ---@---.-- structure.");
        p("");
        return false;
    }

    private boolean regexValidEmail(String newInput){
        return newInput.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
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
            this.next(scanner);
            return;
        }
        p("Which would you like to edit? Please enter the corresponding number.");
        p("1. Name");
        p("2. Number");
        p("3. Email");
        switch (scanner.next()){
            case "1":
                editName(scanner, foundContact);
                break;
            case "2":
                editNumber(scanner,foundContact);
                break;
            case "3":
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
        boolean validInputGiven;
        String newInput;
        do {
            p("Enter the new Contact's name:");
            newInput = scanner.next();
            validInputGiven = checkName(newInput);
        } while (!validInputGiven);
        edit.setName(newInput);
        book.editContact(oldContact,edit);
        p("Contact name edited!");
        p("");
        this.next(scanner);
    }

    private void editNumber(Scanner scanner,Contact edit){
        Contact oldContact = edit;
        boolean validInputGiven;
        String newInput;
        do {
            p("Enter the new Contact's number:");
            newInput = scanner.next();
            validInputGiven = checkNumber(newInput);
        } while (!validInputGiven);
        edit.setNumber(newInput);
        book.editContact(oldContact,edit);
        p("Contact number edited!");
        p("");
        this.next(scanner);
    }

    private void editEmail(Scanner scanner,Contact edit){
        Contact oldContact = edit;
        boolean validInputGiven;
        String newInput;
        do {
            p("Enter the new Contact's email:");
            newInput = scanner.next();
            validInputGiven = checkEmail(newInput);
        } while (!validInputGiven);
        edit.setEmail(newInput);
        book.editContact(oldContact,edit);
        p("Contact email edited!");
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

    private void clearAll(Scanner scanner){
        p("Are you sure you want to delete all Contacts? This cannot be undone.");
        p("Type 'YES' to confirm. Anything else will return you to the menu.");
        if(scanner.next().equals("YES")){
            book.clearAllContacts();
            p("All Contacts cleared!");
        }
        this.next(scanner);
    }
}
