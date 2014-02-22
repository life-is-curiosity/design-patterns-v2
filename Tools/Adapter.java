package Tools;

import java.util.Vector;

import AJCS.Member;
import CommandPackage.Command;
import WLTS.Client;

public interface Adapter {
	
	public Object create();

	public Object search(Object id);

	public void update(Object id);

	public void extendExpiryDate(Object id);

	public boolean isExpired(Object id);

	public void getPrepare(Vector<Member> memberlist,
			Vector<Client> clientList, Vector<Command> undo,
			Vector<Command> redo);
}
