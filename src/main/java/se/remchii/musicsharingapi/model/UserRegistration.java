package se.remchii.musicsharingapi.model;

public class UserRegistration {
    private String username;
    private String password;

    public UserRegistration() {
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
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
