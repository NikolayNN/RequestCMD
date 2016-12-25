package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/25/2016.
 */
public class UpdateRequest extends Command {
    private static final String OPEN_CONDITION = "(";
    private static final String CLOSE_CONDITION = ")";
    private static final String NEW_NAME = "newName";
    private static final String NEW_DESCRIPTION = "newDesc";
    private static final String NEW_DATE = "newDate";
    private final String NAME = COMMAND_UPDATE_REQUEST;
    private final int EXPECTED_COUNT_PARAMETERS = 2;

    private String DESCRIPTION = "Update request 'newName', 'newDesc', 'newDate'." + "\n\t" + "Example: '"
            + NAME + COMMAND_SEPARATOR_TO_STRING
            + "requestNameForUpdate" + COMMAND_SEPARATOR_TO_STRING
            + "newName(newName), newDesc(newDesc), newDate(12.12.2012)" + "'";

    public UpdateRequest(View view, Storeable store) {
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
        String requestNameForUpdate = parameters[0];
        String conditions = parameters[1];
        Request requestForUpdate = store.receiveRequest(requestNameForUpdate);
        updateRequest(conditions, requestForUpdate);
        store.updateRequest(requestNameForUpdate, requestForUpdate);
    }

    private void updateRequest(String conditions, Request updatedRequest) {
        String[] parseString = conditions.split(",");
        for (String s : parseString) {
            String condition = s.substring(s.indexOf(OPEN_CONDITION) + 1, s.indexOf(CLOSE_CONDITION));
            if (s.contains(NEW_NAME)) {
                updatedRequest.setName(condition);
            }
            if (s.contains(NEW_DESCRIPTION)) {
                updatedRequest.setDescription(condition);
            }
            if (s.contains(NEW_DATE)) {
                updatedRequest.setStartDate(condition);
            }
        }
    }
}
