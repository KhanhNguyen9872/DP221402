package buoi5.MVC_CommandProcessor.command_processor;

public class CommandProcessor {
    private static CommandProcessor commandProcessorRemote = null;
    private CommandProcessor() {

    }
    public static CommandProcessor makeCommandProcessor() {
        if (commandProcessorRemote == null) {
            commandProcessorRemote = new CommandProcessor();
        }
        return commandProcessorRemote;
    }
    public void execute(Command cmd) {
        cmd.execute();
    }
}
