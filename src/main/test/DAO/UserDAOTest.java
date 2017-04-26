package DAO;

import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Auth;
import com.aliaksey.entity.User;
import com.aliaksey.entity.UserSex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by Kirik on 25.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })
public class UserDAOTest {

    @Autowired(required = true)
    public UserDAO userDAO;

    @Test
    public  void add() {
        User user = new User();
        user.setFirstName("Kirill");
        user.setPatronimyc("Aleksandrovich");
        user.setSurname("Sokolov");
        user.setMobilePhone("1587458");
        user.setUserSex(UserSex.Male);
        userDAO.add(user);
    }

    @Test
    public void getAll() {
        List<User> userList = userDAO.getAll();
        for (User user: userList) {
            System.out.println("\n\nTest result:\nUser_ID: " + user.getUserId() +
                    "\nFirst_Name: " + user.getFirstName() +
                    "\nPatronym: " + user.getPatronimyc() +
                    "\nSurname: " + user.getSurname() +
                    "\nMobile_Phone: " + user.getMobilePhone() +
                    "\nUser_Sex: " + user.getUserSex());
        }
    }

    @Test
    public void getById() {
        User user = userDAO.get(1);
        System.out.println("\n\nTest result:\nUser_ID: " + user.getUserId() +
                "\nFirst_Name: " + user.getFirstName() +
                "\nPatronym: " + user.getPatronimyc() +
                "\nSurname: " + user.getSurname() +
                "\nMobile_Phone: " + user.getMobilePhone() +
                "\nUser_Sex: " + user.getUserSex());
    }

    @Test
    public void update() {
        User user = userDAO.get(4);
        user.setFirstName("Alex");
        user.setPatronimyc("Aleksandrovich");
        user.setSurname("Alex");
        user.setMobilePhone("1472589");
        user.setUserSex(UserSex.Male);
        userDAO.update(user);
    }

    @Test
    public void delete() {
        userDAO.delete(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeId() throws Exception {
        User user = new User();
        user.setUserId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullData() throws Exception {
        User user = new User();
        user.setSurname(null);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        User user = userDAO.get(100000);
        System.out.println("\n\nTest result:\nUser_ID: " + user.getUserId() +
                "\nFirst_Name: " + user.getFirstName() +
                "\nPatronym: " + user.getPatronimyc() +
                "\nSurname: " + user.getSurname() +
                "\nMobile_Phone: " + user.getMobilePhone() +
                "\nUser_Sex: " + user.getUserSex());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        User user = userDAO.get(46546546);
        user.setFirstName(null);
        user.setPatronimyc(null);
        user.setSurname(null);
        userDAO.update(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        userDAO.delete(null);
    }
}
