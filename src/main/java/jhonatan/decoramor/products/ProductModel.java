/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.products;

import jhonatan.decoramor.productCategory.ProductCategoryModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jhonatan.decoramor.productOrderDetails.ProductOrderDetailModel;

@Entity
@Table(name = "products")
public class ProductModel {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    //@Column(name="name")
    private String name;
    //@Column(name="model")
    private String model;
    //@Column(name="description")
    private String description;
    //@Column(name="stock")
    private int stock;
    @Column(name = "image")
    private String imageUrl;
    private double price;

    // relationships with other entities
    @JsonIgnoreProperties("products")
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private ProductCategoryModel category;
    

    // Empty Constructor
    public ProductModel() {
    }

    // Constructor with parameters
    public ProductModel(
            Long productId,
            String name,
            String model,
            String description,
            ProductCategoryModel category,
            int stock,
            String imageUrl
    ) {
        this.productId = productId;
        this.name = name;
        this.model = model;
        this.description = description;

        this.category = category;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

    // entity methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategoryModel getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryModel category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
}
