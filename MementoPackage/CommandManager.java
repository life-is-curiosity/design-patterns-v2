package MementoPackage;

import CommandPackage.Command;

public interface CommandManager {

	public void storeCommand(Command cmd);

	public void clearAllCommand();

	public void undo();

	public void redo() throws InstantiationException, IllegalAccessException;

}
