package com.addressbook.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressBookAITest {

    @Test
    void testClearAllContacts() {
        // Create a mock for the Contact class (assuming it has external dependencies)
        Contact contactMock = Mockito.mock(Contact.class);

        // Create a spy for the List class to check if clear() is called
        List<Contact> contactsSpy = spy(new ArrayList<>());

        // Create an instance of the AddressBook class
        AddressBook addressBook = new AddressBook(contactsSpy);

        // Add a contact to the address book
        addressBook.addContact(contactMock);

        // Verify that the contact is initially added
        assertEquals(1, addressBook.getContactList().size());

        // Call the method to be tested
        addressBook.clearAllContacts();

        // Verify that clear() is called on the spy
        verify(contactsSpy, times(1)).clear();

        // Verify that the contact list is now empty
        assertEquals(0, addressBook.getContactList().size());
    }
}
