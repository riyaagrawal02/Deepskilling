public class SingletonTest {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        firstLogger.log("First logger instance created.");
        secondLogger.log("Second logger reference requested.");

        System.out.println("Same instance: " + (firstLogger == secondLogger));
    }
}
