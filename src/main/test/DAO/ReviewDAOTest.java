package DAO;

import com.aliaksey.DAO.ReviewDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Review;
import com.aliaksey.entity.ReviewMark;
import org.hibernate.PropertyValueException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Kirik on 25.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })
public class ReviewDAOTest {
    @Autowired(required = true)
    public ReviewDAO reviewDAO;

    @Autowired(required = true)
    public UserDAO userDAO;

    @Test
    public void add() {
        Review review = new Review();
        review.setText("Cooool!");
        review.setDate(new Date());
        review.setReviewMark(ReviewMark.Like);
        review.setUser(userDAO.get(1));
        reviewDAO.add(review);
    }

    @Test
    public void getAll() {
        List<Review> reviewList = reviewDAO.getAll();
        for (Review review: reviewList) {
            System.out.println("\n\nTest result:\nReview_ID: " + review.getReviewId() +
                    "\nUser_ID: " + review.getUser() +
                    "\nText: " + review.getText() +
                    "\nData: " + review.getDate() +
                    "\nMark: " + review.getReviewMark());
        }
    }

    @Test
    public void getById() {
        Review review = reviewDAO.get(1);
        System.out.println("\n\nTest result:\nReview_ID: " + review.getReviewId() +
                "\nUser_ID: " + review.getUser() +
                "\nText: " + review.getText() +
                "\nData: " + review.getDate() +
                "\nMark: " + review.getReviewMark());
    }

    @Test
    public  void update() {
        Review review = reviewDAO.get(1);
        review.setText("AZAZAZAZAZ!");
        review.setDate(new Date());
        review.setReviewMark(ReviewMark.Dislike);
        reviewDAO.update(review);
    }

    @Test
    public void delete() {

        reviewDAO.delete(10000);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void setNegativeId() throws Exception {
        Review review = new Review();
        review.setReviewId(-1);
        reviewDAO.update(review);
    }

    @Test(expected = PropertyValueException.class)
    public void setNullData() throws Exception {
        Review review = new Review();
       review.setReviewMark(null);
       reviewDAO.add(review);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        Review review = reviewDAO.get(10000);
        System.out.println("\n\nTest result:\nReview_ID: " + review.getReviewId() +
                "\nUser_ID: " + review.getUser() +
                "\nText: " + review.getText() +
                "\nData: " + review.getDate() +
                "\nMark: " + review.getReviewMark());
    }

    @Test(expected = NullPointerException.class)
    public void updateError() throws Exception {
        Review review = reviewDAO.get(18);
        review.setText(null);
        review.setDate(new Date(-1));
        review.setReviewMark(null);
        reviewDAO.update(review);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        reviewDAO.delete(null);
    }
}
