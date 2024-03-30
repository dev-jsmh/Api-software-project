
package jhonatan.decoramor.products;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class ProductCategoryService {

    // category repository field
    private final IProductCategoryRepository ProductCategoryRepository;

    // create constructor and inject dependencies here
    public ProductCategoryService(IProductCategoryRepository ProductCategoryRepository) {
        this.ProductCategoryRepository = ProductCategoryRepository;
    }

    // Create a new category 
    public ProductCategoryModel createCategory(ProductCategoryModel newCategory) {
        // call the service and save the new category
        return this.ProductCategoryRepository.save(newCategory);
    }

    // Gets all existing categories from the data base by its id
    public List<ProductCategoryModel> getCategories() {
        // call the service and find all categories
        return this.ProductCategoryRepository.findAll();
    };
    
    // Gets an specified category from the data base by its id
    public ProductCategoryModel getCategoryById(Long category_id) {
        // looks for the category in the repository and return and optional 
        Optional<ProductCategoryModel> categoryOpt = this.ProductCategoryRepository.findById(category_id);
        // gets the object from the optioanl if it exists
        ProductCategoryModel desiredCategory = categoryOpt.get();

        return desiredCategory;
    }
;

}
