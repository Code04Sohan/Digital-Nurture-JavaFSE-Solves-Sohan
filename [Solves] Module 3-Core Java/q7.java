// ===========[Note]===========
// Widening casting is done automatically
// Narrowing casting must be done manually

public class q7 {
   public static void main(String[] args) {
    double a = 5.5;
    int b =(int) a; //Narrowing

    System.out.println("Type Cast [double to int]"+b);

    int c = 6;
    double d = c; //Widening
    
    System.out.println("Type Cast [int to double]"+d);
   } 
}
