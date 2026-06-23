import java.util.ArrayList;
import java.util.Scanner;

public class q26 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String commna (,) separated.");
        String inputString = sc.nextLine();
        String[] arrStrings = {};
        sc.close();

        for (int i = 0; i < inputString.length(); i++) {
            arrStrings = inputString.split(","); //regex = a sequence of special characters that forms a search pattern
        }

        for (String element : arrStrings) {
            names.add(element);
        }

        System.out.println(names);
    }
}
