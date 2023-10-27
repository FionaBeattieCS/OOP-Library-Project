package part01;

import java.util.Scanner;

/**
 * @author Fiona Beattie
 *
 */
public class Menu {
	private String items[];
	private String title;
	private Scanner input;

	public Menu(String title, String data[]) {
		this.title = title;
		this.items = data;
		this.input = new Scanner(System.in);
	}

	public int getUserChoice() {
		display();
		System.out.print("Enter Selection: ");
		int value = input.nextInt();
		return value;
	}

	private void display() {
		System.out.println(title);
		for (int i = 0; i < title.length(); i++) {
			System.out.print("+");
		}
		System.out.println();
		for (int opt = 1; opt <= items.length; opt++) {
			System.out.println(opt + ". " + items[opt - 1]);
		}
		System.out.println();
	}

}
