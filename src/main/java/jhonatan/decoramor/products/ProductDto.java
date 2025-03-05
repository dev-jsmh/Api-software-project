/*
Jhonatan Samuel Martinez Hernandez
Software Analyst and Developer
Year 2024
 */
package jhonatan.decoramor.products;

import jhonatan.decoramor.productCategory.ProductCategoryDto;

public class ProductDto {

    private Long productId;
    private String name;
    private String model;
    private String description;
    private int stock;
    private String imageUrl;
    private ProductCategoryDto category;

    // ========== getters and setters ==========
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

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

    public ProductCategoryDto getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryDto category) {
        this.category = category;
    }

}
