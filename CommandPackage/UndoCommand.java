package CommandPackage;

import java.util.Vector;

import AJCS.Member;
import WLTS.Client;

public class UndoCommand implements Command {

	@Override
	public void execute() {
		System.out.println("UndoCommand released");

	}

	@Override
	public void getPrepare(Vector<Member> memberlist,
			Vector<Client> clientList, Vector<Command> undo,
			Vector<Command> redo) {
		// TODO Auto-generated method stub

	}

}
