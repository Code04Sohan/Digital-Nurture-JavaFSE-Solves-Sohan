import java.util.*;

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;
        System.out.printf("Enter Year: ");
        year = sc.nextInt();
        sc.close();
        if (year > 0) {
            if (year % 4 == 0) {
                System.out.printf("The Year %d is a leap year", year);
            } else if (year % 400 == 0) {
                System.out.printf("The Year %d is a leap year", year);
            } else {
                System.out.printf("The %d Year is not a leap year", year);
            }
        }
    }
}
