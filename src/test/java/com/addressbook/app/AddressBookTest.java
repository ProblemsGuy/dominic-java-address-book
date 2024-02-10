package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressBookTest {

    @Test
    @DisplayName("Does a contact equivalent to the parameter get added to the address book after `addContact()` is run?")
    public void testAddContact1() {
        //Arrange
        Contact mockContact = mock(Contact.class);
        AddressBook testBook = new AddressBook(new ArrayList<>());
        when(mockContact.getName()).thenReturn("Jake");

        //Act
        testBook.addContact(mockContact);

        //Assert
        assertEquals(testBook.getContactList().get(0).getName(),"Jake");
    }

    @Test
    @DisplayName("Does a contact get removed when `removeContact()` is run with a contact in the list?")
    public void testRemoveContact1(){
        //Arrange
        AddressBook testBook = new AddressBook(new ArrayList<>());
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn("Jake");
        testBook.addContact(mockContact);
        String name = "Jake";

        //Act
        testBook.removeContact(name);

        //Assert
        assertSame(testBook.getContactList().size(),0);
    }

    @Test
    @DisplayName("Does an error get thrown by `removeContact()` when a contact not in the list get removed?")
    public void testRemoveContact2(){
        //Arrange
        AddressBook testBook = new AddressBook(new ArrayList<>());
        String name = "Jake";

        //Act

        //Assert
        assertThrows(IndexOutOfBoundsException.class, () -> testBook.removeContact(name));
    }

    @Test
    @DisplayName("Does the data in the edited contact get changed when `editContact()` is run?")
    public void testEditContact1(){
        //Arrange
        AddressBook testBook = new AddressBook(new ArrayList<>());
        Contact mockContact1 = mock(Contact.class);
        Contact mockContact2 = mock(Contact.class);
        when(mockContact1.getName()).thenReturn("Jake");
        when(mockContact2.getName()).thenReturn("Sophie");
        testBook.addContact(mockContact1);

        //Act
        testBook.editContact(mockContact1,mockContact2);

        //Assert
        assertEquals("Sophie",testBook.getContactList().get(0).getName());
    }

    @Test
    @DisplayName("Does an error get thrown by `editContact()` when a contact not in the list gets edited?")
    public void testEditContact2(){
        //Arrange
        AddressBook testBook = new AddressBook(new ArrayList<>());
        Contact mockContact1 = mock(Contact.class);
        Contact mockContact2 = mock(Contact.class);
        when(mockContact1.getName()).thenReturn("Jake");
        when(mockContact2.getName()).thenReturn("Sophie");

        //Act

        //Assert
        assertThrows(IndexOutOfBoundsException.class, () -> testBook.editContact(mockContact1,mockContact2));
    }

    @Test
    @DisplayName("Does `checkDuplicatedName()` return true when the parameter is included in the `contactList`?")
    public void testDuplicateData1(){
        //Arrange
        AddressBook testBook = new AddressBook(new ArrayList<>());
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn("Jake");
        testBook.addContact(mockContact);

        //Act
        boolean expectedValue = testBook.checkDuplicatedName("Jake");

        //Assert
        assertTrue(expectedValue);
    }

    @Test
    @DisplayName("Does `checkDuplicatedNumber()` return true when the parameter is included in the `contactList`?")
    public void testDuplicateData2(){
        //Arrange
        AddressBook testBook = new AddressBook(new ArrayList<>());
        Contact mockContact = mock(Contact.class);
        when(mockContact.getNumber()).thenReturn("0782203870");
        testBook.addContact(mockContact);

        //Act
        boolean expectedValue = testBook.checkDuplicatedNumber("0782203870");

        //Assert
        assertTrue(expectedValue);
    }

    @Test
    @DisplayName("Does `checkDuplicatedEmail()` return true when the parameter is included in the `contactList`?")
    public void testDuplicateData3(){
        //Arrange
        AddressBook testBook = new AddressBook(new ArrayList<>());
        Contact mockContact = mock(Contact.class);
        when(mockContact.getEmail()).thenReturn("a@gmail.com");
        testBook.addContact(mockContact);

        //Act
        boolean expectedValue = testBook.checkDuplicatedEmail("a@gmail.com");

        //Assert
        assertTrue(expectedValue);
    }
}