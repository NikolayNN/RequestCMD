package my.nhorushko.requestcmd.pr.model.requestfilters;

import my.nhorushko.requestcmd.pr.model.Request;

import java.util.List;

/**
 * Created by Nikol on 12/18/2016.
 */
public class BasicFilter extends RequestFilter {

    public BasicFilter(List<Request> requests) {
        super(requests);
    }

    @Override
    public List<Request> doFilter() {
        return requests;
    }
}
