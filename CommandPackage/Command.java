package CommandPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import AJCS.Member;
import WLTS.Client;

public interface Command {

	public void execute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

	public void getPrepare(Vector<Member> memberlist,Vector<Client> clientList , Vector<Command> undo,
			Vector<Command> redo);

}
