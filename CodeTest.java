import java.util.Scanner;
import java.util.Vector;

import AJCS.Member;
import CommandPackage.*;
import FactoryPackage.*;
import Tools.*;
import WLTS.Client;

public class CodeTest {

	// Member list
	public static Vector<Member> memberList = new Vector<Member>();
	// Client list
	public static Vector<Client> clientList = new Vector<Client>();
	// Undo list
	public static Vector<Command> undoList = new Vector<Command>();
	// Redo list
	public static Vector<Command> redoList = new Vector<Command>();

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {

		// Command Controller
		CommandController controller = new CommandController();

		/*
		 * Java 1.7 new feature : << Try with resources statement >> The
		 * try-with-resources statement is a try statement that declares one or
		 * more resources. A resource is an object that must be closed after the
		 * program is finished with it. The try-with-resources statement ensures
		 * that each resource is closed at the end of the statement. Any object
		 * that implements java.lang.AutoCloseable, which includes all objects
		 * which implement java.io.Closeable, can be used as a resource.
		 */
		try (Scanner scanner = new Scanner(System.in)) {
			// Run endless looping until user request to exit
			while (true) {
				// Print header and available command list
				GetHeader.printHeader();

				try {
					try {
						// Get user input for calling command
						String input = scanner.next().toLowerCase().trim();

						// Create corresponding class for requested function
						Command cmd = ((Factory) Class.forName(
								"FactoryPackage." + input + "FactoryCommand")
								.newInstance()).concrete();
						// Pass needed valuable(s) to command class
						cmd.getPrepare(memberList, clientList, undoList,
								redoList);

						// set command
						controller.setCommand(cmd);
						// run command
						controller.runCommand();

					} catch (ClassNotFoundException classnotfound) {
						// Throw class not found exception by external class
						ExceptionManagement
								.factoryClassException(classnotfound);
					}
				} catch (Exception e) {
					// Throw other unfounded exceptions by external class
					ExceptionManagement.exception(e);
				}
			}// End loop
		}// Close scanner
	}
}
