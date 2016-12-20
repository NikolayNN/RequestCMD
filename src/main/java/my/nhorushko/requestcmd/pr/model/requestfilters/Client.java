package my.nhorushko.requestcmd.pr.model.requestfilters;

import my.nhorushko.requestcmd.pr.model.Request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nikol on 12/18/2016.
 */
public class Client {
    public static void main(String[] args) {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("support", "supD1", new Date()));
        requests.add(new Request("support", "supD2", new Date()));
        requests.add(new Request("feedback", "supF1", new Date()));
        Filter filter = new FilterByDescription(new FilterByName(new BasicFilter(requests), "support"), "supD1");
        System.out.println(filter.doWork());
    }
}
