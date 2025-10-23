// TaskService.java
/* This is the Task Service for the SNHU-320 mobile app
 *
 * It uses a HashMap to store tasks in memory, using the unique taskID as the key.
 *
 * SNHU CS-320
 * Version : Project Milestone I v1.1
 * Author : Aiden Villanueva
 * Date : Sept. 25, 2025
 */


package org.ContactService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // In-memory storage for Tasks using a HashMap for quick lookups.
    private final Map<String, Task> tasks = new HashMap<>();

    // Add a new Task. Throws an exception if the Task ID already exists.
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskID(), task);
    }

    // Delete a Task by its ID. Throws if task is not found.
    public void deleteTask(String _taskID) {
        if (!tasks.containsKey(_taskID)) {
            throw new IllegalArgumentException("Task ID " + _taskID + " not found.");
        }
        tasks.remove(_taskID);
    }

    // Update an existing Task's fields.
    public void updateTask(String _taskID, String _taskName, String _taskDescription) {
        Task task = tasks.get(_taskID);
        if (task == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        // Use the setters from the Task class which contain the validation logic.
        task.setTaskName(_taskName);
        task.setTaskDescription(_taskDescription);
    }

    // Helper method to retrieve a contact, useful for testing.
    public Task getTask(String _taskID) {
        return tasks.get(_taskID);
    }

}
