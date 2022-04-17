import java.net.DatagramSocket;

public abstract class Endpoint {
    protected DatagramSocket socket;
    protected byte[] receiveBuffer;
    protected byte[] sendBuffer;

    public Endpoint() {
        receiveBuffer = new byte[256];
    }

    protected abstract void run();
}
