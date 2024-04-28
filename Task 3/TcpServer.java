import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        // Create a TCP/IP socket
        ServerSocket serverSocket = new ServerSocket(10243);

        // Continuously listen for incoming connections
        while (true) {
            System.out.println("Waiting for a connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established with client " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

            // Get input and output streams
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            // Receive file name from the client
            String fileName = input.readUTF();
            System.out.println("Received file: " + fileName);

            // Open the file and send its contents to the client
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, bytesRead);
            }
            System.out.println("Sent file: " + fileName);

            // Close the socket
            clientSocket.close();
        }
    }
}
