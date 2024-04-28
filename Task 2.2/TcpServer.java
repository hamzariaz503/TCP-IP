import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        // Create a TCP/IP socket
        ServerSocket serverSocket = new ServerSocket(10241);

        // Listen for incoming connections
        System.out.println("Waiting for a connection...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connection established");

        // Get input and output streams
        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

        // Continuously receive and send data
        while (true) {
            String encryptedData = input.readUTF();
            System.out.println("Received encrypted data: " + encryptedData);

            // Perform decryption
            String decryptedData = decrypt(encryptedData);
            System.out.println("Sending decrypted data: " + decryptedData);
            output.writeUTF(decryptedData);
        }
    }

    private static String decrypt(String encryptedData) {
        // Implement decryption logic here
        return encryptedData.toLowerCase(); // Simple example of decryption by converting to lower case
    }
}
