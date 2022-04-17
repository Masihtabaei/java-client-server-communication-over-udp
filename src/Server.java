import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server extends Endpoint {


    public Server(int portNumber) throws SocketException {
        socket = new DatagramSocket(portNumber);
        run();
    }

    protected void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(packet);
                InetAddress hostAddress = packet.getAddress();
                int portNumber = packet.getPort();
                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message Received: " + receivedMessage);
                String messageToSend = "Acknowledged Message: " + receivedMessage;
                sendBuffer = messageToSend.getBytes();
                packet = new DatagramPacket(sendBuffer, sendBuffer.length, hostAddress, portNumber);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                if (socket != null)
                    socket.close();
                break;
            }
        }
    }

}
