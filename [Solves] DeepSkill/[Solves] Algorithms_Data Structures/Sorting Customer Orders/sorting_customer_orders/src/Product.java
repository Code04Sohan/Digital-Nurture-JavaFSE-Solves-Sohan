
public class Product {
    private Integer productId;
    private String productName;
    private String category;

    public Product(Integer productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public Integer getId() {
        return productId;
    }

    public String getName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return productId + "/" + productName + "/" + category;
    }
}
