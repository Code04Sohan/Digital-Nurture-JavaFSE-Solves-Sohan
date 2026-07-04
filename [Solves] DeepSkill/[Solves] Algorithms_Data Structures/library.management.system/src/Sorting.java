import java.util.Arrays;
import java.util.Comparator;
public class Sorting {
    public static void customSort(Book[] arr){
        Arrays.sort(arr, Comparator.comparingInt(Book::getId));
    }
}
