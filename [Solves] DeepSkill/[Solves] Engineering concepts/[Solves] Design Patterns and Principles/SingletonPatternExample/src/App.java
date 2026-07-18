public class App {
    public static void main(String[] args) throws Exception {
        try {
            LoggerTest.LoggerGetTest();
            System.out.println("Instance Invoke Success");
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
}
