package Tools;

public class GetHeader {

	private static final String header = "X Member Management System\nPlease Enter Command : [c|s|a|e|u|r|l|X]";
	private static final String availableCommands = "c = Create membership, s = Show membership details, a = Update address, e = extend membership, u = undo, r = redo, l = List undo/redo, X = Exit system";

	private static void printInformation() {
		System.out.println(header);
	}

	private static void printAvailableCommands() {
		System.out.println(availableCommands);
	}

	public static void printHeader() {
		printInformation();
		printAvailableCommands();
	}

}
