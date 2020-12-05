package portScanner;

import java.util.LinkedList;

public class PortScannerTest {
	public static void main(String[] args) throws Exception {
		LinkedList portList = new LinkedList();
		 Thread t= new ResultThread(portList);
		 t.setDaemon(true);
		 t.start();
		 t.join();
		 System.out.println("main End");
	}
}
