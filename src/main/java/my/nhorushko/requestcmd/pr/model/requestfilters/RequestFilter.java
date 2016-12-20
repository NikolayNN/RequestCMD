package my.nhorushko.requestcmd.pr.model.requestfilters;

import my.nhorushko.requestcmd.pr.model.Request;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikol on 12/18/2016.
 */
public abstract class RequestFilter extends Filter {
    protected static List<Request> requests;
    protected Filter filter;

    public RequestFilter(List<Request> requests) {
        this.requests = requests;
    }

    public RequestFilter(Filter filter) {
        this.filter = filter;
    }

    public abstract List<Request> doFilter();

}
