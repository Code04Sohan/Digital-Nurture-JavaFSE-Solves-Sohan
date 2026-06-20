import java.util.*;

public class q2 {
    public static void main(String[] args) {
        int a;
        int b;
        String ops = "+";
        int c = 0;
        Scanner SC = new Scanner(System.in);
        System.out.println("Enter 2 number one by one");
        a = SC.nextInt();
        b = SC.nextInt();   
        SC.nextLine();
        System.out.println("Enter The Operation You want.");
        ops = SC.nextLine();
        
        switch (ops) {
            case "+":
                c= a+b;
                break;
            case "-":
                c= a-b;
                break;
            case "*":
                c= a*b;
                break;
            case "/":
                c= a/b;
                break;
            default:
                System.out.println("Invalid");
        }
        System.out.printf("%d + %d = ANSWER: %d",a,b,c);
        SC.close();
    }
}
