package by.hotel.bean;

/**
 * Created by Dashutka on 26.08.2017.
 */
import by.hotel.builder.FeedbackBuilder;
import org.springframework.stereotype.Component;

@Component
public class Feedback {
    private int id;
    private String feedb;
    private User user;

    public Feedback() {
        super();
    }

    public Feedback(FeedbackBuilder feedbackBuilder) {
        this.id = feedbackBuilder.getId();
        this.feedb = feedbackBuilder.getFeedback();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedb;
    }

    public void setFeedback(String feedback) {
        this.feedb = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (!feedb.equals(feedback.feedb)) return false;
        return user.equals(feedback.user);
    }

    @Override
    public int hashCode() {
        int result = feedb.hashCode();
        result = 31 * result + user.hashCode();
        return result;

    }
}
