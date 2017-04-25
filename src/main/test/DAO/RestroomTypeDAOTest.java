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

    @Test()
    public void getAll() {
        List<RestroomType> restroomTypeList = restroomTypeDAO.getAll();
        for (RestroomType restroomType:
             restroomTypeList) {
            System.out.println("RestroomType id:" + restroomType.getRestroomTypeId() + "  RestroomType name: " + restroomType.getName());
        }
    }

    @Test()
    public void getById() {
        RestroomType restroomType = restroomTypeDAO.get(1);
        System.out.println("RestroomType id:" + restroomType.getRestroomTypeId() + "  RestroomType name: " + restroomType.getName());
    }

    @Test
    public void add() {
        RestroomType restroomType = new RestroomType();
        restroomType.setName("three");
        restroomType.setBathtoomsCount(3);
        restroomType.setToiletsCount(3);
        restroomType.setToiletType(ToiletType.Combined);
        restroomTypeDAO.add(restroomType);
    }

    @Test
    public void delete() {
        restroomTypeDAO.delete(4);
    }

}
