import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int timeout = 200; // Milliseconds

        System.out.println("Scanning host: " + host);

        int[] ports = {21, 22, 23, 53, 80, 443, 8080};

        for (int port : ports) {
            if (isPortOpen(host, port, timeout)) {
                System.out.println("Port " + port + " is OPEN");
            } else {
                System.out.println("Port " + port + " is closed");
            }
        }
    }

    public static boolean isPortOpen(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}