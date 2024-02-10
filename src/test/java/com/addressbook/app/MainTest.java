package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    @DisplayName("Does `menu()` progress if it's given a '1' input, and can a user then add a contact?")
    public void menuTest1() {
        //Arrange
        Main main = new Main();
        Scanner mockScanner = new Scanner("1 Jake jake@gmail.com 0777777778");

        //Act
        main.menu(mockScanner);

        //Assert
        assertEquals("Jake", main.book.getContactList().get(0).getName());
        assertEquals("jake@gmail.com", main.book.getContactList().get(0).getNumber());
        assertEquals("0777777778", main.book.getContactList().get(0).getEmail());
    }

    @Test
    @DisplayName("Does `menu()` progress if it's given a '2' input, and can a user then remove a contact?")
    public void menuTest2() {
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("2 Jake");

        //Act
        main.menu(scanner2);

        //Assert
        assertEquals(0, main.book.getContactList().size());
    }

    @Test
    @DisplayName("Does trying to remove a contact through the `menu()` that doesn't exist warn the user?")
    public void menuTest3() {
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("2 Jim");

        //Act
        main.menu(scanner2);

        //Assert
        assertEquals(1, main.book.getContactList().size());
    }

    @Test
    @DisplayName("Does `menu()` progress if it's given a '3' input, and can a user then find a contact by name?")
    public void menuTest4() {
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("3 Jake");

        //Act
        main.menu(scanner2);

        //Assert
        //Test returns the correct corresponding print statement.
    }

    @Test
    @DisplayName("Does `editContact()` allow the user to edit a given Contact?")
    public void menuTest5() {
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("4 Jake 1 Jim");
        Scanner scanner3 = new Scanner("4 Jim 2 jim@gmail.com");
        Scanner scanner4 = new Scanner("4 Jim 3 0799999998");

        //Act
        main.menu(scanner2);
        main.menu(scanner3);
        main.menu(scanner4);

        //Assert
        assertEquals("Jim", main.book.getContactList().get(0).getName());
        assertEquals("jim@gmail.com", main.book.getContactList().get(0).getNumber());
        assertEquals("0799999998", main.book.getContactList().get(0).getEmail());
    }

    @Test
    @DisplayName("Does duplicate data not get input into the AddressBook when using `addContact()`")
    public void menuTest6(){
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778");
        Scanner scanner2 = new Scanner("1 Jake jake@gmail.com 0777777778");

        //Act
        main.menu(scanner1);
        main.menu(scanner2);

        //Assert
        assertEquals(1, main.book.getContactList().size());
    }
}
