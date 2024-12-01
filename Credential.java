package tracker;

public class Credential {
    private final String firstName;
    private final String lastName;
    private final String email;
    boolean isValidFirstName;
    private boolean isValidLastName;
    private boolean isValidEmail;

    public String getFirstName() {
        return firstName.trim();
    }

    public String getLastName() {
        return lastName.trim();
    }

    public String getEmail() {
        return email.trim();
    }

    public boolean isValidFirstName() {
        return isValidFirstName;
    }

    public void setValidFirstName(boolean validFirstName) {
        isValidFirstName = validFirstName;
    }

    public boolean isValidLastName() {
        return isValidLastName;
    }

    public void setValidLastName(boolean validLastName) {
        isValidLastName = validLastName;
    }

    public boolean isValidEmail() {
        return isValidEmail;
    }

    public void setValidEmail(boolean validEmail) {
        isValidEmail = validEmail;
    }

    public Credential(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

