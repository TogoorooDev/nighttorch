package nighttorch;

import java.net.Socket;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Client {
	public Peer peer;

	public Client(Peer peer){
		this.peer = peer;
	}
	
	public void send_echo() throws Exception{
		if (!this.peer.active){
			System.out.println("Innactive peer");
		}
		String hostname = this.peer.ip;
		int port = this.peer.port;
		Socket echo_socket = new Socket(hostname, port);
		DataOutputStream echo = new DataOutputStream(echo_socket.getOutputStream());
		echo.writeUTF("NT ECHO");
		echo.flush();

		echo.writeByte(-1);
		echo.flush();

		echo.close();
	}
}
