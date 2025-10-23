// This JUnit test class verifies that the Appointment class and its validation logic work correctly.
// It checks both successful object creation and that exceptions are thrown for invalid data.

import org.ContactService.Appointment;
import org.ContactService.Task;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class AppointmentTest {
    // Test successful creation of an appointment object.
    @Test
    public void testAppointmentCreationSuccess() {
        Appointment appointment = new Appointment("12345", new Date(2026 + 1900, 5, 5), "A Test Apt");
        Assert.assertNotNull(appointment);
        Assert.assertEquals("12345", appointment.getAppointmentID());
        Assert.assertEquals(new Date(2026 + 1900, 5, 5), appointment.getAppointmentDate());
        Assert.assertEquals("A Test Apt", appointment.getAppointmentDescription());
    }

    // Test that constructor throws exception for invalid Apt ID (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIdTooLong() {
        new Appointment("12345678901", new Date(), "This ID should be too long");
    }

    // Test that constructor throws exception for null Apt ID.
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIdNull() {
        new Appointment(null, new Date(), "This ID is null");
    }

    // Test that constructor throws exception for invalid Apt date
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDate() {
        new Appointment("12345678901", new Date(0, Calendar.JANUARY, 1), "This Date is too old!");
    }

    // Test that constructor throws exception for null Apt date.
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateNull() {
        new Appointment(null, new Date(), "This ID is null");
    }
}
