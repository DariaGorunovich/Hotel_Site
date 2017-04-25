package DAO;

import com.aliaksey.DAO.AuthDAO;
import com.aliaksey.entity.Auth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Kirik on 25.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })

public class AuthDAOTest {

    @Autowired(required = true)
    public AuthDAO authDAO;

    @Test
    public  void add() {
      Auth auth = new Auth();
      auth.setEmail("auth@gmail.com");
      auth.getPasswordHash("123456");
      authDAO.add(auth);
    }

    @Test
    public void getAll() {
        List<Auth> authList = authDAO.getAll();
        for (Auth auth: authList){
            System.out.println("\n\nTest result:\nAuth_ID: " + auth.getAuthId() +
                    "\nUser_ID: " + auth.getUser() +
                    "\nE-mail: " + auth.getEmail() +
                    "\nPassword_Hash " + auth.getPasswordHash("123456"));
        }
    }

    @Test
    public void getById() {
        Auth auth = authDAO.get(1);
        System.out.println("\n\nTest result:\nAuth_ID: " + auth.getAuthId() +
                "\nUser_ID: " + auth.getUser() +
                "\nE-mail: " + auth.getEmail() +
                "\nPassword_Hash " + auth.getPasswordHash("123456"));

    }

    @Test
    public void update() {
        Auth auth = authDAO.get(2);
        auth.setEmail("auth111@gmail.com");
        auth.getPasswordHash("145874");
        authDAO.update(auth);
    }

    @Test
    public void delete() {
        authDAO.delete(3);
    }
}
