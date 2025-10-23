// This JUnit test class verifies that the Task class and its validation logic work correctly.
// It checks both successful object creation and that exceptions are thrown for invalid data.

import org.ContactService.Task;
import org.junit.Assert;
import org.junit.Test;

public class TaskTest {

    // Test successful creation of a contact object.
    @Test
    public void testTaskCreationSuccess() {
        Task task = new Task("12345", "TestTask01", "A Test Task");
        Assert.assertNotNull(task);
        Assert.assertEquals("12345", task.getTaskID());
        Assert.assertEquals("TestTask01", task.getTaskName());
        Assert.assertEquals("A Test Task", task.getTaskDescription());
    }

    // Test that constructor throws exception for invalid task ID (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdTooLong() {
        new Task("12345678901", "TooLongID", "This ID should be too long");
    }

    // Test that constructor throws exception for null task ID.
    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdNull() {
        new Task(null, "NullID", "This ID is null");
    }

    // Test that constructor throws exception for invalid name (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testNameTooLong() {
        new Task("12345", "AllTheNamesAreTooLong", "Too Long?");
    }

    // Test that constructor throws exception for null name.
    @Test(expected = IllegalArgumentException.class)
    public void testNameNull() {
        new Task("12345", null, "Doe");
    }

    // Test that constructor throws exception for invalid last name (too long).
    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionTooLong() {
        new Task("12345", "John", "A really, really, really, looooooong Description that should be too long for the constructor to handle!!!!!!! And some more just to be safe. I guess I could have just pasted a char 8 times.");
    }

    // Test that constructor throws exception for null last name.
    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionNull() {
        new Task("12345", "John", null);
    }
}
