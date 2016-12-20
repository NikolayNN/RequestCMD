package my.nhorushko.requestcmd.pr.model.requestfilters;

import my.nhorushko.requestcmd.pr.model.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikol on 12/18/2016.
 */
public class FilterByName extends RequestFilter {
    private String filterCondition;

    public FilterByName(Filter filter, String filterCondition) {
        super(filter);
        this.filterCondition = filterCondition;
    }

    @Override
    public List<Request> doFilter() {
        List<Request> result = new ArrayList<>();
        for (Request request : requests) {
            if(request.getName().equalsIgnoreCase(filterCondition)){
                result.add(request);
            }
        }
        return result;
    }

}
