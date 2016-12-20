package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/20/2016.
 */
public class ShowRequest extends Command {
    private final String NAME = COMMAND_NAME_SHOW_REQUEST;
    private final int EXPECTED_COUNT_PARAMETERS = 1;

    public ShowRequest(View view, Storeable store) {
        super(view, store);
    }

    @Override
    public void execute() {
        checkCountParameters(EXPECTED_COUNT_PARAMETERS);
        view.write(store.receiveRequest(parameters[0]).toString());
    }

    @Override
    public String getName() {
        return NAME;
    }

}
