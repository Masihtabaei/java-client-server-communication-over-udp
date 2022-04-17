import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Client client = new Client(5000, "localhost");
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
