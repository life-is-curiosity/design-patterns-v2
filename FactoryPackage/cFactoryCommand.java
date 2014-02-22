package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.CreateCommand;

public class cFactoryCommand implements Factory {

	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new CreateCommand();
	}

}
