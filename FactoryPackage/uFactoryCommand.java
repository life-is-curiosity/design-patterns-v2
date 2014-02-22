package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.UndoCommand;

public class uFactoryCommand implements Factory {

	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new UndoCommand();
	}

}
