package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.testutils.TestUtils;
import my.nhorushko.requestcmd.pr.view.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Nikol on 12/20/2016.
 */
public class ShowRequestTest {
    private View view;
    private Storeable store;
    private Command command;

    @Before
    public void setup(){
        view = mock(View.class);
        store = mock(Storeable.class);
        command = new ShowRequest(view, store);
    }

    @Test
    public void execute() {
        String reqName = "name";
        command.setup(Command.COMMAND_NAME_SHOW_REQUEST + Command.COMMAND_SEPARATOR + reqName);
        when(store.receiveRequest(reqName)).thenReturn(new Request("name", "description", "12.12.2012"));
        command.execute();
        assertEquals("[Request{name='name', description='description', startDate=Wed Dec 12 04:00:00 MSK 2012, comments=[]}]", TestUtils.readConsoleView(view));
    }

}