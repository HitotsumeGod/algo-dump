/* 
 * Proof of concept for the single-socket modular client/server model I proposed.
 * The modularity comes in the form of the simple try/catch statement proceeding immediately following the initial overarching try.
 * If a given connection attempts to connect to its identical peer first (thus naturally encountering no server to accept a connection) it transforms into a server and waits to accept the peer's connection instead.
 * Responses are read asynchronously using a single raw thread that terminates upon receiving null.
 */

import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class TwoWay {

	private static final int PORT = 6666;
	private static final int SLUMBER = 500;

	public static void doTwoWayConnection(String hostname) {
	
		Socket sock;
		ServerSocket server;
		BufferedReader stdin;
		//BufferedReader reader;	cannot be declared due to lambda requirements
		BufferedWriter writer;
		String sus;
		Thread t;

		server = null;
		try {
			try {
				sock = new Socket(hostname, PORT);
			} catch (IOException noConnect) {
				server = new ServerSocket(PORT);
				sock = server.accept();
			}
			assert(sock.isConnected());
			System.out.println("Connected to opponent.");
			stdin = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			assert(stdin.ready());
			assert(reader.ready());
			System.out.println("Beginning bloodsports.");
			t = new Thread(() -> {
					String line;
					try {
						while ((line = reader.readLine()) != null) {
							System.out.println("Message received : " + line);
							Thread.sleep(SLUMBER);
						}
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}
				});
			t.start();
			while (t.isAlive()) {
				sus = stdin.readLine();
				writer.write(sus, 0, sus.length());
				writer.newLine();
				writer.flush();
			}
			stdin.close();
			reader.close();
			writer.close();
			sock.close();
			if (server != null)
				server.close();
			System.out.println("Connection terminated. I'm sorry, Elizabeth.");
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

}
