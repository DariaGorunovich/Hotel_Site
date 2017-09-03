package by.hotel.service.impl;

import by.hotel.bean.Reservation;
import by.hotel.bean.Review;
import by.hotel.bean.User;
import by.hotel.builder.*;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.CrudServiceExtended;
import by.hotel.service.exception.IncorrectCostException;
import by.hotel.service.exception.IncorrectDateException;
import by.hotel.service.exception.ServiceException;
import by.hotel.util.SessionHelper;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewServiceImpl extends AbstractService {

    public List<Review> getAllEntities() throws ServiceException {
        List<Review> reviews = new ArrayList<Review>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT `rev`.`*`, `us`.`id` AS `userId`,`us`.`passportNumber`,`us`.`name`,`us`.`surname`,`us`.`mobilePhone` FROM `db_hotel`.`review` `rev` INNER JOIN `user` `us` ON (`rev`.`user_id` = `us`.`id`) ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = new Review();
                User user = new User();
                review.setId(resultSet.getInt("id"));

                user.setId(resultSet.getInt("userId"));
                user.setMobilePhone(resultSet.getString("mobilePhone"));
                user.setPassportNumber(resultSet.getString("passportNumber"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));

                review.setUser(user);
                review.setText(resultSet.getString("text"));
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return reviews;
    }

    public void updateEntities(Review review) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE `db_hotel`.`review` SET `text`=?, `user_id`=? WHERE `id`=?");
            statement.setString(1,review.getText());
            statement.setInt(2,review.getUserId());
            statement.setInt(3,review.getId());
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new ServiceException("Данные заполнены неверно!");
        } finally {
            closeConnection(connection);
        }
    }

    public void deleteEntity(Review review) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `db_hotel`.`review` WHERE `id`=?");
            statement.setInt(1,review.getId());
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new ServiceException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Review buildReview(Map<String, String[]> params) throws ServiceException {
//        try {
            Review review = new Review();
            review.setId(Integer.parseInt(params.get("id")[0]));
            review.setText(params.get("text")[0]);
            review.setUserId(Integer.parseInt(params.get("idUser")[0]));
            if (review.getText().length() == 0)
                review.setText(null);
            return review;
//        } catch (ParseException e) {
//            throw new ServiceException(e);
//        }
//        return null;
    }
}
