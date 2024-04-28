import java.net.*;
import java.io.*;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        // Create a UDP/IP socket
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");

        // Send data
        byte[] sendData = "Hello from the client".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 10000);
        socket.send(sendPacket);

        // Receive response
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received: " + received);

        // Close the socket
        socket.close();
    }
}
