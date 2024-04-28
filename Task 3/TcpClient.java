import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        // Create a TCP/IP socket
        Socket socket = new Socket("localhost", 10243);
        System.out.println("Connected to server. Port number: " + socket.getLocalPort());

        // Get input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Read the file name from the user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of file: ");
        String fileName = in.nextLine();
        output.writeUTF(fileName);
        in.close();

        // Receive the file contents from the server and write them to a new file
        FileOutputStream fileOutputStream = new FileOutputStream("received_" + fileName);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }
        System.out.println("Received file: " + fileName);

        // Close the socket and streams
        fileOutputStream.close();
        socket.close();
    }
}
