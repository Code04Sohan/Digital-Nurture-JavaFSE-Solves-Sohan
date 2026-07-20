public class q12 {
    public static int add(int a, int b){
        int c = a + b;
        return c;
    }
    public static double add(double a , double b){
        double c = a + b;
        return c;
    }
    public static int add(int a , int b, int c){
        int d = a+b+c;
        return d;
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int c = 9;
        double d = 5.5;
        double e = 7.7;

        System.out.println(add(a, b));
        System.out.println(add(a, b, c));
        System.out.println(add(d, e));
    }

}
