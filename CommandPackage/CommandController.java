package CommandPackage;

import java.lang.reflect.InvocationTargetException;

public class CommandController {

	Command cmd;

	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}

	public void runCommand() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		cmd.execute();
	}
}
