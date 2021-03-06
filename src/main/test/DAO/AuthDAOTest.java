package DAO;

import com.aliaksey.DAO.AuthDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Auth;
import com.aliaksey.entity.User;
import com.aliaksey.entity.UserSex;
import org.hibernate.PropertyValueException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.BeforeMethod;

import java.util.List;

/**
 * Created by Kirik on 25.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })

public class AuthDAOTest {

    @Autowired(required = true)
    public AuthDAO authDAO;

    @Autowired(required = true)
    public UserDAO userDAO;


    @BeforeMethod
    public User newUser() {
        User user = new User();
        user.setFirstName("Kirill");
        user.setPatronimyc("Aleksandrovich");
        user.setSurname("Sokolov");
        user.setMobilePhone("1587458");
        user.setUserSex(UserSex.Male);
        userDAO.add(user);
        return user;
    }

    @Test
    public  void add() {
      Auth auth = new Auth();
      auth.setEmail("auth4@gmail.com");
      auth.setPasswordHash("123456");
      auth.setUser(newUser());
      authDAO.add(auth);
    }

    @Test
    public void getAll() {
        List<Auth> authList = authDAO.getAll();
        for (Auth auth: authList){
            System.out.println("\n\nTest result:\nAuth_ID: " + auth.getAuthId() +
                    "\nUser_ID: " + auth.getUser() +
                    "\nE-mail: " + auth.getEmail() +
                    "\nPassword_Hash " + auth.getPasswordHash());
        }
    }

    @Test
    public void getById() {
        Auth auth = authDAO.get(1);
        System.out.println("\n\nTest result:\nAuth_ID: " + auth.getAuthId() +
                "\nUser_ID: " + auth.getUser() +
                "\nE-mail: " + auth.getEmail() +
                "\nPassword_Hash " + auth.getPasswordHash());

    }

    @Test
    public void update() {
        Auth auth = authDAO.get(1);
        auth.setEmail("auth111@gmail.com");
        auth.setPasswordHash("1234");
        authDAO.update(auth);
    }

    @Test
    public void delete() {

        authDAO.delete(10000);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void setNegativeId() throws Exception {
        Auth auth = new Auth();
        auth.setAuthId(-1);
        authDAO.update(auth);
    }

    @Test(expected = PropertyValueException.class)
    public void setNullData() throws Exception {
        Auth auth = new Auth();
        auth.setEmail(null);
        authDAO.add(auth);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        Auth auth = authDAO.get(10000);
        System.out.println("\n\nTest result:\nAuth_ID: " + auth.getAuthId() +
                "\nUser_ID: " + auth.getUser() +
                "\nE-mail: " + auth.getEmail() +
                "\nPassword_Hash " + auth.getPasswordHash());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        Auth auth = authDAO.get(1);
        auth.setEmail(null);
        auth.setPasswordHash(null);
        authDAO.update(auth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        authDAO.delete(null);
    }
}
