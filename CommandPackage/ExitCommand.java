package CommandPackage;

import java.util.Vector;

import AJCS.Member;
import WLTS.Client;

public class ExitCommand implements Command {

	@Override
	public void execute() {

		System.out.println();
		System.out.println("System Terminated.");
		// Exit system with exit code 0
		System.exit(0);
	}


	@Override
	public void getPrepare(Vector<Member> memberlist,
			Vector<Client> clientList, Vector<Command> undo,
			Vector<Command> redo) {
		// TODO Auto-generated method stub
		
	}

}
