package se.remchii.musicsharingapi.model;

public class UserRegistration {
    private String email;
    private String username;
    private String password;

    public UserRegistration() {
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
