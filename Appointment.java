// Appointment.java
/* The Appointment object used for storing contact data
 */

package org.ContactService;

import java.util.Date;

public class Appointment {

    // Task Data
    private final String aptID;
    private Date aptDate;
    private String aptDescription;

    // Constructor

    public Appointment(String _aptID, Date _aptDate, String _aptDescription) {
        this.aptID = _aptID;
        this.aptDate = _aptDate;
        this.aptDescription = _aptDescription;

        // -- Validation --
        // ID
        if (aptID == null || aptID.length() > 10){
            throw new IllegalArgumentException("Invalid Appointment ID");
        }

        // Date
        if (aptDate == null || aptDate.before(new Date())){
            throw new IllegalArgumentException("Invalid Appointment Date");
        }

        // Description
        if (aptDescription == null || aptDescription.length() > 50){
            throw new IllegalArgumentException("Invalid Task Description");
        }
    }


    // Getters
    public String getAppointmentID() {
        return aptID;
    }

    public Date getAppointmentDate() {
        return aptDate;
    }

    public String getAppointmentDescription() {
        return aptDescription;
    }

    // Setters with Validation

    public void setAppointmentDate(Date _aptDate) {
        if (_aptDate == null || aptDate.before(new Date())){
            throw new IllegalArgumentException("Invalid Task Date");
        }
        this.aptDate = _aptDate;
    }

    public void setAppointmentDescription(String _aptDescription) {
        if (_aptDescription == null || _aptDescription.length() > 50){
            throw new IllegalArgumentException("Invalid Appointment Description");
        }
        this.aptDescription = _aptDescription;
    }
}
