## AI assited further features

### User stories

1. As a user, I want to clear all contacts from an Address Book, so I can remove all contacts at once and create a new contact list from scratch.

### Class Diagram - Provided by ChatGPT

```mermaid
classDiagram
  class AddressBook {
    -contacts: List<Contact>
    +addContact(contact: Contact): void
    +removeContact(contact: Contact): void
    +clearAllContacts(): void
    +getContactList(): List<Contact>
  }

  class Contact {
    +name: string
    +email: string
    +phoneNumber: string
  }

  AddressBook "1" *-- "0..*" Contact
```

#### Evidence:
![Mermaid diagram screenshot](./images/classDiagram_screenshot.png)

### Java Code

#### Evidence:
![Java Code Screenshot](./images/javacode_screenshot.png)

### Unit Test

#### Evidence:

![Unit Test question](./images/unitTest_question.png)
![Unit Test code](./images/unitTest_code.png)
