package by.hotel.controller;

import by.hotel.bean.Review;
import by.hotel.bean.User;
import by.hotel.util.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReviewController {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET )
    public ModelAndView getReviews(HttpServletRequest request) throws SQLException {
        List<Review> reviews = new ArrayList<Review>(0);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT `review`.`*`, `us`.`name`, `us`.`surname` FROM `db_hotel`.`review` `review` INNER JOIN `user` `us` ON (`review`.`user_id` = `us`.`id`) ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = new Review();
                review.setId(resultSet.getInt("id"));
                review.setText(resultSet.getString("text"));
                review.setUserName(resultSet.getString("name"));
                review.setUserSurname(resultSet.getString("surname"));
                reviews.add(review);
            }
        } catch (Exception e){
            System.out.println(e);
            return new ModelAndView("redirect:http://localhost:8080/main.jsp#entry");
        } finally {
            connection.close();
        }
        ModelAndView model = new ModelAndView("reviews");
        model.addObject("reviews",reviews);
        return model;
    }
}
