package com.aliaksey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private Integer userId;
    private Role role;
    private String firstName;
    private String patronimyc;
    private String surname;
    private String mobilePhone;
    private UserSex userSex;
    private Set<Review> reviews = new HashSet<Review>(0);
    private Set<Reservation> reservations = new HashSet<Reservation>(0);
    private Set<UserRoom> userRooms = new HashSet<UserRoom>(0);
    private Auth auth;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer transactionId) {
        this.userId = transactionId;
    }

    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "patronimyc", nullable = false, length = 45)
    public String getPatronimyc() {
        return this.patronimyc;
    }

    public void setPatronimyc(String patronimyc) {
        this.patronimyc = patronimyc;
    }

    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "mobile_phone", nullable = false, length = 45)
    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Column(name = "sex", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public UserSex getUserSex() {
        return this.userSex;
    }

    public void setUserSex(UserSex userSex) {
        this.userSex = userSex;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
    public Set<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "User")
    public Auth getAuth() {
        return this.auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
    public Set<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "User")
    public Set<UserRoom> getUserRooms() {
        return  this.userRooms;
    }

    public void setUserRooms(Set<UserRoom> userRooms) {
        this.userRooms = userRooms;
    }




}
