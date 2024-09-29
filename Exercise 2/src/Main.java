import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskFactory taskFactory = new TaskFactory();
        TaskObserver taskObserver = new TaskObserver();
        scheduleManager.addObserver(taskObserver);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time (HH:MM): ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter end time (HH:MM): ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter priority (High, Medium, Low): ");
                    String priority = scanner.nextLine();
                    Task task = taskFactory.createTask(description, startTime, endTime, priority);
                    scheduleManager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String taskDesc = scanner.nextLine();
                    scheduleManager.removeTask(taskDesc);
                    break;
                case 3:
                    scheduleManager.viewTasks();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}