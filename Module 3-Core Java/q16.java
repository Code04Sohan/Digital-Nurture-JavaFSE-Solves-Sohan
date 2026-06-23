import java.util.Scanner;

public class q16 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String input = sc.nextLine().toLowerCase();
        sc.close();
        sb.append(input);
        String newString = sb.reverse().toString();
        if (input.equals(newString)) {
            System.out.printf("%s == %s : is palindrome",input,newString);
        }else{
            System.out.printf("%s != %s is not palindrome",input,newString);
        }
    }
}
