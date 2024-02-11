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
        Scanner mockScanner = new Scanner("1 Jake jake@gmail.com 0777777778 9");

        //Act
        main.menu(mockScanner);

        //Assert
        assertEquals("Jake", main.book.getContactList().get(0).getName());
        assertEquals("jake@gmail.com", main.book.getContactList().get(0).getEmail());
        assertEquals("0777777778", main.book.getContactList().get(0).getNumber());
    }

    @Test
    @DisplayName("Does `menu()` progress if it's given a '2' input, and can a user then remove a contact?")
    public void menuTest2() {
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778 9");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("2 Jake 9");

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
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778 9");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("2 Jim 9");

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
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778 9");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("3 Jake 9");

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
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778 4 Jake 1 Jim 4 Jim 3 jim@gmail.com 4 Jim 2 0799999998 9");

        //Act
        main.menu(scanner1);

        //Assert
        assertEquals("Jim", main.book.getContactList().get(0).getName());
        assertEquals("jim@gmail.com", main.book.getContactList().get(0).getEmail());
        assertEquals("0799999998", main.book.getContactList().get(0).getNumber());
    }

    @Test
    @DisplayName("Does duplicate data not get input into the AddressBook when using `addContact()`")
    public void menuTest6(){
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778 1 Jake Jim jake@gmail.com jim@gmail.com 0777777778 0799999998 9");

        //Act
        main.menu(scanner1);

        //Assert
        assertEquals("Jim", main.book.getContactList().get(1).getName());
        assertEquals("jim@gmail.com", main.book.getContactList().get(1).getEmail());
        assertEquals("0799999998", main.book.getContactList().get(1).getNumber());
    }

    @Test
    @DisplayName("Checking that printing the list works.")
    public void menuTest7(){
        Main main = new Main();
        Scanner scanner = new Scanner("1 Jake jake@gmail.com 0777777778 1 Jim jim@gmail.com 0777777779 1 Jill jill@hotmail.com 0787878787 5 9");

        main.menu(scanner);
    }

    @Test
    @DisplayName("Does duplicate data not get input into the AddressBook when using `editContact()`?")
    public void menuTest8(){
        Main main = new Main();
        Scanner scanner = new Scanner("1 Jake jake@gmail.com 0777777778 1 Jim jim@gmail.com 0777777779 4 Jake 1 Jim Jill 4 Jill 3 jim@gmail.com jill@hotmail.com 4 Jill 2 0777777779 0787878787 9");

        //Act
        main.menu(scanner);

        //Assert
        assertEquals("Jill", main.book.getContactList().get(0).getName());
        assertEquals("jill@hotmail.com", main.book.getContactList().get(0).getEmail());
        assertEquals("0787878787", main.book.getContactList().get(0).getNumber());
    }

    @Test
    @DisplayName("Does a name without a capital letter at the start not get passed into the Contact?")
    public void menuEdgeCaseNames(){
        Main main = new Main();
        Scanner scanner = new Scanner("1 j2ake Jake jake@gmail.com 0777777778 9");

        //Act
        main.menu(scanner);

        //Assert
        assertEquals("Jake", main.book.getContactList().get(0).getName());
    }

    @Test
    @DisplayName("Does a number which doesn't follow the `^[0-9*#]$` structure not get passed into the Contact?")
    public void menuEdgeCaseNumbers(){
        Main main = new Main();
        Scanner scanner = new Scanner("1 Jake jake@gmail.com stabstabstabstab 0777777778 9");

        //Act
        main.menu(scanner);

        //Assert
        assertEquals("0777777778", main.book.getContactList().get(0).getNumber());
    }

    @Test
    @DisplayName("Does an email which doesn't follow the `^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$` not get passed into the Contact?")
    public void menuEdgeCaseEmail(){
        Main main = new Main();
        Scanner scanner = new Scanner("1 Jake jill258.loll jake@gmail.com 0777777778 9");

        //Act
        main.menu(scanner);

        //Assert
        assertEquals("jake@gmail.com", main.book.getContactList().get(0).getEmail());
    }
}
