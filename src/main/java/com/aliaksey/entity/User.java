package com.aliaksey.entity;

import com.aliaksey.controller.Util.CustomSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
    private String firstName;
    private String patronimyc;
    private String surname;
    private String mobilePhone;
    private UserSex userSex;
    private Auth auth;

    private Set<Role> roles = new HashSet<Role>(0);

    private Set<Review> reviews = new HashSet<Review>(0);

    private Set<Reservation> reservations = new HashSet<Reservation>(0);

    private Set<UserHasRoom> userRooms = new HashSet<UserHasRoom>(0);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Enumerated(EnumType.STRING)
    public UserSex getUserSex() {
        return this.userSex;
    }

    public void setUserSex(UserSex userSex) {
        this.userSex = userSex;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @ManyToMany
    @JoinTable(name = "user_has_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user")
    public Auth getAuth() {
        return this.auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public Set<UserHasRoom> getUserRooms() {
        return  this.userRooms;
    }

    public void setUserRooms(Set<UserHasRoom> userRooms) {
        this.userRooms = userRooms;
    }




}
