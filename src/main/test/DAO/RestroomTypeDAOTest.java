package DAO;

import com.aliaksey.DAO.RestroomTypeDAO;
import com.aliaksey.entity.RestroomType;
import com.aliaksey.entity.ToiletType;
import org.hibernate.PropertyValueException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })
public class RestroomTypeDAOTest {

    @Autowired(required = true)
    public RestroomTypeDAO restroomTypeDAO;

    @Test
    public void add() {
        RestroomType restroomType = new RestroomType();
        restroomType.setName("Two+Two");
        restroomType.setBathroomsCount(2);
        restroomType.setToiletsCount(2);
        restroomType.setToiletType(ToiletType.Combined);
        restroomTypeDAO.add(restroomType);
    }

    @Test
    public void getAll() {
        List<RestroomType> restroomTypeList = restroomTypeDAO.getAll();
        for (RestroomType restroomType:
             restroomTypeList) {
            System.out.println("\n\nTest result:\nRestroom_Type_ID: " + restroomType.getRestroomTypeId() +
                    "\nRestroom_Type_Name: " + restroomType.getName() +
                    "\nRestroom_Toilet_Type: " + restroomType.getToiletType() +
                    "\nRestroom_Toilets_Count: " + restroomType.getToiletsCount() +
                    "\nRestroom_Bathrooms: " + restroomType.getBathroomsCount());
        }
    }

    @Test
    public void getById() {
        RestroomType restroomType = restroomTypeDAO.get(1);
        System.out.println("\n\nTest result:\nRestroom_Type_ID: " + restroomType.getRestroomTypeId() +
                "\nRestroom_Type_Name: " + restroomType.getName() +
                "\nRestroom_Toilet_Type: " + restroomType.getToiletType() +
                "\nRestroom_Toilets_Count: " + restroomType.getToiletsCount() +
                "\nRestroom_Bathrooms: " + restroomType.getBathroomsCount());
    }

    @Test
    public void update() {
        RestroomType restroomType = restroomTypeDAO.get(1);
        restroomType.setName("Five+Five");
        restroomType.setBathroomsCount(5);
        restroomType.setToiletsCount(5);
        restroomType.setToiletType(ToiletType.Not_combined);
        restroomTypeDAO.update(restroomType);
    }

    @Test
    public void delete() {
        restroomTypeDAO.delete(1000);
    }

    @Test(expected = PropertyValueException.class)
    public void setNegativeId() throws Exception {
        RestroomType restroomType = new RestroomType();
        restroomType.setRestroomTypeId(-1);
        restroomTypeDAO.add(restroomType);
    }

    @Test(expected = PropertyValueException.class)
    public void setNullData() throws Exception {
        RestroomType restroomType = new RestroomType();
        restroomType.setName(null);
        restroomTypeDAO.add(restroomType);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        RestroomType restroomType = restroomTypeDAO.get(10000);
        System.out.println("\n\nTest result:\nRestroom_Type_ID: " + restroomType.getRestroomTypeId() +
                "\nRestroom_Type_Name: " + restroomType.getName() +
                "\nRestroom_Toilet_Type: " + restroomType.getToiletType() +
                "\nRestroom_Toilets_Count: " + restroomType.getToiletsCount() +
                "\nRestroom_Bathrooms: " + restroomType.getBathroomsCount());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        RestroomType restroomType = restroomTypeDAO.get(1);
        restroomType.setName(null);
        restroomType.setBathroomsCount(-1000000);
        restroomType.setToiletsCount(10000000);
        restroomType.setToiletType(null);
        restroomTypeDAO.update(restroomType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
       restroomTypeDAO.delete(null);
    }

}
