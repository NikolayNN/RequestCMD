package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/19/2016.
 */
public class WrongCommand extends Command{

    public WrongCommand(View view) {
        super(view);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void execute() {
        view.write("You input wrong command");
    }
}
