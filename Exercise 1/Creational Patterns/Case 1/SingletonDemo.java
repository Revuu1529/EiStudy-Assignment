class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}

// Main class
public class SingletonDemo {
    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        connection.connect();
    }
}