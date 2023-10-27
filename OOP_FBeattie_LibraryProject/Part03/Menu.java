package part03;

import console.Console;

/**
 * @author Fiona Beattie
 *
 */
public class Menu {
	private String items[];
	private String title;
	private Console input;

	public Menu(String title, String data[], Console input) {
		this.title = title;
		this.items = data;
		this.input = input;
	}

	public int getUserChoice() {
		display(input);
		input.print("Enter Selection: ");
		String value = input.readLn();
		int choice = Integer.parseInt(value);
		return choice;
	}

	private void display(Console input) {
		input.println(title);
		for (int i = 0; i < title.length(); i++) {
			input.print("+");
		}
		input.println();
		for (int opt = 1; opt <= items.length; opt++) {
			input.println(opt + ". " + items[opt - 1]);
		}
		input.println();
	}

}
