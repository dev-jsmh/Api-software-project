/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.productCategory;

import jhonatan.decoramor.productCategory.ProductCategoryModel;
import jhonatan.decoramor.productCategory.IProductCategoryRepository;
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

    // ================== create new  ==================
    // Create a new category 
    public ProductCategoryModel create(ProductCategoryModel newCategory) {
        try {
            // call the service and save the new category
            return this.ProductCategoryRepository.save(newCategory);
            // ======= in case any other kind of error happends log it to the console
        } catch (Exception ex) {
            throw new RuntimeException("Not possible to create the new category " + newCategory.getName() + " Cause: " + ex.getMessage());

        }
    }

    // ================== Get All ==================
    // Gets all existing categories from the data base by its id
    public List<ProductCategoryModel> getAll() {

        try {
            // call the service and find all categories
            return this.ProductCategoryRepository.findAll();
            // ======= in case any other kind of error happends log it to the console
        } catch (Exception ex) {
            throw new RuntimeException("Error while trying to get a category list. Cause: " + ex.getMessage());

        }
    }

    // ================== Get by Id ==================
    // Gets an specified category from the data base by its id
    public ProductCategoryModel getById(Long category_id) {
        try {
            // looks for the category in the repository and return and optional 
            Optional<ProductCategoryModel> categoryOpt = this.ProductCategoryRepository.findById(category_id);
            if (categoryOpt.isPresent()) {
                // gets the object from the optional if it exists
                ProductCategoryModel desiredCategory = categoryOpt.get();
                // return the wanted category
                return desiredCategory;
                // otherwise category is not found, print an error in the console
            } else {
                throw new RuntimeException("Not possible to find the category. ");
            }
// ======= in case any other kind of error happends log it to the console
        } catch (RuntimeException ex) {
            throw new RuntimeException("Error while trying to get the category. Cause: " + ex.getMessage());
        }

    }

    // ================== Delete ==================
    public void delete(Long category_id) {
        try {
            // try to delete category from data base
            this.ProductCategoryRepository.deleteById(category_id);
            // ======= in case any other kind of error happends log it to the console
        } catch (Exception ex) {
            throw new RuntimeException("Not possible to delete category with id " + category_id + " Because: " + ex.getMessage());
        }
    }

    // ================== Update ==================
    // update an specified category from the data base by its id
    public ProductCategoryModel update(Long category_id, ProductCategoryModel modcategory) {
        try {
            // looks for the category in the repository and return and optional 
            Optional<ProductCategoryModel> categoryOpt = this.ProductCategoryRepository.findById(category_id);
            if (categoryOpt.isPresent()) {
                // gets the object from the optional if it exists
                ProductCategoryModel oldCategory = categoryOpt.get();

                // set the new values from the modify category to the old one
                oldCategory.setName(modcategory.getName());

                // return the wanted category
                return this.ProductCategoryRepository.save(oldCategory) ;
                // otherwise category is not found, print an error in the console
            } else {
                throw new RuntimeException("Not possible to find the category: " + category_id);
            }
    // ======= in case any other kind of error happends log it to the console
        } catch (RuntimeException ex) {
            throw new RuntimeException("Error while trying to get the category. Cause: " + ex.getMessage());
        }

    }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
