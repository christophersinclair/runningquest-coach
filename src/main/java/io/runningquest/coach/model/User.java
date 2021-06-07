package io.runningquest.coach.model;

import javax.persistence.*;

@Entity
@Table(name = "User", schema = "runningquest")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userID;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String emailAddress;
    @Column(name = "avatar_id")
    private Long avatarID;

    @Column(name = "quest_id")
    private Long questID;


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

    public Long getAvatarID() {
        return avatarID;
    }

    public void setAvatarID(Long avatarID) {
        this.avatarID = avatarID;
    }
}
