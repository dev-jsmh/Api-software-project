
/*
Developed by Jhonatan Samuel Martinez Hernandez 
Software Analyst and Developer
Year 2024
 */
package jhonatan.decoramor.productCategory;

public class ProductCategoryDto {
    
    private Long categoryId;
    private String name;
    
    // ========= Empty constructor =========
    public ProductCategoryDto(){}
    
    // ========= constructor with arguments =========
    public ProductCategoryDto(Long categoryId, String name ){
        this.categoryId = categoryId;
        this.name = name;
    }
   // ========= getters and setters =========

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
