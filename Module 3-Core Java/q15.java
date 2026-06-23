import java.util.Scanner;

public class q15 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String input = sc.nextLine();
        sc.close();
        sb.append(input);
        sb.reverse().toString();
        System.out.println(sb);
    }
}
