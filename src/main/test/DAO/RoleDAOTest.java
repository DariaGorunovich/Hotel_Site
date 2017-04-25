package DAO;

import com.aliaksey.DAO.RoleDAO;
import com.aliaksey.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.PublicKey;
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
        role.setRoleName("Admin");
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
        Role role = roleDAO.get(1);
        System.out.println("\n\nTest result:\nRole_ID: " + role.getId() +
                "\nRole_Name: " + role.getRoleName());
    }

    @Test
    public  void update() {
        Role role = roleDAO.get(2);
        role.setRoleName("User");
        roleDAO.update(role);
    }

    @Test
    public void delete() {
        roleDAO.delete(3);
    }


}
