import java.util.*;

public class q5 {
    public static void main(String[] args) {
        int a = 0;
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter the number you want mul table:");
        a = sc.nextInt();

        sc.close();

        for (int i = 0; i <= 10; i++) {
            int c = a * i;
            System.out.printf("%d X %d = %d ", a, i, c);
            System.out.println();
        }
    }
}
