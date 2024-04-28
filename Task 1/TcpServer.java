import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        // Create a TCP/IP socket
        ServerSocket serverSocket = new ServerSocket(10234);

        // Listen for incoming connections
        System.out.println("Waiting for a connection...");
        // when req come then accept it and assign it to new communication socket
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connection established");

        // Get input and output streams
        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

        // Continuously receive and send data
        while (true) {
            String received = input.readUTF();
            System.out.println("Received: " + received);
            output.writeUTF(received);
        }
    }
}
