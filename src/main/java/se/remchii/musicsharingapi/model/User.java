package se.remchii.musicsharingapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String auth0Id;
    private String username;
    private String email;

    public User() {
    }

    public User(String auth0Id, String username, String email) {
        this.auth0Id = auth0Id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", auth0Id='" + auth0Id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
