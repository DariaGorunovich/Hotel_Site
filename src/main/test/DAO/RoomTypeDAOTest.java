package DAO;

import com.aliaksey.DAO.RestroomTypeDAO;
import com.aliaksey.DAO.RoomTypeDAO;
import com.aliaksey.entity.Auth;
import com.aliaksey.entity.Room;
import com.aliaksey.entity.RoomType;
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
public class RoomTypeDAOTest {

    @Autowired(required = true)
    public RoomTypeDAO roomTypeDAO;

    @Autowired(required = true)
    public RestroomTypeDAO restroomTypeDAO;

    @Test
    public void add() {
        RoomType roomType = new RoomType();
       // roomType.setRestroomType(restroomTypeDAO.get(25));
        roomType.setRoomName("SuperRoom1");
        roomType.setBlocksCount(3);
        roomType.setBedsCount(3);
        roomType.setCostPerDay(100);
        roomType.setAdditionalInformation("Coooool!");
        roomTypeDAO.add(roomType);
    }

    @Test
    public void getAll() {
        List<RoomType> roomTypeList = roomTypeDAO.getAll();
        for (RoomType roomType: roomTypeList) {
            System.out.println("\n\nTest result:\nRoom_Type_ID: " + roomType.getRoomTypeId() +
                    //"\nRestroom_Type_ID " + roomType.getRestroomType() +
                    "\nRoom_Name: " + roomType.getRoomName() +
                    "\nBlocks_Count: " + roomType.getBlocksCount() +
                    "\nBeds_Count: " + roomType.getBedsCount() +
                    "\nCost_Per_Day: " + roomType.getCostPerDay() +
                    "\nAdditional_Inf: " + roomType.getAdditionalInformation());
        }
    }

    @Test
    public void getById() {
        RoomType roomType = roomTypeDAO.get(25);
        System.out.println("\n\nTest result:\nRoom_Type_ID: " + roomType.getRoomTypeId() +
                //"\nRestroom_Type_ID " + roomType.getRestroomType() +
                "\nRoom_Name: " + roomType.getRoomName() +
                "\nBlocks_Count: " + roomType.getBlocksCount() +
                "\nBeds_Count: " + roomType.getBedsCount() +
                "\nCost_Per_Day: " + roomType.getCostPerDay() +
                "\nAdditional_Inf: " + roomType.getAdditionalInformation());
    }

    @Test
    public void update() {
        RoomType roomType = roomTypeDAO.get(25);
        roomType.setRoomName("WooowRoom");
        roomType.setBlocksCount(10);
        roomType.setBedsCount(3);
        roomType.setCostPerDay(10000);
        roomType.setAdditionalInformation("Good room!");
        roomTypeDAO.update(roomType);
    }

    @Test
    public  void delete() {

        roomTypeDAO.delete(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeId() throws Exception {
        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullData() throws Exception {
        RoomType roomType = new RoomType();
       // roomType.setRestroomType(null);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        RoomType roomType = roomTypeDAO.get(10000000);
        System.out.println("\n\nTest result:\nRoom_Type_ID: " + roomType.getRoomTypeId() +
                //"\nRestroom_Type_ID " + roomType.getRestroomType() +
                "\nRoom_Name: " + roomType.getRoomName() +
                "\nBlocks_Count: " + roomType.getBlocksCount() +
                "\nBeds_Count: " + roomType.getBedsCount() +
                "\nCost_Per_Day: " + roomType.getCostPerDay() +
                "\nAdditional_Inf: " + roomType.getAdditionalInformation());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        RoomType roomType = roomTypeDAO.get(null);
        roomType.setRoomName(null);
        roomType.setBlocksCount(null);
        roomType.setBedsCount(null);
        roomType.setCostPerDay(null);
        roomType.setAdditionalInformation(null);
        roomTypeDAO.update(roomType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        roomTypeDAO.delete(null);
    }
}
