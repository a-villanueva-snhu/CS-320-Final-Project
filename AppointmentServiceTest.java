// AppointmentServiceTest.java
// ensures that users can correctly add, delete,
// and update Appointments, and that the service properly handles cases like duplicate IDs.


import org.ContactService.Appointment;
import org.ContactService.AppointmentService;
import org.ContactService.Task;
import org.ContactService.TaskService;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentServiceTest {

    private AppointmentService service;
    private Appointment apt1;
    private Appointment apt2;

    // Use @Before to set up a clean service and contacts before each test.
    @Before
    public void setUp() {
        service = new AppointmentService();
        apt1 = new Appointment("APT001", new Date(), "An Appointment!");
        apt2 = new Appointment("APT002", new Date(), "Another Appointment!");
    }

    // Test adding an appointment successfully.
    @Test
    public void testAddAptSuccess() {
        service.addAppointment(apt1);
        assertNotNull(service.getAppointment("APT001"));
        assertEquals("An Appointment!", service.getAppointment("APT001").getAppointmentDescription());
    }

    // Test that adding a appointment with a duplicate ID throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAptId() {
        service.addAppointment(apt1);
        service.addAppointment(apt1); // Attempt to add the same contact again
    }

    // Test deleting a appointment successfully.
    @Test
    public void testDeleteTaskSuccess() {
        service.addAppointment(apt1);
        assertNotNull(service.getAppointment("APT001")); // Verify it's there
        service.deleteAppointment("APT001");
        assertNull(service.getAppointment("APT001")); // Verify it's gone
    }

    // Test that deleting a non-existent appointment throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentApt() {
        service.deleteAppointment("APT999");
    }

    // Test updating an appointment successfully.
    @Test
    public void testUpdateAptSuccess() {
        service.addAppointment(apt2);
        // Update fields for contact with ID "APT002"
        service.updateAppointmentk("APT002", new Date(), "Updated!");

        Appointment updatedApt = service.getAppointment("APT002");
        assertEquals("APT002", updatedApt.getAppointmentID()); // ID changed
        assertEquals("Updated!", updatedApt.getAppointmentDescription()); // Description changed
    }

    // Test that updating a non-existent appointment throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistentApt() {
        service.updateAppointmentk("APT999", new Date(), "B");
    }
}
