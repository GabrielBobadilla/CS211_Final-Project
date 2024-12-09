import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HeritagePulsePH {
    static Scanner scanner = new Scanner(System.in);
    static User currentUser;

    public static void main(String[] args) {
        showLoginMenu();
    }

    // Encapsulation: User class
    static class User {
        private String username;
        private String role;

        public User(String username, String role) {
            this.username = username;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    private static void showLoginMenu() {
        System.out.println("=== Welcome to HeritagePulsePH ===");
        System.out.println("[1] Login");
        System.out.println("[2] Signup");
        System.out.println("[3] Delete Account");
        System.out.println("[4] Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> login();
            case 2 -> signup();
            case 3 -> deleteAccount();
            case 4 -> System.exit(0);
            default -> {
                System.out.println("Invalid option. Please try again.");
                showLoginMenu();
            }
        }
    }

    private static void login() {
        System.out.println("\n=== Login ===");
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();
        System.out.println("Roles: [1] Student [2] Dancer [3] Dance Researcher [4] Choreographer");
        System.out.print("Choose your role (1-4): ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String role;
        switch (roleChoice) {
            case 1 -> role = "Student";
            case 2 -> role = "Dancer";
            case 3 -> role = "Dance Researcher";
            case 4 -> role = "Choreographer";
            default -> {
                System.out.println("Invalid role. Please try again.");
                login();
                return;
            }
        }

        currentUser = new User(username, role);
        System.out.println("\nWelcome, " + currentUser.getUsername() + " (" + currentUser.getRole() + ")!");
        dashboard();
    }

    private static void signup() {
        System.out.println("=== Signup ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Signup successful for " + username);
        showLoginMenu();
    }

    private static void deleteAccount() {
        System.out.println("=== Delete Account ===");
        System.out.print("Enter username to delete: ");
        String username = scanner.nextLine();
        System.out.println("Account for " + username + " has been deleted.");
        showLoginMenu();
    }

    private static void dashboard() {
        System.out.println("\n=== Dashboard ===");
        showDashboardOptions();
    }

    private static void showDashboardOptions() {
        System.out.println("\n[1] Mission & Vision");
        System.out.println("[2] Explore Rural Dances");
        System.out.println("[3] Explore Western-Influenced Dances");
        System.out.println("[4] Explore Cordillera Dances");
        System.out.println("[5] Explore Muslim Dances");
        System.out.println("[6] Search Dances");
        System.out.println("[7] Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> showMissionVision();
            case 2 -> exploreSection(new RuralDance());
            case 3 -> exploreSection(new WesternDance());
            case 4 -> exploreSection(new CordilleraDance());
            case 5 -> exploreSection(new MuslimDance());
            case 6 -> searchDances();
            case 7 -> showLoginMenu();
            default -> {
                System.out.println("Invalid option. Try again.");
                showDashboardOptions();
            }
        }
    }

    private static void showMissionVision() {
        System.out.println("\n=== Mission & Vision ===");
        System.out.println("Mission: To preserve and promote the rich heritage of Philippine folk dances.");
        System.out.println("Vision: A world that appreciates and respects the cultural tapestry of the Philippines.");
        showDashboardOptions();
    }

    // Abstraction and Polymorphism: Base DanceSection class
    static abstract class DanceSection {
        public abstract String getSectionName();
        public abstract List<String> getDances();

        public void displayDances() {
            System.out.println("\n=== " + getSectionName() + " Dances ===");
            for (String dance : getDances()) {
                System.out.println("- " + dance);
            }
        }
    }

    // Inheritance: Specific DanceSection subclasses
    static class CordilleraDance extends DanceSection {
        @Override
        public String getSectionName() {
            return "Cordillera";
        }

        @Override
        public List<String> getDances() {
            return Arrays.asList("Salip", "Banga Salidsid", "Cheiftain", "Idodo", "Uyauy");
        }
    }

    static class WesternDance extends DanceSection {
        @Override
        public String getSectionName() {
            return "Western Influence";
        }

        @Override
        public List<String> getDances() {
            return Arrays.asList("Jota Rizal", "Jota Manileña", "Paseo sa Plaza", "Estudyantina", "Jovencita");
        }
    }

    static class RuralDance extends DanceSection {
        @Override
        public String getSectionName() {
            return "Rural";
        }

        @Override
        public List<String> getDances() {
            return Arrays.asList("Maglalatik", "Subli", "Salakban", "Pabayle Iloco", "Pastores Infantes");
        }
    }

    static class MuslimDance extends DanceSection {
        @Override
        public String getSectionName() {
            return "Muslim";
        }

        @Override
        public List<String> getDances() {
            return Arrays.asList("Pag-apir", "Maral Dad Libun", "Pindulas", "Kappa Malong", "Kuntao");
        }
    }

    private static void exploreSection(DanceSection section) {
        section.displayDances();
        showDashboardOptions();
    }

    private static void searchDances() {
        System.out.print("\nEnter a dance name to search: ");
        String danceName = scanner.nextLine();
        System.out.println("Searching for " + danceName + "...");
        // Implement search logic
        showDashboardOptions();
    }
}
