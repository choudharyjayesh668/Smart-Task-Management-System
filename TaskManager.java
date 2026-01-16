import java.util.*;

// enums
enum Status {
    TODO,
    IN_PROGRESS,
    COMPLETED
}

enum Priority {
    LOW,
    MEDIUM,
    HIGH
}

//taskclass
class Task {
    int id;
    String title;
    Priority priority;
    Status status;

    Task(int id, String title, Priority priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = Status.TODO;
    }

    void display() {
        System.out.println(id + " | " + title + " | " + priority + " | " + status);
    }
}

// main class
public class TaskManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int taskId = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- TASK MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Filter High Priority Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTaskStatus();
                    break;
                case 4:
                    filterHighPriority();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // task add
    static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter priority (LOW/MEDIUM/HIGH): ");
        Priority priority = Priority.valueOf(sc.next().toUpperCase());

        Task task = new Task(taskId++, title, priority);
        tasks.add(task);

        System.out.println("Task added successfully!");
    }

    // task view
    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("\nID | TITLE | PRIORITY | STATUS");
        for (Task t : tasks) {
            t.display();
        }
    }

    // update status of task
    static void updateTaskStatus() {
        System.out.print("Enter task ID: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.id == id) {
                System.out.print("Enter new status (TODO/IN_PROGRESS/COMPLETED): ");
                t.status = Status.valueOf(sc.next().toUpperCase());
                System.out.println("Task status updated!");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // filter high property
    static void filterHighPriority() {
        boolean found = false;
        for (Task t : tasks) {
            if (t.priority == Priority.HIGH) {
                t.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No high priority tasks.");
        }
    }
}
