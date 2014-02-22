package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.ExitCommand;

public class xFactoryCommand implements Factory {

	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new ExitCommand();
	}

}
