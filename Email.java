import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String division;
    private String emailAddress;
    private final int PASSWORD_LENGTH = 10;
    private final String COMPANY_DOMAIN = "gmail.com";

    // Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("New Employee: " + this.firstName + " " + this.lastName);

        // Set division
        this.division = assignDivision();
        System.out.println("Assigned Division: " + this.division);

        // Generate random password
        this.password = generatePassword(PASSWORD_LENGTH);
        System.out.println("Generated Password: " + this.password);

        // Construct email address
        this.emailAddress = createEmail();
        System.out.println("Generated Email: " + this.emailAddress);
    }

    private String assignDivision() {
        System.out.println("Division Options:\n1 - Sales\n2 - Development\n3 - Accounting\n0 - None\nSelect a division code:");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1: return "Sales";
            case 2: return "Development";
            case 3: return "Accounting";
            default: return "";
        }
    }

    private String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
        StringBuilder passwordBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            passwordBuilder.append(characters.charAt(index));
        }

        return passwordBuilder.toString();
    }

    private String createEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + COMPANY_DOMAIN;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}
