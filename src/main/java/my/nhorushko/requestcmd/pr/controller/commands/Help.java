package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.controller.CommandFactory;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/25/2016.
 */
public class Help extends Command {
    private final String NAME = COMMAND_HELP;
    private final int EXPECTED_COUNT_PARAMETERS = 0;

    public Help(View view, Storeable store) {
        super(view, store);
    }


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void execute() {
        checkCountParameters(EXPECTED_COUNT_PARAMETERS);
        view.write(new CommandFactory(view, store).printAvailableCommands());
    }
}
