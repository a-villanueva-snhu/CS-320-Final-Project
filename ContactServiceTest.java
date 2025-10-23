// ContactServiceTest.java

// ensures that users can correctly add, delete,
// and update contacts, and that the service properly handles cases like duplicate IDs.


import org.ContactService.Contact;
import org.ContactService.ContactService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact1;
    private Contact contact2;

    // Use @Before to set up a clean service and contacts before each test.
    @Before
    public void setUp() {
        service = new ContactService();
        contact1 = new Contact("ID001", "Jane", "Doe", "0987654321", "456 Oak Ave");
        contact2 = new Contact("ID002", "Peter", "Jones", "5551234567", "789 Pine Ln");
    }

    // Test adding a contact successfully.
    @Test
    public void testAddContactSuccess() {
        service.addContact(contact1);
        assertNotNull(service.getContact("ID001"));
        assertEquals("Jane", service.getContact("ID001").getFirstName());
    }

    // Test that adding a contact with a duplicate ID throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContactId() {
        service.addContact(contact1);
        service.addContact(contact1); // Attempt to add the same contact again
    }

    // Test deleting a contact successfully.
    @Test
    public void testDeleteContactSuccess() {
        service.addContact(contact1);
        assertNotNull(service.getContact("ID001")); // Verify it's there
        service.deleteContact("ID001");
        assertNull(service.getContact("ID001")); // Verify it's gone
    }

    // Test that deleting a non-existent contact throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentContact() {
        service.deleteContact("ID999");
    }

    // Test updating a contact successfully.
    @Test
    public void testUpdateContactSuccess() {
        service.addContact(contact2);
        // Update fields for contact with ID "ID002"
        service.updateContact("ID002", "Peter", "Smith", "1112223333", "101 New Rd");

        Contact updatedContact = service.getContact("ID002");
        assertEquals("Peter", updatedContact.getFirstName()); // First name is same
        assertEquals("Smith", updatedContact.getLastName()); // Last name changed
        assertEquals("1112223333", updatedContact.getPhoneNumber()); // Phone changed
        assertEquals("101 New Rd", updatedContact.getAddress()); // Address changed
    }

    // Test that updating a non-existent contact throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistentContact() {
        service.updateContact("ID999", "A", "B", "1234567890", "C");
    }
}
