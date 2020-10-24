import java.net.InetAddress;
import java.net.UnknownHostException;
public class PortScanner {
	public static void main(String[] args){
		InetAddress target = null;
		try {
			target = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e) {
			// e.printStackTrace();
		}
		Thread[] portsToBeScanned = new Thread[Integer.parseInt(args[2])-Integer.parseInt(args[1])];
		int thread= 0;
		for(int port=Integer.parseInt(args[1]);port<Integer.parseInt(args[2]);port++){
			portsToBeScanned[thread] = new Thread( new PortScan(target,port));
			portsToBeScanned[thread].start();
			try{portsToBeScanned[thread].join();}
			catch(Exception ex){
				System.out.println(ex);
			}
			thread++;
		}
	}
}
