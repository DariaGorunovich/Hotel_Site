package by.hotel.builder;

/**
 * Created by Dashutka on 26.08.2017.
 */
import by.hotel.bean.Feedback;
import by.hotel.bean.User;

public class FeedbackBuilder {
    private int id;
    private String feedb;
    private User user;

    public FeedbackBuilder id(int id){
        this.id = id;
        return this;
    }

    public FeedbackBuilder feedb(String feedb){
        this.feedb = feedb;
        return this;
    }

    public FeedbackBuilder user(User user){
        this.user = user;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFeedback() {
        return feedb;
    }

    public User getUser() {
        return user;
    }

   /* public Feeadback build() {
        return new Feedback();
    }*/


}
