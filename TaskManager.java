import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int idCounter;

    public TaskManager() {
        tasks = new ArrayList<>();
        idCounter = 1; // Start with task ID 1
    }

    // Add a new task
    public void addTask(String title, String description) {
        Task newTask = new Task(idCounter++, title, description);
        tasks.add(newTask);
        System.out.println("Task added successfully.\n");
    }

    // View all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    // Update a task
    public void updateTask(int id, String newTitle, String newDescription, String newStatus) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            task.setStatus(newStatus);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // Delete a task
    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // Find a task by ID
    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    // View tasks by status
    public void viewTasksByStatus(String status) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(status)) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks with status: " + status);
        }
    }
}
