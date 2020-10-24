import java.io.IOException;
import java.net.*;

public class PortScan implements Runnable {
	private SocketAddress socketAddress;
	public SocketAddress getSocketAddress() {
		return socketAddress;
	}
	public void setSocketAddress(SocketAddress socketAddress) {
		this.socketAddress = socketAddress;
	}
	public PortScan(InetAddress target, int port){
		socketAddress = new InetSocketAddress(target, port);
	}
	@Override
	public void run(){
		Socket socket = new Socket();
		try {
			socket.connect(socketAddress,1);
			if(socket.isConnected()) {
				System.out.println(socket.getPort()+ " opened");
				OpenPorts.addPort(socket.getPort());
				socket.close();
			}
		} catch (IOException e) {
		}
	}

}
