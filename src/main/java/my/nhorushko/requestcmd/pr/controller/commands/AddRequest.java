package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

import java.text.SimpleDateFormat;

/**
 * Created by Nikol on 12/19/2016.
 */
public class AddRequest extends Command {
    private String NAME = COMMAND_NAME_ADD_REQUEST;
    private final int EXPECTED_COUNT_PARAMETERS = 3;

    public AddRequest(View view, Storeable store) {
        super(view, store);
    }

    @Override
    public void execute() {
        checkCountParameters(EXPECTED_COUNT_PARAMETERS);
        store.addRequest(new Request(parameters[0], parameters[1], parameters[2]));
    }

    @Override
    public String getName() {
        return NAME;
    }



}
