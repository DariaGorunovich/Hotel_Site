package DAO;

import com.aliaksey.DAO.TransactionDAO;
import com.aliaksey.entity.Transaction;
import org.hibernate.PropertyValueException;
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
public class TransactionDAOTest {

    @Autowired(required = true)
    public TransactionDAO transactionDAO;

    @Test
    public void add() {
        Transaction transaction = new Transaction();
        transaction.setDate(new Date());
        transaction.setPaymentData("Payment Info...");
        transactionDAO.add(transaction);
    }

    @Test
    public void getAll() {
        List<Transaction> transactionList = transactionDAO.getAll();
        for (Transaction transaction: transactionList) {
            System.out.println("\n\nTest result:\nTransaction_ID: " + transaction.getTransactionId() +
                    "\nDate: " + transaction.getDate() +
                    "\nPayment_Data: " + transaction.getPaymentData());
        }
    }

    @Test
    public void getById() {
        Transaction transaction = transactionDAO.get(1);
        System.out.println("\n\nTest result:\nTransaction_ID: " + transaction.getTransactionId() +
                "\nDate: " + transaction.getDate() +
                "\nPayment_Data: " + transaction.getPaymentData());
    }

    @Test
    public void update() {
        Transaction transaction = transactionDAO.get(1);
        transaction.setDate(new Date());
        transaction.setPaymentData("New Payment Info...");
        transactionDAO.update(transaction);
    }

    @Test
    public void delete() {

        transactionDAO.delete(10000);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void setNegativeId() throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(-9);
        transactionDAO.update(transaction);
    }

    @Test(expected = PropertyValueException.class)
    public void setNullData() throws Exception {
        Transaction transaction = new Transaction();
        transaction.setDate(null);
        transactionDAO.add(transaction);
    }

    @Test(expected = NullPointerException.class)
    public void getByIdError() throws Exception {
        Transaction transaction = transactionDAO.get(10000);
        System.out.println("\n\nTest result:\nTransaction_ID: " + transaction.getTransactionId() +
                "\nDate: " + transaction.getDate() +
                "\nPayment_Data: " + transaction.getPaymentData());
    }

    @Test(expected = NullPointerException.class)
    public void updateError() throws Exception {
        Transaction transaction = transactionDAO.get(0);
        transaction.setDate(new Date(-1));
        transaction.setPaymentData(null);
        transactionDAO.update(transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteError() throws Exception {
        transactionDAO.delete(null);
    }
}
