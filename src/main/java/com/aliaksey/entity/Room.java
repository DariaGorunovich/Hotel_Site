package com.aliaksey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "Room")
public class Room implements Serializable {

    private Integer roomNumberId;
    private Integer floor;
    private String phone;
    private RoomType roomType;
    private Set<Reservation> reservations = new HashSet<Reservation>(0);
    private Set<UserRoom> userRooms = new HashSet<UserRoom>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_number", unique = true, nullable = false)
    public Integer getRoomNumberId() {
        return this.roomNumberId;
    }

    public void setRoomNumberId(Integer roomNumberId) {
        this.roomNumberId = roomNumberId;
    }

    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    public RoomType getRoomType() {
        return this.roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Column(name = "floor", nullable = false)
    public Integer getFloor() {
        return this.floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Column(name = "phone", unique = true,nullable = false, length = 45)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Room")
    public Set<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "Room")
    public Set<UserRoom> getUserRooms() {
        return  this.userRooms;
    }

    public void setUserRooms(Set<UserRoom> userRooms) {
        this.userRooms = userRooms;
    }
}
