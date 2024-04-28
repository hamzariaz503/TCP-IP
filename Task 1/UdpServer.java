import java.net.*;
import java.io.*;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        // Create a UDP/IP socket
        DatagramSocket socket = new DatagramSocket(10000);

        // Create a buffer for incoming data
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // Continuously receive and send data
        while (true) {
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + received);

            byte[] sendData = received.getBytes();
            packet.setData(sendData);
            socket.send(packet);
        }
    }
}
