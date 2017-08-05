public class SynchronizedFactorizer {
    private static ThreadLocal<Connection> _connectionHolder = new ThreadLocal<Connection>();

    public static void main(String[] args) {
        System.out.println("Sync started");

        Connection myConn = _connectionHolder.get();

        System.out.println("")

    }
}