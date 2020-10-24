import java.net.InetAddress;
import java.net.UnknownHostException;

public class PortScanner {
	public static void main(String[] args){
		// ip addres object of target
		InetAddress target = null;
		try {
			// take the ip string or domain name and make it the ip target
			target = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e) {
			// e.printStackTrace();
		}
		// each port is scanned with separate thread for fast scanning
		//  we can create threads array implenmenting Runnable
		//  NOTE: we can not create array or thrad extended from thread class
		Thread[] portsToBeScanned = new Thread[Integer.parseInt(args[2])-Integer.parseInt(args[1])];
		int thread= 0;
		for(int port=Integer.parseInt(args[1]);port<Integer.parseInt(args[2]);port++){
			// here initilize the thread and give a target ip and port to that thread
			portsToBeScanned[thread] = new Thread( new PortScan(target,port));
			portsToBeScanned[thread].start(); // starting the thread
			try{ portsToBeScanned[thread].join(); } // joining all threads so that every thread executed
			// and wait for thread executed before the current thread
			catch(Exception ex){
				System.out.println(ex);
			}
			thread++;
		}
	}
}
