package com.aliaksey.DAO;

import com.aliaksey.entity.Review;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
public interface ReviewDAO extends AbstractDAO<Review> {
    List<Review> getAllReviews();
}
