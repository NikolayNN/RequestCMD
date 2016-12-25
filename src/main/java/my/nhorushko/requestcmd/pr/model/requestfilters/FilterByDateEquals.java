package my.nhorushko.requestcmd.pr.model.requestfilters;

import my.nhorushko.requestcmd.pr.model.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Nikol on 12/25/2016.
 */
public class FilterByDateEquals extends RequestFilter {
    private String filterCondition;

    public FilterByDateEquals(Filter filter, String filterCondition) {
        super(filter);
        this.filterCondition = filterCondition;
    }

    private Date convertDate(String source) {
        SimpleDateFormat parse = new SimpleDateFormat("dd.MM.yyyy");
        try {
            parse.setTimeZone(TimeZone.getTimeZone("GMT"));
            return parse.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Request> doFilter() {
        List<Request> result = new ArrayList<>();
        for (Request request : requests) {
            if((request.getStartDate().compareTo(convertDate(filterCondition)) == 0)){
                result.add(request);
            }
        }
        return result;
    }
}
