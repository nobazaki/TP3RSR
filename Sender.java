import java.io.*;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket();
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
            File file = new File("file.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            while (fis.read(buffer) > 0) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4446);
                socket.send(packet);
            }
            fis.close();
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
