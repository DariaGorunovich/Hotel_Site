package com.aliaksey.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aliaksey on 19.03.2017.
 */
@Entity
@Table(name = "user_has_room")
public class UserHasRoom implements Serializable{

    private Integer userRoomNumberId;
    private User user;
    private Room room;
    private Date dateIn;
    private Date dateOut;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_room_number_id", unique = true, nullable = false)
    public Integer getUserRoomNumberId() {
        return this.userRoomNumberId;
    }

    public void setUserRoomNumberId(Integer userRoomNumberId) {
        this.userRoomNumberId = userRoomNumberId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "room_number", nullable = false)
    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date-in", nullable = false)
    public Date getDateIn() {
        return this.dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date-out", nullable = false)
    public Date getDateOut() {
        return this.dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

}
