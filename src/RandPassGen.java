
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
					int characters = Console.getInt("How many characters in this password? ", 0, (int)Double.POSITIVE_INFINITY);
					String numbers = Console.getString("Will there be numbers in this password? (y/n): ", "y", "n");
					String lowercase = Console.getString("Will there be lowercase letters in this password? (y/n): ", "y", "n");
					String uppercase = Console.getString("Will there be uppercase letters in this password? (y/n): ", "y", "n");
					String special = Console.getString("Will there be special characters in this password? (y/n): ", "y", "n");
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
			System.out.println();
		}
		System.out.println("Goodbye");

	}

}
