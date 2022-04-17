import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client extends Endpoint {
    private final int PORT_NUMBER;
    private final InetAddress HOST_ADDRESS;

    public Client(int portNumber, String hostAddress) throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        this.PORT_NUMBER = portNumber;
        this.HOST_ADDRESS = InetAddress.getByName(hostAddress);
        run();
    }


    protected void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Please enter your message: ");
                String messageTosSend = scanner.nextLine();
                sendBuffer = messageTosSend.getBytes();
                DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, HOST_ADDRESS, PORT_NUMBER);
                socket.send(packet);
                packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(packet);
                String messageReceived = new String(packet.getData(), 0, packet.getLength());
                System.out.println(messageReceived);
            } catch (IOException e) {
                e.printStackTrace();
                if (socket != null)
                    socket.close();
                break;
            }
        }
    }
}
