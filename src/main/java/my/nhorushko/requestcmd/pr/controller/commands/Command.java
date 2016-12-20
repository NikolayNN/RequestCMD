package my.nhorushko.requestcmd.pr.controller.commands;

import my.nhorushko.requestcmd.pr.model.store.Storeable;
import my.nhorushko.requestcmd.pr.view.View;

/**
 * Created by Nikol on 12/19/2016.
 */
public abstract class Command {
    public static final String COMMAND_NAME_ADD_REQUEST = "add";
    public static final String COMMAND_SEPARATOR = "\\|";
    protected String[] commandParams;
    protected View view;
    protected Storeable store;
    protected String command;
    protected String[] parameters;

    public Command(View view) {
        this.view = view;
    }

    public Command(View view, Storeable store) {
        this.view = view;
        this.store = store;
    }

    public abstract String getName();

    public abstract void execute();

    protected void checkCountParameters(int expectedCount){
        if(expectedCount != parameters.length){
            throw new RuntimeException("ERROR. Invalid count parameters expect '" + expectedCount
                    + "', but actual '" + parameters.length + "'");
        }
    }

    private void getCommandParams(String source){
        String[] splitedInput = source.split(COMMAND_SEPARATOR);
        parameters = new String[splitedInput.length - 1];
        if (splitedInput.length > 1) {
            System.arraycopy(splitedInput, 1, parameters, 0, parameters.length);
        }
    }

    public void setup(String source) {
        getCommandParams(source);
    }
}
