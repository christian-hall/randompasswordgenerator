import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
					String password = getPassword(characters, numbers, lowercase, uppercase, special);
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
	
	private static String getPassword(int characters, String numbers, String lowercase, String uppercase, String special) {
		String password = "";
		List<String> passoptions = new ArrayList<>();
		if (numbers.equalsIgnoreCase("y")) {
			List<String> passnumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
			for (int i = 0; i < passnumbers.size(); i++) {
				passoptions.add(passnumbers.get(i));
			}
		}
		if (lowercase.equalsIgnoreCase("y")) {
			List<String> passlowercs = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
			for (int i =0; i < passlowercs.size(); i++) {
				passoptions.add(passlowercs.get(i));
			}
		}
		if (uppercase.equalsIgnoreCase("y")) {
			List<String> passuppercs = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
			for (int i = 0; i < passuppercs.size(); i++) {
				passoptions.add(passuppercs.get(i));
			}
		}
		if (special.equalsIgnoreCase("y")) {
			List<String> passspecial = Arrays.asList("@", "%", "+", "\\", "/", "'", "!", "!", "#", "$", "^", "?", ":", ",", "(", ")", "{", "}", "[", "]", "~", "-", "_", ".");
			for (int i = 0; i < passspecial.size(); i++) {
				passoptions.add(passspecial.get(i));
			}
		}
		for (int i = 0; i < characters; i++) {
			// append random characters to password
		}
		return password;
	}

}
