package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Created by Nikol on 12/19/2016.
 */
public class AddRequest extends Command {
    private String NAME = COMMAND_ADD_REQUEST;
    private String DESCRIPTION = "Add request. Example: '"
            + NAME + COMMAND_SEPARATOR_TO_STRING
            + "requestName" + COMMAND_SEPARATOR_TO_STRING
            + "requestDescription" + COMMAND_SEPARATOR_TO_STRING
            + "29.12.2012" + "'";
    private final int EXPECTED_COUNT_PARAMETERS = 3;

    public AddRequest(View view, Storeable store) {
        super(view, store);
    }

    @Override
    public void execute() {
        checkCountParameters(EXPECTED_COUNT_PARAMETERS);
        store.addRequest(new Request(parameters[0], parameters[1], parameters[2]));
        view.write("request added!");
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }


}
