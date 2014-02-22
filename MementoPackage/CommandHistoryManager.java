package MementoPackage;

import java.util.Vector;

import AJCS.Member;
import CommandPackage.Command;

public class CommandHistoryManager implements CommandManager {

	Vector<Member> memberList = new Vector<Member>();
	Vector<Command> undoList = new Vector<Command>();
	Vector<Command> redoList = new Vector<Command>();

	public void storeCommand(Command cmd) {
		undoList.add(cmd);
	}

	public void clearAllCommand() {
		undoList.clear();
		
		redoList.clear();
	}

	public void undo() {
		if (undoList.size() <= 0)
			return;
		Command cmd = ((Command) (undoList.get(undoList.size() - 1)));
		//cmd.getPrepare(memberList, undoList, redoList);
		undoList.remove(cmd);
		redoList.add(cmd);
	}

	public void redo() throws InstantiationException, IllegalAccessException {
		if (redoList.size() <= 0)
			return;
		Command cmd;
		try {
			cmd = ((Command) (redoList.get(redoList.size() - 1)));
			cmd.execute();
			redoList.remove(cmd);
			undoList.add(cmd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
