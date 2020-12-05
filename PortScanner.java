package portScanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;

public class PortScanner implements Runnable{
	LinkedList ports;
	private InetAddress targetAddress;
	private int from;
	private int to;
	
	public PortScanner(InetAddress targetAddress,int from,int to,LinkedList ports) {
		if(from < 1)
			throw new IllegalArgumentException("Port must start from 1 upto 65535");
		if(to >65535)
			throw new IllegalArgumentException("Port must start from 1 upto 65535");
		this.ports = ports;
		this.targetAddress = targetAddress;
		this.from = from;
		this.to = to;
	}
	@Override
	public void run() {
					
						for(int port=from; port<=to; port++) {
							try {
								Socket socket = new Socket();
								socket.connect(new InetSocketAddress(targetAddress,port),1);
//								System.out.println("i am thread "+ Thread.currentThread().getName());
								if(socket.isConnected()){
									synchronized (ports) {
//									System.out.println(port+"open");
									ports.add(port);
									socket.close();
									}
								}
							} catch (Exception e) {}
							}
					
	}
}

