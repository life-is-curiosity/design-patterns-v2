package FactoryPackage;

import CommandPackage.Command;
import CommandPackage.ShowCommand;

public class sFactoryCommand implements Factory {

	@Override
	public Command concrete() {
		// TODO Auto-generated method stub
		return new ShowCommand();
	}

}
