package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/25/2016.
 */
public class AddComment extends Command {
    private String NAME = COMMAND_ADD_COMMENT;
    private String DESCRIPTION = "Add comment to request." + "\n\t" + "Example: '"
            + NAME + COMMAND_SEPARATOR
            + "requestName" + COMMAND_SEPARATOR_TO_STRING
            + "comment" + COMMAND_SEPARATOR_TO_STRING + "'";
    private final int EXPECTED_COUNT_PARAMETERS = 2;

    public AddComment(View view, Storeable store) {
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
        store.addComment(parameters[0], parameters[1]);
    }
}
