import java.util.LinkedList;

public class OpenPorts {
private static LinkedList <Integer>  listOfPortOpened = new LinkedList<Integer>();
	public static void displayPorts() {
		System.out.println("list of open ports");
		for(int port :  listOfPortOpened ) {
			System.out.println(port);
		}
	}
	public static void addPort(int soc) {
		listOfPortOpened.add(soc);
	}
	
}
