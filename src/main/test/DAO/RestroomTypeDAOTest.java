package DAO;

import com.aliaksey.DAO.Impl.RestroomTypeDAOImpl;
import com.aliaksey.DAO.RestroomTypeDAO;
import com.aliaksey.entity.RestroomType;
import com.aliaksey.entity.ToiletType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
        restroomType.setBathtoomsCount(2);
        restroomType.setToiletsCount(2);
        restroomType.setToiletType(ToiletType.Not_Combined);
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
                    "\nRestroom_Bathrooms: " + restroomType.getBathtoomsCount());
        }
    }

    @Test
    public void getById() {
        RestroomType restroomType = restroomTypeDAO.get(15);
        System.out.println("\n\nTest result:\nRestroom_Type_ID: " + restroomType.getRestroomTypeId() +
                "\nRestroom_Type_Name: " + restroomType.getName() +
                "\nRestroom_Toilet_Type: " + restroomType.getToiletType() +
                "\nRestroom_Toilets_Count: " + restroomType.getToiletsCount() +
                "\nRestroom_Bathrooms: " + restroomType.getBathtoomsCount());
    }

    @Test
    public void update() {
        RestroomType restroomType = restroomTypeDAO.get(16);
        restroomType.setName("Five+Five");
        restroomType.setBathtoomsCount(5);
        restroomType.setToiletsCount(5);
        restroomType.setToiletType(ToiletType.Not_Combined);
        restroomTypeDAO.update(restroomType);
    }

    @Test
    public void delete() {
        restroomTypeDAO.delete(4);
    }

}
