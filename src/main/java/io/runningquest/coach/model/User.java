package io.runningquest.coach.model;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name = "User", schema = "runningquest")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String emailAddress;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
