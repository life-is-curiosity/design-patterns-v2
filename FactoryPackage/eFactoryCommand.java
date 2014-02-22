package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.ExtendCommand;

public class eFactoryCommand implements Factory {

	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new ExtendCommand();
	}

}
