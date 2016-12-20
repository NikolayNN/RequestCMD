package my.nhorushko.requestcmd.pr.model.requestfilters;

import my.nhorushko.requestcmd.pr.model.Request;

import java.util.List;

/**
 * Created by Nikol on 12/18/2016.
 */
public abstract class Filter {
    public abstract List<Request> doFilter();
    public List<Request> doWork(){
        return doFilter();
    }
}
