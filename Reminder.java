package reconnecter;
import java.util.*;

public class Reminder {
	private static FriendNode connections;
	
	public static void main(String[] args) {
		connections = null;
		
		Scanner input = new Scanner(System.in);
		intro();
		boolean use = actions(input);	
		while (use == true) {
			use = actions(input);	
		}
	}
	
	public static void intro() {
		System.out.println("Welcome to Reconnecter!");
		System.out.println("Add the names of your friends you want to stay in touch with and");
		System.out.println("how many days it has been since you have talked to them last.");
		System.out.println();
	}
	
	public static boolean actions(Scanner input) {
		System.out.println("Please type a command:");
		System.out.println("   -> To add a connection type \"add\"");
		System.out.println("   -> To see all your connections type \"print connections\"");
		System.out.println("   -> When you are done type \"exit\"");


		String action = input.nextLine();
		if (action.toLowerCase().equals("exit")) {
			System.out.println();
			return false;
		} else if (action.toLowerCase().equals("add")) {
			System.out.println("What is your friends name?");
			String friend = input.next();
			System.out.println("How many days has it been since you last spoke to " + friend + "?");
			int days = input.nextInt();

			add(friend, days);
		} else if (action.toLowerCase().equals("print connections")) {
			printConnections();
		} else {
			System.out.println("That is not a vaild command.");
		}
		System.out.println();
		return true;
	}
	
	public static void printConnections() {
		if (connections == null) {
			System.out.println("You have no connections.");
		} else {
			FriendNode list = connections;
			System.out.println(list);
			while (list.hasNext()) {
				System.out.println(list.next);
				list = list.next;
			}
		}
	}
	
	public static void add(String friend, int days) {
		if (connections == null) {
			connections = new FriendNode(friend, days);
		} else {
			//just putting at front of list for now, worry about priority later.
			FriendNode temp = connections;
			connections = new FriendNode(friend, days);
			connections.next = temp;
		}
	}
}
