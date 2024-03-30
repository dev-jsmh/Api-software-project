/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "product_category")
class ProductCategoryModel {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;

    // relationships with other entities 
   @JsonIgnoreProperties("catergory")
    @OneToMany(mappedBy = "category")
    private Set<ProductModel> products = new HashSet<>();

    // constructor with parameters
    public ProductCategoryModel(Long id, String name) {
        this.categoryId = id;
        this.name = name;
    }

    // Empty constructor
    public ProductCategoryModel() {
    }

    // Entity methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }

}
