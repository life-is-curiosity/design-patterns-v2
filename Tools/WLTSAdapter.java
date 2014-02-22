package Tools;

import java.util.Scanner;
import java.util.Vector;

import AJCS.*;
import CommandPackage.Command;
import WLTS.*;

public class WLTSAdapter extends ClientCare implements Adapter {

	private Vector<Member> memberList = new Vector<Member>();
	private Vector<Client> clientList = new Vector<Client>();
	private Vector<Command> undoList = new Vector<Command>();
	private Vector<Command> redoList = new Vector<Command>();
	private Scanner sc = new Scanner(System.in);
	
	public WLTSAdapter(Vector<Client> vect) {
		super(vect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object create() {
		return super.createClient();
	}

	@Override
	public Object search(Object id) {
		return super.foundClient((int) id);
	}

	@Override
	public void update(Object id) {
		super.amendAddress((int) id);
	}

	@Override
	public void extendExpiryDate(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isExpired(Object id) {
		// TODO Auto-generated method stub
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
