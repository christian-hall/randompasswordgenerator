
public class RandPassGen {

	public static void main(String[] args) {
		System.out.println("--------- RANDOM PASSWORD GENERATOR ---------");
		System.out.println("BY CHRISTIAN HALL -------------------- v. 1.0");
		System.out.println();
		String quit = "n";
		while(quit.equalsIgnoreCase("n")) {
			String menu = "-";
			while (!menu.equalsIgnoreCase("q")) {
				System.out.println("---------- Main Menu ----------");
				System.out.println("N - New Random Password");
				System.out.println("L - List Passwords");
				System.out.println("A - About App");
				System.out.println("Q - Quit");
				menu = Console.getString("type choice, then enter (n/l/a/q): ", true);
				System.out.println();
				if(menu.equalsIgnoreCase("n")) {
					// generate new password and add it to SQL
				} else if (menu.equalsIgnoreCase("l")) {
					// retrieve passwords from SQL
				} else if (menu.equalsIgnoreCase("a")) {
					// list information about this application
				} else if (menu.equalsIgnoreCase("q")) {
					break;
				} else {
					System.out.println("Please select a valid option");
					System.out.println();
				}
				
			}
			quit = Console.getString("Are you sure? (y/n): ", "y", "n");
		}
		System.out.println("\nGoodbye");

	}

}
