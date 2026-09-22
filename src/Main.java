// Login screen class
import view.LoginView;

// Login logic class
import controller.LoginController;

// Main class
public class Main {

    // Program start here
    public static void main(String[] args) {

        // Create login screen
        LoginView view = new LoginView();

        // Connect screen with logic
        new LoginController(view);
    }
}
