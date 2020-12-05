package portScanner;

import java.net.InetAddress;
import java.util.LinkedList;
public class ResultThread extends Thread{
	private LinkedList portList;
	public ResultThread(LinkedList portsList) {
		this.portList =portsList;
	}
	@Override
	public void run() {
		try {
		int from =10;
		int to = 65000;
		int NUMBER_OF_THREADS = 10;
		int portPerThread = (to - from)/NUMBER_OF_THREADS;
		InetAddress targetIp= InetAddress.getByName("localhost");
		Thread[] threads = new Thread[NUMBER_OF_THREADS];
		int portsCounter = from;
		for (int i = 0; i < threads.length; i++) {
			int end=portsCounter+portPerThread;
			threads[i] = new Thread(new PortScanner(targetIp,portsCounter,end,portList));
			threads[i].setDaemon(false);
			threads[i].start();
			portsCounter += portPerThread;
			if (i==9) {
				threads[i] = new Thread(new PortScanner(targetIp,portsCounter,to,portList)); 
				threads[i].start();
			}	
		}
		System.out.println("threads started and i am waiting for result");
		Thread.sleep(30000);
		for(int i=0; i<portList.size();i++) {
			System.out.println(portList.get(i));
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
