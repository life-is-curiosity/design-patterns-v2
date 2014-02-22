package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.UpdateCommand;

public class aFactoryCommand implements Factory {

	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new UpdateCommand();
	}

}
