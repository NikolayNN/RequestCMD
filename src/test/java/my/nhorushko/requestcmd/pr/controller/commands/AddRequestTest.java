package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.testutils.TestUtils;
import my.nhorushko.requestcmd.pr.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Nikol on 12/20/2016.
 */
public class AddRequestTest {
    private View view;
    private Storeable store;
    private Command command;

    @Before
    public void setup(){
        view = mock(View.class);
        store = mock(Storeable.class);
        command = new AddRequest(view, store);
    }

    @Test
    public void execute() {
        command.setup("add|name|descript|12.12.2012");
        command.execute();
        assertEquals("[request added!]", TestUtils.readConsoleView(view));
    }

    @Test(expected = RuntimeException.class)
    public void executeWrongCountParameters() {
        command.setup("add|name|descript|12.12.2012|wrong|count|parameter");
        command.execute();
    }

    @Test(expected = RuntimeException.class)
    public void executeWithoutParameters() {
        command.setup("add");
        command.execute();
    }

    @Test(expected = RuntimeException.class)
    public void executeWrongDateFormat() {
        command.setup("add|name|descript|wrongDateFormat");
        command.execute();
    }

}