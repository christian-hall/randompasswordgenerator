import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandPassGen {
	// DC Connection Variables
	static Connection connection = null;
	static String databaseName = "passwordmanager";
	static String url = "jdbc:mysql://localhost:3306/" + databaseName;
	static String username = "rpg_user";
	static String password = "sesame";

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(url, username, password);
		
		System.out.println("--------- RANDOM PASSWORD GENERATOR ---------");
		System.out.println("BY CHRISTIAN HALL -------------------- v. 1.0");
		System.out.println();
		String quit = "n";
		while (quit.equalsIgnoreCase("n")) {
			String menu = "-";
			while (!menu.equalsIgnoreCase("q")) {
				System.out.println("---------- Main Menu ----------");
				System.out.println("N - New Random Password");
				System.out.println("L - List Previous Passwords");
				System.out.println("A - About App");
				System.out.println("Q - Quit");
				menu = Console.getString("type choice, then enter (n/l/a/q): ", true);
				System.out.println();
				if (menu.equalsIgnoreCase("n")) {
					// generate new password and add it to SQL
					int characters = Console.getInt("How many characters in this password? (1-20): ", 0, 21);
					String numbers = Console.getString("Will there be numbers in this password? (y/n): ", "y", "n");
					String lowercase = Console.getString("Will there be lowercase letters in this password? (y/n): ",
							"y", "n");
					String uppercase = Console.getString("Will there be uppercase letters in this password? (y/n): ",
							"y", "n");
					String special = Console.getString("Will there be special characters in this password? (y/n): ",
							"y", "n");
					String genpassword = getPassword(characters, numbers, lowercase, uppercase, special);
					System.out.println("\nPassword: " + genpassword);
					
					PreparedStatement insertPassword = connection.prepareStatement("INSERT INTO PASSWORDMANAGER.PASSWORDS (result) VALUES ('" + genpassword + "');");	
					int status = insertPassword.executeUpdate();
					if (status != 0) {
						System.out.println("...successfully added to database\n");
					} else {
						System.out.println("ERROR: SQL not connected. Not added to database\n");
					}
					
				} else if (menu.equalsIgnoreCase("l")) {
					System.out.println("-------- Past Passwords -------");
					ResultSet oldPasswords = connection.createStatement().executeQuery("SELECT result FROM PASSWORDMANAGER.PASSWORDS;");
					while (oldPasswords.next()) {
						System.out.println(oldPasswords.getString("result"));
					}
					System.out.println("");
				} else if (menu.equalsIgnoreCase("a")) {
					System.out.println("------------ About ------------");
					System.out.println("Created using STS and MySQL Wor");
					System.out.println("kbench just to connect STS and ");
					System.out.println("SQL for a full stack app down  ");
					System.out.println("the road. Thanks for checking  ");
					System.out.println("it out.");
					System.out.println();
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

	private static String getPassword(int characters, String numbers, String lowercase, String uppercase,
			String special) {
		String genpassword = "";
		List<String> passoptions = new ArrayList<>();
		if (numbers.equalsIgnoreCase("y")) {
			List<String> passnumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
			for (int i = 0; i < passnumbers.size(); i++) {
				passoptions.add(passnumbers.get(i));
			}
		}
		if (lowercase.equalsIgnoreCase("y")) {
			List<String> passlowercs = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
					"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
			for (int i = 0; i < passlowercs.size(); i++) {
				passoptions.add(passlowercs.get(i));
			}
		}
		if (uppercase.equalsIgnoreCase("y")) {
			List<String> passuppercs = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
					"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
			for (int i = 0; i < passuppercs.size(); i++) {
				passoptions.add(passuppercs.get(i));
			}
		}
		if (special.equalsIgnoreCase("y")) {
			List<String> passspecial = Arrays.asList("@", "%", "+", "\\", "/", "'", "!", "#", "$", "^", "?", ":", ",",
					"(", ")", "{", "}", "[", "]", "~", "-", "_", ".");
			for (int i = 0; i < passspecial.size(); i++) {
				passoptions.add(passspecial.get(i));
			}
		}
		for (int i = 0; i < characters; i++) {
			genpassword = genpassword + passoptions.get((int) (Math.random() * passoptions.size()));
		}
		return genpassword;
	}

}
