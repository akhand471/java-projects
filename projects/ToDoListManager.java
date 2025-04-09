import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public String toString() {
        return (isDone ? "[✔] " : "[ ] ") + title;
    }
}

public class ToDoListManager {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("📝 Welcome to Java To-Do List Manager!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewTasks();
                case 2 -> addTask();
                case 3 -> markTaskDone();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("👋 Exiting... Have a productive day!");
                    exit = true;
                }
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        }
    }

    // View all tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println(" No tasks yet!");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Add a task
    public static void addTask() {
        System.out.print("Enter task description: ");
        String title = sc.nextLine();
        tasks.add(new Task(title));
        System.out.println("✅ Task added!");
    }

    // Mark a task as done
    public static void markTaskDone() {
        viewTasks();
        System.out.print("Enter task number to mark as done: ");
        int index = sc.nextInt() - 1;
        if (isValidIndex(index)) {
            tasks.get(index).markDone();
            System.out.println("🎉 Task marked as done!");
        } else {
            System.out.println("❌ Invalid task number.");
        }
    }

    // Delete a task
    public static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt() - 1;
        if (isValidIndex(index)) {
            tasks.remove(index);
            System.out.println("🗑 Task deleted.");
        } else {
            System.out.println("❌ Invalid task number.");
        }
    }

    // Helper: Check index validity
    public static boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}
