

public class q30 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // Object obj = sc.nextLine();
        // sc.close();
        Object obj = 20;
        String descrip = switch(obj) {
            case String s -> "It is a String"+s;
            case Integer i -> "It is a Integer"+i;
            case Double d -> "It is a Double"+d;
            case null -> "It is a null value";
            default -> "Unk type of object";
        };
        System.out.println(descrip);
    }
}
