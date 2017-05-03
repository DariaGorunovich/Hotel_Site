package DAO;

import com.aliaksey.DAO.RoleDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Role;
import com.aliaksey.entity.User;
import com.aliaksey.entity.UserSex;
import org.hibernate.PropertyValueException;
import org.hibernate.TransientObjectException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Kirik on 25.04.2017.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })
public class UserDAOTest {

    @Autowired(required = true)
    public UserDAO userDAO;

    @Autowired(required = true)
    public RoleDAO roleDAO;

    @Test
    public void findByEmail() {
        User user = userDAO.findByEmail("a@gmail.c");
        System.out.println("\n\nTest result:\nUser_ID: " + user.getUserId());
    }

    @Test
    public  void add() {
        User user = new User();
        user.setFirstName("AAAAA");
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
    @Transactional
    public void getById() {
        User user = userDAO.get(10);
//        for (Role role : user.getRoles()) {
////            System.out.println("\n\nTest result:\nRole_ID: " + role.getId() );
//        }

//                "\nFirst_Name: " + user.getFirstName() +
//                "\nPatronym: " + user.getPatronimyc() +
//                "\nSurname: " + user.getSurname() +
//                "\nMobile_Phone: " + user.getMobilePhone() +
//                "\nUser_Sex: " + user.getUserSex());
    }

    @Test
    public void update() {
        User user = userDAO.get(1);
        user.setRoles(new HashSet<Role>(Arrays.asList(roleDAO.get(1),roleDAO.get(2))));
        userDAO.update(user);
    }

    @Test
    public void delete() {
        userDAO.delete(10000);
    }

    @Test(expected = PropertyValueException.class)
    public void setNegativeId() throws Exception {
        User user = new User();
        user.setUserId(-1);
        userDAO.add(user);
    }

    @Test(expected = TransientObjectException.class)
    public void setNullData() throws Exception {
        User user = new User();
        user.setSurname(null);
        userDAO.update(user);
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

    @Test(expected = NullPointerException.class)
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
