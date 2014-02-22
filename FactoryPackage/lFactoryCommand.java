package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.ListCommand;

public class lFactoryCommand implements Factory {

	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new ListCommand();
	}

}
