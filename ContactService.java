// ContactService.java
/* This is the Contact Service for the SNHU-320 mobile app
 *
 * It uses a HashMap to store contacts in memory, using the unique contactID as the key.
 * This makes adding, deleting, and finding contacts very efficient,
 * but may lead to performance issues with extremely large contact count or slow hardware
 *
 * SNHU CS-320
 * Version : Project Milestone I v1.0
 * Author : Aiden Villanueva
 * Date : Sept. 25, 2025
 */


package org.ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // In-memory storage for contacts using a HashMap for quick lookups.
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact. Throws an exception if the contact ID already exists.
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete a contact by its ID.
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactID);
    }

    // Update an existing contact's fields.
    public void updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        // Use the setters from the Contact class which contain the validation logic.
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setAddress(address);
    }

    // Helper method to retrieve a contact, useful for testing.
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
