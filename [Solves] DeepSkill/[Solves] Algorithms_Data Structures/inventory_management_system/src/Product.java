public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return productId;
    }
    public String getName() {
        return productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    
    public void setName(String productName) {
        this.productName = productName;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public void display(){
        System.out.printf("Product ID : %d || Product Name : %s || Product Quantity : %d || Product Price : %f %n", productId, productName , quantity , price);
    }
}   

