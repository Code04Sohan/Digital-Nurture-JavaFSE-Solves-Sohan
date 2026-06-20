import java.util.*;

public class q10 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int targate = r.nextInt(100) + 1;
        System.err.println("Debug: " + targate);// just to test
        System.out.println("Enter Your Guess btwn 1 to 100");
        while (true) {
            int choose = sc.nextInt();
            if (choose == targate) {
                System.out.println("You Winn!!! Yayyyy , Targate was --> " + targate);
                break;
            } else if (choose < targate) {
                System.out.println("You are Less than tagrage!!");
            } else if (choose > targate) {
                System.out.println("You are Grater than tagrage!!");
            }
        }
        sc.close();
    }
}
