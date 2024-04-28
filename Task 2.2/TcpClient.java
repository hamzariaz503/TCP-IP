import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        // Create a TCP/IP socket
        Socket socket = new Socket("localhost", 10241);

        // Get input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Read the data from the file
        File file = new File("info.txt");
        Scanner in = new Scanner(file);
        StringBuilder data = new StringBuilder();
        while (in.hasNextLine()) {
            data.append(in.nextLine());
        }
        in.close();

        // Perform encryption
        String encryptedData = encrypt(data.toString());
        System.out.println("Sending encrypted data: " + encryptedData);
        output.writeUTF(encryptedData);

        // Receive decrypted data from the server
        String decryptedData = input.readUTF();
        System.out.println("Received decrypted data: " + decryptedData);

        // Close the socket
        socket.close();
    }

    private static String encrypt(String data) {
        // Implement encryption logic here
        return data.toUpperCase(); // Simple example of encryption by converting to upper case
    }
}
