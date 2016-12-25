package my.nhorushko.requestcmd.pr.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Nikol on 12/17/2016.
 */
public class Request implements Serializable {
    private String name;
    private String description;
    private Date startDate;
    private List<String> comments;

    public Request(String name, String description, String startDate) {
        this.name = name;
        this.description = description;
        setStartDate(startDate);
        comments = new ArrayList<>();
    }

    public Request(String name, String description, Date startDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        comments = new ArrayList<>();
    }

    public void setStartDate(String source) {
        SimpleDateFormat parse = new SimpleDateFormat("dd.MM.yyyy");
        try {
            parse.setTimeZone(TimeZone.getTimeZone("GMT"));
            startDate = parse.parse(source);

        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", comments=" + comments +
                '}'; //todo more beatyful
    }
}
