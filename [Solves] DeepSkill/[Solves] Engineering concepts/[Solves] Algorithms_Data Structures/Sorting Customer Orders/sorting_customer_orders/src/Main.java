
public class Main {
    public static void main(String[] args) throws Exception {
        Product[] invintoryArr = {
                new Product(5, "AK47", "GUN"),
                new Product(4, "GLOCK", "GUN"),
                new Product(7, "RPG", "GUN"),
                new Product(4, "GRANADE", "GUN"),
                new Product(6, "M16", "GUN")
        };
        System.out.println("=======Before Sort=======");
        for (Product e : invintoryArr) {
            System.out.println(e);
        }
        System.out.println("=======After Sort=======");
        Sorting.bubbleSort(invintoryArr);
        for (Product e : invintoryArr) {
            System.out.println(e);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("=======Before Sort=======");
        for (Product e : invintoryArr) {
            System.out.println(e);
        }
        System.out.println("=======After Sort=======");
        Sorting.quickSort(invintoryArr, 0 , invintoryArr.length-1);
        for (Product e : invintoryArr) {
            System.out.println(e);
        }
    }
}
