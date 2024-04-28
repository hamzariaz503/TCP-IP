import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        // Create a TCP/IP socket
        Socket socket = new Socket("localhost", 10235);

        // Get input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Read the text from file line by line
        File file = new File("info.txt");
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println("Sending: " + line);
            output.writeUTF(line);

            // Wait for the acknowledgement
            System.out.println("Received: " + input.readUTF());
        }

        // Close the socket
        socket.close();
    }
}
