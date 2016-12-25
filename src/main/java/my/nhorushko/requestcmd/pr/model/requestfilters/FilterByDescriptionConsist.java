package my.nhorushko.requestcmd.pr.model.requestfilters;

import my.nhorushko.requestcmd.pr.model.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikol on 12/25/2016.
 */
public class FilterByDescriptionConsist extends RequestFilter {
    private String filterCondition;

    public FilterByDescriptionConsist(Filter filter, String filterCondition) {
        super(filter);
        this.filterCondition = filterCondition;
    }

    @Override
    public List<Request> doFilter() {
        List<Request> result = new ArrayList<>();
        for (Request request : requests) {
            if(request.getDescription().contains(filterCondition)){
                result.add(request);
            }
        }
        return result;
    }
}
