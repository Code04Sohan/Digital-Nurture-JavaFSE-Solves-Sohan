public class LoggerTest {
    public static void LoggerGetTest() {
        // 1. Get two separate instance references
        Logger instance1 = Logger.getInstance();
        Logger instance2 = Logger.getInstance();

        // 2. Verify they point to the exact same memory address
        if (instance1 == instance2) {
            System.out.println("TEST PASSED: Both references point to the same Singleton instance.");
            System.out.println("Instance 1 Hash: " + instance1.hashCode());
            System.out.println("Instance 2 Hash: " + instance2.hashCode());
        } else {
            System.out.println("TEST FAILED: Multiple instances were created!");
        }
    }
}
