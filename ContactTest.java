// This JUnit test class verifies that the Contact class and its validation logic work correctly.
// It checks both successful object creation and that exceptions are thrown for invalid data.

import org.junit.Assert;
import org.junit.Test;
import org.ContactService.Contact;

public class ContactTest {

    // Test successful creation of a contact object.
    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Assert.assertNotNull(contact);
        Assert.assertEquals("12345", contact.getContactID());
        Assert.assertEquals("John", contact.getFirstName());
        Assert.assertEquals("Doe", contact.getLastName());
        Assert.assertEquals("1234567890", contact.getPhoneNumber());
        Assert.assertEquals("123 Main St", contact.getAddress());
    }

    // Test that constructor throws exception for invalid contact ID (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testContactIdTooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    // Test that constructor throws exception for null contact ID.
    @Test(expected = IllegalArgumentException.class)
    public void testContactIdNull() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    // Test that constructor throws exception for invalid first name (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameTooLong() {
        new Contact("12345", "Johnathanius", "Doe", "1234567890", "123 Main St");
    }

    // Test that constructor throws exception for null first name.
    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameNull() {
        new Contact("12345", null, "Doe", "1234567890", "123 Main St");
    }

    // Test that constructor throws exception for invalid last name (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testLastNameTooLong() {
        new Contact("12345", "John", "Doenbeighmmer", "1234567890", "123 Main St");
    }

    // Test that constructor throws exception for null last name.
    @Test(expected = IllegalArgumentException.class)
    public void testLastNameNull() {
        new Contact("12345", "John", null, "1234567890", "123 Main St");
    }

    // Test that constructor throws exception for invalid phone number (not 10 digits).
    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNumberNot10Digits() {
        new Contact("12345", "John", "Doe", "12345", "123 Main St");
    }

    // Test that constructor throws exception for null phone number.
    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNumberNull() {
        new Contact("12345", "John", "Doe", null, "123 Main St");
    }

    // Test that constructor throws exception for invalid address (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testAddressTooLong() {
        new Contact("12345", "John", "Doe", "1234567890", "123 Main Street Anytown, USA 123456");
    }

    // Test that constructor throws exception for null address.
    @Test(expected = IllegalArgumentException.class)
    public void testAddressNull() {
        new Contact("12345", "John", "Doe", "1234567890", null);
    }
}
