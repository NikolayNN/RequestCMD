package my.nhorushko.requestcmd.pr.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nikol on 12/25/2016.
 */
public class FilterFactoryTest {
    private FilterFactory filterFactory;

    @Before
    public void setup(){
        filterFactory = new FilterFactory();

    }

    @Test
    public void filter() {
        List<Request> requests = new ArrayList();
        requests.add(new Request("name", "description", "2.02.2012"));
        requests.add(new Request("name2", "description2", "2.02.2012"));
        requests.add(new Request("name3", "description3", "2.02.2012"));
        List<Request> actual = filterFactory.filter(requests, "nameEq(name)");
        assertEquals("", actual.toString());
    }

    @Test
    public void filter2() {
        List<Request> requests = new ArrayList();
        requests.add(new Request("name", "description", "2.02.2012"));
        requests.add(new Request("name", "description2", "2.02.2012"));
        requests.add(new Request("name3", "blb", "2.02.2012"));
        List<Request> actual = filterFactory.filter(requests, "nameEq(name), descCon(desc)");
        assertEquals("", actual.toString());
    }

}