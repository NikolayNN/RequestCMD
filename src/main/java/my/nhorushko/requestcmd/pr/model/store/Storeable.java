package my.nhorushko.requestcmd.pr.model.store;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.requestfilters.RequestFilter;

import java.util.List;

/**
 * Created by Nikol on 12/17/2016.
 */
public interface Storeable {
    void addRequest(Request request);
    void updateRequest(Request oldRequest, Request newRequest);
    void deleteRequest(String name);
    List<Request> receiveRequests();
    List<Request> receiveRequestWith(String condition);
    void addComment(String name, String Comment);
}
