package com.aliaksey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "review")
public class Review implements Serializable{

    private Integer reviewId;
    private User user;
    private String text;
    private Date date;
    private ReviewMark reviewMark;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id",unique = true, nullable = false)
    public Integer getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "text", nullable = false, length = 45)
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "mark", nullable = false)
    @Enumerated(EnumType.STRING)
    public ReviewMark getReviewMark() {
        return this.reviewMark;
    }

    public void setReviewMark(ReviewMark reviewMark) {
        this.reviewMark = reviewMark;
    }
}
