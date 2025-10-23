// Task.java
/* The Task object used for storing contact data
 */

package org.ContactService;

public class Task {

    // Task Data
    private final String taskID;
    private String taskName;
    private String taskDescription;

    // Constructor

    public Task(String _taskID, String _taskName, String _taskDescription) {
        this.taskID = _taskID;
        this.taskName = _taskName;
        this.taskDescription = _taskDescription;

        // -- Validation --
        // ID
        if (taskID == null || taskID.length() > 10){
            throw new IllegalArgumentException("Invalid Task ID");
        }

        // Name
        if (taskName == null || taskName.length() > 20){
            throw new IllegalArgumentException("Invalid Task Name");
        }

        // Description
        if (taskDescription == null || taskDescription.length() > 50){
            throw new IllegalArgumentException("Invalid Task Description");
        }
    }


    // Getters
    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    // Setters with Validation

    public void setTaskName(String _taskName) {
        if (_taskName == null || _taskName.length() > 20){
            throw new IllegalArgumentException("Invalid Task Name");
        }
        this.taskName = _taskName;
    }

    public void setTaskDescription(String _taskDescription) {
        if (_taskDescription == null || _taskDescription.length() > 20){
            throw new IllegalArgumentException("Invalid Task Name");
        }
        this.taskDescription = _taskDescription;
    }
}
