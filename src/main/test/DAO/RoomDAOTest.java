package DAO;

import com.aliaksey.DAO.RoomDAO;
import com.aliaksey.entity.Room;
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
public class RoomDAOTest {

    @Autowired(required = true)
    public RoomDAO roomDAO;

    @Test
    public void add() {
        Room room = new Room();
        room.setFloor(1);
        room.setPhone("2341457");
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
        Room room = roomDAO.get(1);
        System.out.println("\n\nTest result:\nRoom_Number: " + room.getRoomNumberId() +
                "\nRoom_Type_ID: " + room.getRoomType() +
                "\nFloor: " + room.getFloor() +
                "\nPhone: " + room.getPhone());
    }

    @Test()
    public void update() {
        Room room = roomDAO.get(2);
        room.setFloor(3);
        room.setPhone("1469857");
        roomDAO.update(room);
    }

    @Test
    public void delete() {
        roomDAO.delete(3);
    }
}
