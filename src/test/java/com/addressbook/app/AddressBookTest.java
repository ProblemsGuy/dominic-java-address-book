package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressBookTest {

    @Test
    @DisplayName("Does a contact equivalent to the parameter get added to the address book after `addContact()` is run?")
    public void testAddContact1() {
        //Arrange
        AddressBook testBook = new AddressBook();
        Contact mockContact = mock(Contact.class);
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
        AddressBook testBook = new AddressBook();
        Contact mockContact = mock(Contact.class);
        testBook.addContact(mockContact);

        //Act
        testBook.removeContact(mockContact);

        //Assert
        assertEquals(testBook.getContactList().size(),0);
    }

    @Test
    @DisplayName("Does an error get thrown by `removeContact()` when a contact not in the list get removed?")
    public void testRemoveContact2(){
        //Arrange
        AddressBook testBook = new AddressBook();
        Contact mockContact = mock(Contact.class);


        //Act

        //Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testBook.removeContact(mockContact);
        });
    }

    @Test
    @DisplayName("Does the data in the edited contact get changed when `editContact()` is run?")
    public void testEditContact1(){
        //Arrange
        AddressBook testBook = new AddressBook();
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
    @DisplayName("Does the data in the edited contact get changed when `editContact()` is run?")
    public void testEditContact2(){
        //Arrange
        AddressBook testBook = new AddressBook();
        Contact mockContact1 = mock(Contact.class);
        Contact mockContact2 = mock(Contact.class);
        when(mockContact1.getName()).thenReturn("Jake");
        when(mockContact2.getName()).thenReturn("Sophie");

        //Act

        //Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testBook.editContact(mockContact1,mockContact2);
        });
    }

    @Test
    @DisplayName("Does `checkDuplicatedName()` return true when the parameter is included in the `contactList`?")
    public void testDuplicateData1(){
        //Arrange
        AddressBook testBook = new AddressBook();
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn("Jake");
        testBook.addContact(mockContact);

        //Act
        boolean expectedValue = testBook.checkDuplicatedName("Jake");

        //Assert
        assertTrue(expectedValue);
    }
}