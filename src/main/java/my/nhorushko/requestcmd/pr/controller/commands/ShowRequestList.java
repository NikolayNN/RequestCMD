package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/24/2016.
 */
public class ShowRequestList extends Command {
    private final String NAME = COMMAND_NAME_SHOW_REQUEST_LIST;
    private final int EXPECTED_COUNT_PARAMETERS = 0;

    public ShowRequestList(View view, Storeable store) {
        super(view, store);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        checkCountParameters(EXPECTED_COUNT_PARAMETERS);
        view.write(store.receiveRequests().toString());
    }
}