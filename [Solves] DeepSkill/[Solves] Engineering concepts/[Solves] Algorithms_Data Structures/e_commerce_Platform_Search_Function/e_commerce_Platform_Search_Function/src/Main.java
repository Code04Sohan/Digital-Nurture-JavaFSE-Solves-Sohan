
public class Main {
    public static void main(String[] args) throws Exception {
        Product[] invintoryArr = {
                new Product(5, "AK47", "GUN"),
                new Product(4, "GLOCK", "GUN"),
                new Product(7, "RPG", "GUN"),
                new Product(4, "GRANADE", "GUN"),
                new Product(6, "M16", "GUN")
        };
        int size = invintoryArr.length;
        int key = 7;
        String found = Searching.linearSearch(invintoryArr, size, key).getName();
        for (Product e : invintoryArr) {
            System.out.println(e);
        }
        System.out.println("Product Found : " + found);
        System.out.println("----------------------------------------------");
        Sorting.customSort(invintoryArr);
        for (Product e : invintoryArr) {
            System.out.println(e);
        }
        String foundBi = Searching.binarrySearchPeProduct(invintoryArr, key).getName();
        System.out.println("Product Found Binary Search: " + foundBi);
    }
}
