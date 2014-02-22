package CommandPackage;

import java.util.Vector;

import AJCS.Member;
import WLTS.Client;

public class ListCommand implements Command {

	private Vector<Member> memberList = new Vector<Member>();
	private Vector<Command> undoList = new Vector<Command>();
	private Vector<Command> redoList = new Vector<Command>();

	@Override
	public void execute() {
		System.out.println("ListCommand released");
	}

	@Override
	public void getPrepare(Vector<Member> memberlist,
			Vector<Client> clientList, Vector<Command> undo,
			Vector<Command> redo) {
		// TODO Auto-generated method stub
		
	}



}
