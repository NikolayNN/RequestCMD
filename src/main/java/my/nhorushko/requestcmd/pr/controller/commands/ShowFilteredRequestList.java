package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.FilterFactory;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/25/2016.
 */
public class ShowFilteredRequestList extends Command{
    private final String NAME = COMMAND_SHOW_FILTERED_REQUEST_LIST;
    private final int EXPECTED_COUNT_PARAMETERS = 1;
    private String DESCRIPTION = "Show request by name. Example: '"
            + NAME + COMMAND_SEPARATOR_TO_STRING
            + "requestName" + "'";

    public ShowFilteredRequestList(View view, Storeable store) {
        super(view, store);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute() {
        checkCountParameters(EXPECTED_COUNT_PARAMETERS);
        FilterFactory filterFactory = new FilterFactory();
        filterFactory.filter(store.receiveRequests(), parameters[0]);
    }
}
