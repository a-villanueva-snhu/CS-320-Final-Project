// TaskServiceTest.java
// ensures that users can correctly add, delete,
// and update Tasks, and that the service properly handles cases like duplicate IDs.


import org.ContactService.Task;
import org.ContactService.TaskService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskServiceTest {

    private TaskService service;
    private Task task1;
    private Task task2;

    // Use @Before to set up a clean service and contacts before each test.
    @Before
    public void setUp() {
        service = new TaskService();
        task1 = new Task("ID001", "Task1", "A Task!");
        task2 = new Task("ID002", "Task 02", "Another task?");
    }

    // Test adding a task successfully.
    @Test
    public void testAddTaskSuccess() {
        service.addTask(task1);
        assertNotNull(service.getTask("ID001"));
        assertEquals("Task1", service.getTask("ID001").getTaskName());
    }

    // Test that adding a task with a duplicate ID throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateTaskId() {
        service.addTask(task1);
        service.addTask(task1); // Attempt to add the same contact again
    }

    // Test deleting a task successfully.
    @Test
    public void testDeleteTaskSuccess() {
        service.addTask(task1);
        assertNotNull(service.getTask("ID001")); // Verify it's there
        service.deleteTask("ID001");
        assertNull(service.getTask("ID001")); // Verify it's gone
    }

    // Test that deleting a non-existent task throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentTask() {
        service.deleteTask("ID999");
    }

    // Test updating a contact successfully.
    @Test
    public void testUpdateTaskSuccess() {
        service.addTask(task2);
        // Update fields for contact with ID "ID002"
        service.updateTask("ID002", "Task 2", "Updated!");

        Task updatedTask = service.getTask("ID002");
        assertEquals("Task 2", updatedTask.getTaskName()); // Name changed
        assertEquals("Updated!", updatedTask.getTaskDescription()); // Description changed
    }

    // Test that updating a non-existent task throws an exception.
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistentTask() {
        service.updateTask("ID999", "A", "B");
    }
}
