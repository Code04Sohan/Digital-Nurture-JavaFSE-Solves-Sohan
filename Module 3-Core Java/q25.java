import java.util.*;
public class q25 {
    public static void main(String[] args) {
        HashMap<Integer, String> student = new HashMap<>();
        boolean input = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Just Press enter -1 to see the List");
        while (input) {
            Integer key;
            String val;
            // --------- Key ---------
            System.out.print("Enter Key : ");
            key = sc.nextInt();
            sc.nextLine(); //Buffer clear
            if (key == -1) {
                input = false;
                break;
            }

            // --------- Value ---------
            System.out.print("Enter Value : ");
            val = sc.nextLine(); 
            sc.nextLine();
            if (val == null) {
                input = false;
                break;
            }
            student.put(key, val);
        }
        sc.close();
        System.out.println(student);
    }
}
