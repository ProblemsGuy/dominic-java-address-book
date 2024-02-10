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
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(1);
        when(mockScanner.next()).thenReturn("Jake");

        //Act
        main.menu(mockScanner);

        //Assert
        assertEquals("Jake",main.book.getContactList().get(0).getName());
        assertEquals("Jake",main.book.getContactList().get(0).getNumber());
        assertEquals("Jake",main.book.getContactList().get(0).getEmail());
    }
}
