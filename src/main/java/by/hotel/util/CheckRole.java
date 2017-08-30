package by.hotel.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CheckRole {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private String getCurrentRoleFromDb(String email) throws SQLException {
        String role = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT `nameRole` FROM `db_hotel`.`role` WHERE `id` = (SELECT `role_id` FROM `db_hotel`.`user` WHERE `email` = ?)");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = resultSet.getString("nameRole");
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            connection.close();
        }
        return role;
    }

    public void checkCurrentRole(HttpServletRequest request) throws SQLException {
        Object email = request.getSession().getAttribute("email");
        if (email != null) {
            String role = getCurrentRoleFromDb(email.toString());
            SessionHelper.SetUserRoleSession(request,role);
        }
    }
}
