import java.net.SocketException;

public class ServerTest {
    public static void main(String[] args) {
        try {
            Server server = new Server(5000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
