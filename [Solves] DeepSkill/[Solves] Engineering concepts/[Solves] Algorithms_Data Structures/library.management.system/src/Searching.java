public class Searching {
    public static int binarySearch(Book[] arr, int id, int low, int high) {

        if (high >= low) {

            int mid = low + (high - low) / 2;

            if (arr[mid].bookId == id) {
                return mid;
            }

            if (arr[mid].bookId > id) {
                return binarySearch(arr, id, low, mid - 1);
            }

            else {
                return binarySearch(arr, id, mid + 1, high);
            }
        }

        return -1;
    }
}