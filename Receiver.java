import java.io.*;
import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
            byte[] buffer = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            FileOutputStream fos = new FileOutputStream("received_file.txt");
            while (true) {
                socket.receive(packet);
                if (new String(packet.getData(), 0, packet.getLength()).equals("end")) {
                    break;
                }
                fos.write(packet.getData(), 0, packet.getLength());
            }
            fos.close();
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
