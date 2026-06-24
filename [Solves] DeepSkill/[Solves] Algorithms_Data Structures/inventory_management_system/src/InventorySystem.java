import java.util.*;

public class InventorySystem {
    HashMap<Integer, Product> invintory; // Make it global variable to use in all methonds

    public InventorySystem() {
        invintory = new HashMap<>();
    }

    // ----------------- ADD Product -----------------
    public void addProduct(Product product){
        if (invintory.containsKey(product.getId())) {
            System.out.println("This Product Already Exsists");
        }else{
            invintory.put(product.getId(), product);
        }
    }

    // ----------------- UPDATE Product -----------------
    public void updateProduct(int productId, Integer newQuantity, Integer newPrice, String newName) { // Note : Primitive types like int cannot be null—they default to 0.
        if (invintory.containsKey(productId)) {
           Product updateProduct = invintory.get(productId);
           if (newQuantity != null) {
            updateProduct.setQuantity(newQuantity);
           }
           if (newPrice != null) {
            updateProduct.setPrice(newPrice);
           }
           if (newName != null) {
            updateProduct.setQuantity(newQuantity);
           }
        }else{
            System.out.println("Produt is not added or exsist in Invintory");
        }
    }

    // ----------------- DELETE Product -----------------
    public void deleteProduct(int productId) {
        if (invintory.containsKey(productId)) {
            invintory.remove(productId);
        }
    }

    // ----------------- DISPLAY Product -----------------
    public void displayProduct(){
        System.out.println("Welcome to Very Normal Store");
        invintory.forEach((t, u) -> u.display());
    }
}
