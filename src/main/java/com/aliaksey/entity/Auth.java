package com.aliaksey.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "auth")
public class Auth implements Serializable{

    private Integer authId;
    private User user;
    private String email;
    private String passwordHash;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_id",unique = true, nullable = false)
    public Integer getAuthId() {
        return this.authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password_hash", nullable = false, length = 45)
    public String getPasswordHash(String s) {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
