import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> taskList;
    private List<Observer> observers;

    private ScheduleManager() {
        taskList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        for (Task t : taskList) {
            if (t.getStartTime().equals(task.getStartTime())) {
                notifyObservers("Task conflicts with an existing task.");
                return;
            }
        }
        taskList.add(task);
        notifyObservers("Task added successfully.");
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task t : taskList) {
            if (t.getDescription().equals(description)) {
                taskToRemove = t;
                break;
            }
        }
        if (taskToRemove != null) {
            taskList.remove(taskToRemove);
            notifyObservers("Task removed successfully.");
        } else {
            notifyObservers("Task not found.");
        }
    }

    public void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task t : taskList) {
                System.out.println(t);
            }
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}