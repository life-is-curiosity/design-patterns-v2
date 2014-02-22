package Tools;

import java.util.Scanner;
import java.util.Vector;
import AJCS.*;
import WLTS.*;
import CommandPackage.Command;

public class AJCSAdapter extends AdvancedMem implements Adapter {

	private Vector<Member> memberList = new Vector<Member>();
	private Vector<Client> clientList = new Vector<Client>();
	private Vector<Command> undoList = new Vector<Command>();
	private Vector<Command> redoList = new Vector<Command>();
	private Scanner sc = new Scanner(System.in);

	public AJCSAdapter(Vector<Member> members) {
		super(members);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object create() {
		return super.createMem();
	}

	@Override
	public Object search(Object id) {
		return super.searchMem((String) id);
	}

	@Override
	public void update(Object id) {
		super.updateAddress((String) id);
	}

	@Override
	public void extendExpiryDate(Object id) {

	}

	@Override
	public boolean isExpired(Object id) {
		return false;
	}

	@Override
	public void getPrepare(Vector<Member> memberlist,
			Vector<Client> clientList, Vector<Command> undo,
			Vector<Command> redo) {

		this.memberList = memberlist;
		this.clientList = clientList;
		this.undoList = undo;
		this.redoList = redo;
	}

}
