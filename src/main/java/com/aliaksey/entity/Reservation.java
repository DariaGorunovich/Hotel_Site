package com.aliaksey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {

    private Integer reservationId;
    private Transaction transaction;
    private Room room;
    private User user;
    private Date dateIn;
    private Date dateOut;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id",unique = true, nullable = false)
    public Integer getReservationId() {
        return this.reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    @OneToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @ManyToOne
    @JoinColumn(name = "room_number", nullable = false)
    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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
