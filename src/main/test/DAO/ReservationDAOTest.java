package DAO;

import com.aliaksey.DAO.ReservationDAO;
import com.aliaksey.entity.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Kirik on 25.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/dispatcher-servlet.xml" })
public class ReservationDAOTest {

    @Autowired(required = true)
    public ReservationDAO reservationDAO;

    @Test
    public void add() {
        Reservation reservation = new Reservation();
        reservation.setDateIn(new Date());
        reservation.setDateOut(new Date());
        reservationDAO.add(reservation);
    }

    @Test
    public void getAll() {
        List<Reservation> reservationList = reservationDAO.getAll();
        for (Reservation reservation: reservationList) {
            System.out.println("\n\nTest result:\nReservation_ID: " + reservation.getReservationId() +
                    "\nTransaction_ID: " + reservation.getTransaction() +
                    "\nRoom_Number: " + reservation.getRoom() +
                    "\nUser_ID: " + reservation.getUser() +
                    "\nData_In: " + reservation.getDateIn() +
                    "\nData_Out: " + reservation.getDateOut());
        }
    }

    @Test
    public void getById() {
        Reservation reservation = reservationDAO.get(1);
        System.out.println("\n\nTest result:\nReservation_ID: " + reservation.getReservationId() +
                "\nTransaction_ID: " + reservation.getTransaction() +
                "\nRoom_Number: " + reservation.getRoom() +
                "\nUser_ID: " + reservation.getUser() +
                "\nData_In: " + reservation.getDateIn() +
                "\nData_Out: " + reservation.getDateOut());
    }

    @Test
    public void update() {
        Reservation reservation = reservationDAO.get(2);
        reservation.setDateIn(new Date());
        reservation.setDateOut(new Date());
        reservationDAO.update(reservation);
    }

    @Test
    public void delete() {
        reservationDAO.delete(3);
    }
}
