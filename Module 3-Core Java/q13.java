public class q13 {
    public static int fibbonachi(int n){
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        return fibbonachi(n-1) + fibbonachi(n-2);
    }
    public static void main(String[] args) {
      System.out.println(fibbonachi(10));  
    }
}
