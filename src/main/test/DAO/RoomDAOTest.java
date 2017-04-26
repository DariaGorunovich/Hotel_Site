package DAO;

import com.aliaksey.DAO.RoomDAO;
import com.aliaksey.DAO.RoomTypeDAO;
import com.aliaksey.entity.Auth;
import com.aliaksey.entity.Room;
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
public class RoomDAOTest {

    @Autowired(required = true)
    public RoomDAO roomDAO;

    @Autowired(required = true)
    public RoomTypeDAO roomTypeDAO;

    @Test
    public void add() {
        Room room = new Room();
        room.setRoomType(roomTypeDAO.get(23));
        room.setFloor(3);
        room.setPhone("1597532");
        roomDAO.add(room);
    }

    @Test()
    public void getAll() {
        List<Room> roomList = roomDAO.getAll();
        for (Room room:
                roomList) {
            System.out.println("\n\nTest result:\nRoom_Number: " + room.getRoomNumberId() +
                    "\nRoom_Type_ID: " + room.getRoomType() +
                    "\nFloor: " + room.getFloor() +
                    "\nPhone: " + room.getPhone());
        }
    }

    @Test()
    public void getByID() {
        Room room = roomDAO.get(26);
        System.out.println("\n\nTest result:\nRoom_Number: " + room.getRoomNumberId() +
                "\nRoom_Type_ID: " + room.getRoomType() +
                "\nFloor: " + room.getFloor() +
                "\nPhone: " + room.getPhone());
    }

    @Test()
    public void update() {
        Room room = roomDAO.get(27);
        room.setFloor(4);
        room.setPhone("1111111");
        roomDAO.update(room);
    }

    @Test
    public void delete() {

        roomDAO.delete(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeId() throws Exception {
        Room room = new Room();
        room.setRoomNumberId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullData() throws Exception {
        Room room = new Room();
        room.setPhone(null);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        Room room = roomDAO.get(1000000);
        System.out.println("\n\nTest result:\nRoom_Number: " + room.getRoomNumberId() +
                "\nRoom_Type_ID: " + room.getRoomType() +
                "\nFloor: " + room.getFloor() +
                "\nPhone: " + room.getPhone());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        Room room = roomDAO.get(27);
        room.setFloor(null);
        room.setPhone("-4567");
        roomDAO.update(room);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        roomDAO.delete(null);
    }
}
