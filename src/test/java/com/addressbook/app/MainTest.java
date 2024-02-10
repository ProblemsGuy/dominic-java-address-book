package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MainTest {

    @Test
    @DisplayName("Does `menu()` progress if it's given a '1' input, and can a user then add a contact?")
    public void menuTest1(){
        //Arrange
        Main main = new Main();
        Scanner mockScanner = new Scanner("1 Jake jake@gmail.com 0777777778");

        //Act
        main.menu(mockScanner);

        //Assert
        assertEquals("Jake",main.book.getContactList().get(0).getName());
        assertEquals("jake@gmail.com",main.book.getContactList().get(0).getNumber());
        assertEquals("0777777778",main.book.getContactList().get(0).getEmail());
    }

    @Test
    @DisplayName("Does `menu()` progress if it's given a '2' input, and can a user then remove a contact?")
    public void menuTest2(){
        //Arrange
        Main main = new Main();
        Scanner scanner1 = new Scanner("1 Jake jake@gmail.com 0777777778");
        main.menu(scanner1);
        Scanner scanner2 = new Scanner("2 Jake");

        //Act
        main.menu(scanner2);

        //Assert
        assertEquals(0,main.book.getContactList().size());
    }


}
