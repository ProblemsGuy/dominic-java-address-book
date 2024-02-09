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
}