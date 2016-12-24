package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.controller.exceptions.ExitException;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Nikol on 12/24/2016.
 */
public class ExitTest {
    private View view;
    private Command command;

    @Before
    public void setup(){
        view = mock(View.class);
        command = new Exit(view);
    }
    @Test(expected = ExitException.class)
    public void execute() throws Exception {
        command.setup(Command.COMMAND_EXIT);
        command.execute();
    }

}