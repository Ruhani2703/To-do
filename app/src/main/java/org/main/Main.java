package org.main;
import org.Sevices.TaskManager;
import org.entities.Task;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Display menu to the user
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    // Add a new task
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(title, description);
                    break;
                case 2:
                    // View all tasks
                    taskManager.viewTasks();
                    break;
                case 3:
                    // Mark task as completed
                    System.out.print("Enter task ID to mark as completed: ");
                    int taskId = scanner.nextInt();
                    taskManager.completeTask(taskId);
                    break;
                case 4:
                    // Delete a task
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;
                case 5:
                    // Exit the application
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
