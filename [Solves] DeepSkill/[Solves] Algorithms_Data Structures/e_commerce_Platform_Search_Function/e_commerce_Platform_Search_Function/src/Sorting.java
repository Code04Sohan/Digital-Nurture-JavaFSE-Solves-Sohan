import java.util.*;

public class Sorting {
    public static void customSort(Product[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(Product::getId));
    }
}
