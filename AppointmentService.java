// AppointmentService.java
/* This is the Appointment Service for the SNHU-320 mobile app
 *
 * It uses a HashMap to store tasks in memory, using the unique taskID as the key.
 *
 * SNHU CS-320
 * Version : Project Milestone III v1.2
 * Author : Aiden Villanueva
 * Date : Sept. 25, 2025
 */


package org.ContactService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // In-memory storage for Tasks using a HashMap for quick lookups.
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Add a new Task. Throws an exception if the Task ID already exists.
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    // Delete an Appointment by its ID. Throws if Apt. is not found.
    public void deleteAppointment(String _aptID) {
        if (!appointments.containsKey(_aptID)) {
            throw new IllegalArgumentException("Appointment " + _aptID + " not found.");
        }
        appointments.remove(_aptID);
    }

    // Update an existing Appointment's fields.
    public void updateAppointmentk(String _aptID, Date _aptDate, String _aptDescription) {
        Appointment appointment = appointments.get(_aptID);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment not found.");
        }

        // Use the setters from the Appointment class which contain the validation logic.
        appointment.setAppointmentDate(_aptDate);
        appointment.setAppointmentDescription(_aptDescription);
    }

    // Helper method to retrieve an Appointment, useful for testing.
    public Appointment getAppointment(String _aptID) {
        return appointments.get(_aptID);
    }

}
