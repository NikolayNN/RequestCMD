package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.testutils.TestUtils;
import my.nhorushko.requestcmd.pr.view.View;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Nikol on 12/24/2016.
 */
public class ShowRequestListTest {
    private View view;
    private Storeable store;
    private Command command;

    @Before
    public void setup() {
        view = mock(View.class);
        store = mock(Storeable.class);
        command = new ShowRequestList(view, store);
    }

    @Test
    public void execute() throws Exception {
        command.setup(Command.COMMAND_SHOW_REQUEST_LIST);
        List actual = new ArrayList();
        actual.add(new Request("name", "description", "12.12.2012"));
        actual.add(new Request("name2", "description2", "13.13.2013"));
        when(store.receiveRequests()).thenReturn(actual);
        command.execute();
        assertEquals("[[====================\n" +
                "name:name\n" +
                "description:description\n" +
                "date:12.12.112\n" +
                "comments:\n" +
                ", ====================\n" +
                "name:name2\n" +
                "description:description2\n" +
                "date:13.1.114\n" +
                "comments:\n" +
                "]]", TestUtils.readConsoleView(view));
    }

}