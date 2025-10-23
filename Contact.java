// Contact.java
/* The Contact object used for storing contact data
 */


package org.ContactService;

public class Contact {

    // Contact Data
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Constructor with validation
    public Contact(String _ID, String _firstName, String _lastName, String _phone, String _address) {
        this.contactID = _ID;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.phoneNumber = _phone;
        this.address = _address;

        // Validate contactID
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid Contact ID");
        }
        // Validate firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        // Validate lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        // Validate phoneNumber
        if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
    }

    // --- Getters ---
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // --- Setters with Validation ---
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = address;
    }
}
