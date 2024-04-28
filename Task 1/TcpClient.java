import java.net.*;
import java.io.*;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        // Create a TCP/IP socket
        Socket socket = new Socket("localhost", 10234);

        // Get input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Send data and receive response
        output.writeUTF("Hello from the client");
        System.out.println("Received: " + input.readUTF());

        // Close the socket
        socket.close();
    }
}