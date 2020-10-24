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
		// initilizing the socket by giving the sring ip or domian and port number type int
	}
	@Override
	public void run(){
		// create an empty socket object
		Socket socket = new Socket();
		try {
			//  connect with server having socket address --> socketAddress
			// and the time out integer value if the server does not response
			socket.connect(socketAddress,1);
			if(socket.isConnected()) { //  if socket is Connected mean the port is opened
				System.out.println(socket.getPort()+ " opened");
				// closing the socket
				socket.close();
			}
		}
		catch (IOException e) {
		}
	}

}
