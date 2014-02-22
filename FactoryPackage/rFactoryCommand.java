package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.RedoCommand;

public class rFactoryCommand implements Factory {
	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new RedoCommand();
	}

}
