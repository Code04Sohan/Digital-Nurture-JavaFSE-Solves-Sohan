public class Searching {
    public static Product linearSearch(Product[] arr, int size, int key) {
        Product foundProduct = null;
        for (Product product : arr) {
            if (product.getId() == key) {
                foundProduct = product;
                break;
            }
        }
        return foundProduct;
    }

    public static Product binarrySearchPeProduct(Product[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid].getId() == key) {
                return arr[mid];
            }

            if (arr[mid].getId() < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

}
