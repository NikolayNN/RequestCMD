package my.nhorushko.requestcmd.pr.controller;

import my.nhorushko.requestcmd.pr.controller.commands.Command;
import my.nhorushko.requestcmd.pr.controller.exceptions.ExitException;
import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.model.store.XMLFile;
import my.nhorushko.requestcmd.pr.model.store.XmlManager;
import my.nhorushko.requestcmd.pr.view.Console;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/19/2016.
 */
public class Controller {
    public void start() {
        View view = new Console();
        Storeable store = new XmlManager(new XMLFile("requestStore.xml"));
        CommandFactory commandFactory = new CommandFactory(view, store);
        view.write("Hello!");
        while (true) {
            try {
                view.write("Input your command or 'help'...");
                String input = view.read();
                Command command = commandFactory.createCommand(input);
                command.execute();
            } catch (ExitException e) {
                System.exit(1);
            } catch (Exception e) {
                view.write(e.getMessage());
            }

        }
    }
}
