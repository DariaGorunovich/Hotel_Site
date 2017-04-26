package DAO;

import com.aliaksey.DAO.ReservationDAO;
import com.aliaksey.DAO.RoomDAO;
import com.aliaksey.DAO.TransactionDAO;
import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.Auth;
import com.aliaksey.entity.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Autowired(required = true)
    public TransactionDAO transactionDAO;

    @Autowired(required = true)
    public RoomDAO roomDAO;

    @Autowired(required = true)
    public UserDAO userDAO;

    @Test
    public void add() {
        Reservation reservation = new Reservation();
        reservation.setTransaction(transactionDAO.get(30));
        reservation.setRoom(roomDAO.get(26));
        reservation.setUser(userDAO.get(1));
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

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeId() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setReservationId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullData() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setDateOut(null);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        Reservation reservation = reservationDAO.get(10000);
        System.out.println("\n\nTest result:\nReservation_ID: " + reservation.getReservationId() +
                "\nTransaction_ID: " + reservation.getTransaction() +
                "\nRoom_Number: " + reservation.getRoom() +
                "\nUser_ID: " + reservation.getUser() +
                "\nData_In: " + reservation.getDateIn() +
                "\nData_Out: " + reservation.getDateOut());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateError() throws Exception {
        Reservation reservation = reservationDAO.get(2);
        reservation.setDateIn(new Date(null));
        reservation.setDateOut(new Date(-1));
        reservationDAO.update(reservation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        reservationDAO.delete(null);
    }
}
