import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class q27 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String commna (,) separated.");
        String inputString = sc.nextLine();
        String[] arrStrings = {};
        sc.close();

        for (int i = 0; i < inputString.length(); i++) {
            arrStrings = inputString.split(",");
        }

        for (String element : arrStrings) {
            names.add(element);
        }

        // Use of Lanbda Expp
        Collections.sort(names, (ele1 , ele2) -> ele1.compareTo(ele2));   
        names.forEach((n)->System.out.println(n));
    }
}
