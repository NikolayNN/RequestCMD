package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.controller.exceptions.ExitException;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/24/2016.
 */
public class Exit extends Command {
    private final String NAME = COMMAND_EXIT;
    private final int EXPECTED_COUNT_PARAMETERS = 0;

    public Exit(View view) {
        super(view);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() {
        checkCountParameters(EXPECTED_COUNT_PARAMETERS);
        view.write("Goodbye");
        throw new ExitException();
    }
}
