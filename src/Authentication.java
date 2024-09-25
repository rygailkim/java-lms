import java.util.ArrayList;

public class Authentication {
    private ArrayList<User> users; // list of registered users

    // Admin credentials
    private final String adminUsername = "admin";
    private final String adminPassword = "admin123";
    private User adminUser = new User("0", adminUsername, adminPassword, true);

    public Authentication() {
        users = new ArrayList<>();
        users.add(adminUser);
    }

    // Register a new user
    public User registerUser(String name, String password) {
        String newUserID = String.valueOf(users.size());
        User newUser = new User(newUserID, name, password, false);
        users.add(newUser);
        return newUser;
    }

    // Login user/admin
    public User userLogin(String userID, String password) {
        for (User user : users) {
            if (userID.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Admin login successful!");
                return user;
            } else if (userID.equals(user.getUserID()) && password.equals(user.getPassword())) {
                System.out.println("User login successful!");
                return user;
            }
        }

        System.out.println("Invalid credentials.");
        return null;
    }

}
