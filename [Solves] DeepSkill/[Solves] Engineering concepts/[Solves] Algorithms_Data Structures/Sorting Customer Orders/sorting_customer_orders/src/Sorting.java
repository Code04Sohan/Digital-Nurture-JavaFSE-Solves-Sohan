
public class Sorting {
    public static void bubbleSort(Product[] arrProducts) {
        for (int i = 0; i < arrProducts.length; i++) {
            for (int j = i + 1; j < arrProducts.length; j++) {
                if (arrProducts[i].getId() > arrProducts[j].getId()) {
                    Product temp = arrProducts[i];
                    arrProducts[i] = arrProducts[j];
                    arrProducts[j] = temp;
                }
            }
        }
    }

    public static void quickSort(Product[] arrProducts, int low, int high) {
        if (low < high) {
            int pivot = partition(arrProducts, low, high);
            quickSort(arrProducts, low, pivot - 1);
            quickSort(arrProducts, pivot + 1, high);

        }

    }

    public static int partition(Product[] arrProducts, int low, int high) {
        int pivot = arrProducts[high].getId();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arrProducts[j].getId() <= pivot) {
                i++;
                Product temp = arrProducts[i];
                arrProducts[i] = arrProducts[j];
                arrProducts[j] = temp;
            }
        }

        Product temp = arrProducts[i + 1];
        arrProducts[i + 1] = arrProducts[high];
        arrProducts[high] = temp;
        return i + 1;
    }
}
