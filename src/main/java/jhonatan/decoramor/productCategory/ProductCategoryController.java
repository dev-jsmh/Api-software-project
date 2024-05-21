/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.productCategory;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@RequestMapping("/api/v1/products/categories")
public class ProductCategoryController {

    // create a field for the service 
    private final ProductCategoryService productCategoryService;

    // inject the service as a dependency here
    public ProductCategoryController(
            ProductCategoryService productCategoryService) {
        // initialize variable inside the constructor
        this.productCategoryService = productCategoryService;
    }

    // =================== Methods ===================
    // =================== Get all ====================
    @GetMapping
   public List<ProductCategoryModel> getAllCategories(){
       return this.productCategoryService.getAll();
   }
    // =================== Get by id ==================
   @GetMapping("/{category_id}")
   public ProductCategoryModel getCategoryById(@PathVariable("category_id") Long category_id){
       return this.productCategoryService.getById(category_id);
   }
    // =================== Create =====================
   @PostMapping
   public ProductCategoryModel createNewCategory(@RequestBody ProductCategoryModel newProductCategory ){
       return this.productCategoryService.create(newProductCategory);
   }
    // =================== Update =====================
   @PutMapping("/{category_id}")
   public ProductCategoryModel updateCategory(@PathVariable("category_id") Long category_id, @RequestBody ProductCategoryModel modProductCategory ){
       return this.productCategoryService.update(category_id, modProductCategory);
   }
    // =================== Delete =====================
   @DeleteMapping("/{category_id}")
   public void deleteCategory(@PathVariable("category_id") Long category_id){
     this.productCategoryService.delete(category_id);
   }
}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
