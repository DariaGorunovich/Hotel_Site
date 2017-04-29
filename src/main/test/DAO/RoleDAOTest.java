package DAO;

import com.aliaksey.DAO.RoleDAO;
import com.aliaksey.entity.Role;
import org.hibernate.PropertyValueException;
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
public class RoleDAOTest {

    @Autowired(required = true)
    public RoleDAO roleDAO;

    @Test
    public void add() {
        Role role = new Role();
        role.setRoleName("Director");
        roleDAO.add(role);
    }

    @Test
    public void getAll() {
        List<Role> roleList = roleDAO.getAll();
        for (Role role: roleList) {
            System.out.println("\n\nTest result:\nRole_ID: " + role.getId() +
                    "\nRole_Name: " + role.getRoleName());
        }
    }

    @Test
    public void getById() {
        Role role = roleDAO.get(4);
        System.out.println("\n\nTest result:\nRole_ID: " + role.getId() +
                "\nRole_Name: " + role.getRoleName());
    }

    @Test
    public  void update() {
        Role role = roleDAO.get(4);
        role.setRoleName("User");
        roleDAO.update(role);
    }

    @Test
    public void delete() {

        roleDAO.delete(10000);
    }

    @Test(expected = PropertyValueException.class)
    public void setNegativeId() throws Exception {
        Role role = new Role();
        role.setId(-1);
        roleDAO.add(role);
    }

    @Test(expected = PropertyValueException.class)
    public void setNullData() throws Exception {
        Role role = new Role();
        role.setRoleName(null);
        roleDAO.add(role);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        Role role = roleDAO.get(1000000);
        System.out.println("\n\nTest result:\nRole_ID: " + role.getId() +
                "\nRole_Name: " + role.getRoleName());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        Role role = roleDAO.get(4);
        role.setRoleName(null);
        roleDAO.update(role);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        roleDAO.delete(null);
    }


}
