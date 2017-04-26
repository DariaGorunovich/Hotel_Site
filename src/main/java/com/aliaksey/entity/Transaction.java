package com.aliaksey.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    private Integer transactionId;
    private Reservation reservation;
    private Date date;
    private String paymentData;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", unique = true, nullable = false)
    public Integer getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "transaction")
    public Reservation getReservation() {
        return this.reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "payment_data", nullable = false, length = 45)
    public String getPaymentData () {
        return this.paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }


}
