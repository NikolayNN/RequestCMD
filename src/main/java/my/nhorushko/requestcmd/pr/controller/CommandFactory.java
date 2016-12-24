package my.nhorushko.requestcmd.pr.controller;

import my.nhorushko.requestcmd.pr.controller.commands.*;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/17/2016.
 */
public class CommandFactory {
    private View view;
    private Command[] availableCommand;

    public CommandFactory(View view, Storeable store) {
        this.view = view;
        availableCommand = new Command[]{
                new AddRequest(view, store),
                new Exit(view),
                new ShowRequest(view, store),
                new ShowRequestList(view, store)
        };
    }


    public Command createCommand(String source) {
        String commandStr = source.split(Command.COMMAND_SEPARATOR)[0];
        for (Command command : availableCommand) {
            if (command.getName().equalsIgnoreCase(commandStr)) {
                command.setup(source);
                return command;
            }
        }
        return new WrongCommand(view);
    }

}
