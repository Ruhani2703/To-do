package org.Sevices;

import org.entities.Task;
import java.util.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int idCounter = 1;

    public void addTask(String title, String description) {
        Task newTask = new Task(idCounter++, title, description);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void completeTask(int taskId) {
        Task taskToComplete = tasks.stream()
                .filter(task -> task.getId() == taskId)
                .findFirst()
                .orElse(null);
        if (taskToComplete != null) {
            taskToComplete.setCompleted(true);
            System.out.println("Task completed: " + taskToComplete);
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    public void deleteTask(int taskId) {
        Task taskToDelete = tasks.stream()
                .filter(task -> task.getId() == taskId)
                .findFirst()
                .orElse(null);
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task deleted: " + taskToDelete);
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }
}
