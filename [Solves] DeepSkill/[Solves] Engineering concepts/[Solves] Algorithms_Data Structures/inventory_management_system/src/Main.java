public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(1, "AK47", 10, 45000);
        Product p2 = new Product(2, "GLOCK", 15, 45000);
        Product p3 = new Product(3, "HK16", 12, 45000);
        Product p4 = new Product(4, "RPG", 5, 45000);

        InventorySystem veryNormalStore = new InventorySystem();

        veryNormalStore.addProduct(p1);
        veryNormalStore.addProduct(p2);
        veryNormalStore.addProduct(p3);
        veryNormalStore.addProduct(p4);
        veryNormalStore.addProduct(p3);
        veryNormalStore.addProduct(p1);
        //veryNormalStore.deleteProduct(4);

        veryNormalStore.displayProduct();
        veryNormalStore.updateProduct(1, 20, null, null);
        veryNormalStore.displayProduct();
    }
}
