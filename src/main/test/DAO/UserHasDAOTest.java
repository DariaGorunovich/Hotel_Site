package DAO;

import com.aliaksey.DAO.RoomDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.DAO.UserHasRoomDAO;
import com.aliaksey.entity.User;
import com.aliaksey.entity.UserHasRoom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


/**
 * Created by Kirik on 26.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })
public class UserHasDAOTest {

    @Autowired(required = true)
    public UserHasRoomDAO userHasRoomDAO;

    @Autowired(required = true)
    public UserDAO userDAO;

    @Autowired(required = true)
    public RoomDAO roomDAO;

    @Test
    public void add() {
        UserHasRoom userHasRoom = new UserHasRoom();
        userHasRoom.setUser(userDAO.get(1));
        userHasRoom.setRoom(roomDAO.get(26));
        userHasRoom.setDateIn(new Date());
        userHasRoom.setDateOut(new Date());
        userHasRoomDAO.add(userHasRoom);
    }

    @Test
    public void getAll() {
        List<UserHasRoom> userHasRoomList = userHasRoomDAO.getAll();
        for (UserHasRoom userHasRoom: userHasRoomList) {
            System.out.println("\n\nTest result:\nUser_Room_Number_ID: " + userHasRoom.getUserRoomNumberId() +
                    "\nUser_ID: " + userHasRoom.getUser() +
                    "\nRoom_Number: " + userHasRoom.getRoom() +
                    "\nDate_In: " + userHasRoom.getDateIn() +
                    "\nDate_Out: " + userHasRoom.getDateOut());
        }
    }

    @Test
    public void getById() {
        UserHasRoom userHasRoom = userHasRoomDAO.get(35);
        System.out.println("\n\nTest result:\nUser_Room_Number_ID: " + userHasRoom.getUserRoomNumberId() +
                "\nUser_ID: " + userHasRoom.getUser() +
                "\nRoom_Number: " + userHasRoom.getRoom() +
                "\nDate_In: " + userHasRoom.getDateIn() +
                "\nDate_Out: " + userHasRoom.getDateOut());
    }

    @Test
    public void update() {
        UserHasRoom userHasRoom = userHasRoomDAO.get(36);
        userHasRoom.setDateIn(new Date());
        userHasRoom.setDateOut(new Date());
        userHasRoomDAO.update(userHasRoom);
    }

    @Test
    public void delete() {
        userHasRoomDAO.delete(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeId() throws Exception {
        UserHasRoom userHasRoom = new UserHasRoom();
        userHasRoom.setUserRoomNumberId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullData() throws Exception {
        UserHasRoom userHasRoom = new UserHasRoom();
        userHasRoom.setUser(null);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        UserHasRoom userHasRoom = userHasRoomDAO.get(1456874);
        System.out.println("\n\nTest result:\nUser_Room_Number_ID: " + userHasRoom.getUserRoomNumberId() +
                "\nUser_ID: " + userHasRoom.getUser() +
                "\nRoom_Number: " + userHasRoom.getRoom() +
                "\nDate_In: " + userHasRoom.getDateIn() +
                "\nDate_Out: " + userHasRoom.getDateOut());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        UserHasRoom userHasRoom = userHasRoomDAO.get(-3456);
        userHasRoom.setDateIn(new Date(-1));
        userHasRoom.setDateOut(new Date(-1));
        userHasRoomDAO.update(userHasRoom);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        userHasRoomDAO.update(null);
    }
}
