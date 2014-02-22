package Tools;

public class ExceptionManagement {

	public static void factoryClassException(Exception ex) {
		// ex.printStackTrace();
		System.out.println();
		System.err.println("There may be no such Function. \n");
	}

	public static void invalidInputFormatException(Exception ex) {
		System.out.println();
		System.err.println("Invalid Foramt. \n");
	}

	public static void noSuchTypeException(Exception ex) {
		System.out.println();
		System.err.println("No such type. \n");
	}

	public static void invalidIdException(Exception ex) {
		System.out.println();
		System.err.println("Invalid id identifier.\n");
	}

	public static void nullInputException(Exception ex) {
		System.out.println();
		System.err.println("No input.\n");
	}

	public static void IdExistedException(Exception ex) {
		System.out.println();
		System.err.println("ID existed.\n");
	}

	public static void exception(Exception ex) {

		ex.printStackTrace();
		System.exit(1);
	}

}
