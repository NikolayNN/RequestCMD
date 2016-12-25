package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Nikol on 12/25/2016.
 */
public class AddCommentTest {
    private View view;
    private Storeable store;
    private Command command;

    @Before
    public void setup(){
        view = mock(View.class);
        store = mock(Storeable.class);
        command = new AddComment(view, store);
    }

    @Test
    public void execute() {
        final String requestName = "name";
        final String comment = "comment";
        command.setup(Command.COMMAND_ADD_COMMENT + Command.COMMAND_SEPARATOR_TO_STRING
                            + requestName + Command.COMMAND_SEPARATOR_TO_STRING
                            + comment);
        command.execute();
        verify(store).addComment(requestName, comment);
    }

}