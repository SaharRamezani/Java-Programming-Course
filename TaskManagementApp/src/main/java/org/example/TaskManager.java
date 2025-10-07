package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "task-manager", mixinStandardHelpOptions = true, version = "1.0",
        description = "A simple task manager to add, list, and complete tasks.")
public class TaskManager implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);
    private static final String FILE_NAME = "tasks.dat";
    static int nextId = 1;
    List<Task> tasks = new ArrayList<>();

    // -a or --add <description> : Add a new task
    // -l or --list : List all tasks
    // -d or --done <taskId> : Mark a task as done
    @CommandLine.Option(names = {"-a", "--add"}, description = "Add a new task")
    String newTask;

    @CommandLine.Option(names = {"-l", "--list"}, description = "List all tasks")
    boolean list;

    @CommandLine.Option(names = {"-d", "--done"}, description = "Mark task as done")
    int done = -1; // مقدار پیش فرض نامعتبر برای فهمیدن اینکه این گزینه داده شده یا نه
   
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
            logger.warn("Attempted to add task with empty description.");
            return;
        }
        Task task = new Task(nextId++, description.trim());
        tasks.add(task);
        saveTasksToFile();
        System.out.println("Task added successfully.");
    }

    public void markTaskAsDone(int taskId) {
        if (taskId <= 0) {
            System.out.println("Error: Invalid task ID.");
            logger.warn("Attempted to mark task with invalid ID: {}", taskId);
            return;
        }
        
        try {
            // Ensure tasks list is not null
            if (tasks == null) {
                tasks = new ArrayList<>();
            }
            
            Task task = findTaskById(taskId);
            if (task != null) {
                task.markAsDone();
                saveTasksToFile();
                System.out.println("Task marked as done.");
                logger.info("Marked task as done: {}", task);
            } else {
                System.out.println("Error: Task with ID " + taskId + " not found.");
                logger.warn("Attempted to mark non-existent task as done: {}", taskId);
            }
        } catch (Exception e) {
            System.out.println("Error: Failed to mark task as done.");
            logger.error("Failed to mark task as done: {}", taskId, e);
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
        logger.info("Listed all tasks.");
    }

    private void saveTasksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            logger.error("Failed to save tasks to file", e);
        }
    }

    private void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                Object obj = ois.readObject();
                if (obj instanceof List<?>) {
                    @SuppressWarnings("unchecked")
                    List<Task> loadedTasks = (List<Task>) obj;
                    tasks = loadedTasks;
                    if (!tasks.isEmpty()) {
                        nextId = tasks.get(tasks.size() - 1).getId() + 1;
                    }
                } else {
                    logger.warn("File contains invalid data format. Initializing empty task list.");
                    tasks = new ArrayList<>();
                }
            } catch (IOException | ClassNotFoundException e) {
                logger.error("Failed to load tasks from file", e);
                // Initialize empty list if loading fails
                if (tasks == null) {
                    tasks = new ArrayList<>();
                }
            }
        } else {
            // If file doesn't exist, initialize empty list
            if (tasks == null) {
                tasks = new ArrayList<>();
            }
        }
    }

    private Task findTaskById(int id) {
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void run() {
        loadTasksFromFile();
        if (newTask != null) {
            addTask(newTask);
        } else if (list) {
            listTasks();
        } else if (done != -1) {
            markTaskAsDone(done);
        } else {
            System.out.println("No valid command provided. Use --help for usage information.");
        }
    }
}
