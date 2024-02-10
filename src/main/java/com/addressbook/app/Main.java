package com.addressbook.app;

import java.util.Scanner;

public class Main {

    public AddressBook book;
    public static void main(String[] args) {

    }
    public Main(){
        book = new AddressBook();
    }

    public void menu(Scanner scanner){
        p("Welcome to your Address Book! Please enter a number to select an option below.");
        p("------------------------------------------------------------------------------");
        p("1. Add a new contact to your Address Book.");
        p("2. Remove an existing contact from your Address Book.");
        p("3. Edit an existing contact in your Address Book.");
        p("4. Display the content of your Address Book to view.");
        p("Enter any other number to exit this application");
        switch( scanner.nextInt() ){
            case 1:
                addContact(scanner);
                break;
            case 2:
                removeContact(scanner);
                break;
            case 3:
                editContact(scanner);
                break;
            case 4:
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

    private void removeContact(Scanner scanner){

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
}
