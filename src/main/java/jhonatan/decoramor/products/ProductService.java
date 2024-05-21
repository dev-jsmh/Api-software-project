package jhonatan.decoramor.products;

import java.util.List;
import java.util.Optional;
import jhonatan.decoramor.productCategory.IProductCategoryRepository;
import jhonatan.decoramor.productCategory.ProductCategoryModel;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    // create field for the repositories
    private final IProductRepository productRepository;
    private final IProductCategoryRepository productCategoryRepository;

    // create constructor and inject dependencies
    public ProductService(
            IProductRepository productRepository, 
            IProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    // -------------------------Service Methods--------------------------------
    // Create a new product 
    public ProductModel createProduct(ProductModel newProduct) {
        try {
            return this.productRepository.save(newProduct);

        } // if something bad happends it catch the error 
        catch (Exception ex) {
            throw new RuntimeException("Error al intentar crear nuevo producto. " + ex.getMessage());
        }

    }

    // Gets all existing products from the data base by its id
    public List<ProductModel> getProducts() {
        try {
            return this.productRepository.findAll();

        } // if something bad happends it catch the error 
        catch (Exception ex) {
            throw new RuntimeException("Error al consultar la lista de productos. " + ex.getMessage());
        }
    }

    // Gets an specified product from the data base by its id
    public ProductModel getProductById(Long productCode) {

        try {
            // looks for the category in the repository and return and optional
            Optional<ProductModel> productOpt = this.productRepository.findById(productCode);
            // gets the object from the optioanl
            ProductModel desiredProduct = productOpt.get();
            // return the client 
            return desiredProduct;

        } // if something bad happends it catch the error 
        catch (Exception ex) {
            throw new RuntimeException("Error al consultar el producto" + ex.getMessage());
        }
    }

    // ====================== Update Product By Id ===========================
    public ProductModel updateProduct(Long product_code, ProductModel modProduct) {
        // get the desired product from data base
        Optional<ProductModel> product = this.productRepository.findById(product_code);

        // verify if product exists in the data base 
        if (product.isEmpty()) {
            System.out.println("Product with id: " + product_code + " DOES NOT EXISTE.");

        }
        // get the product object from the optional 
        ProductModel dessiredProduct = product.get();
        // set each corresponding property values from the modify Product to the dessired product
        dessiredProduct.setName(modProduct.getName()); // Name
        dessiredProduct.setModel(modProduct.getModel()); // Model
        dessiredProduct.setDescription(modProduct.getDescription()); // Sescription
        dessiredProduct.setStock(modProduct.getStock()); // Stock 
        dessiredProduct.setImageUrl(modProduct.getImageUrl()); // Image URL
        // save the product modify data 
        return this.productRepository.save(dessiredProduct);

    }

    // ====================== Delete Product By Id ===========================
    
    public ProductModel deleteProduct(Long product_code){
        // get the desired product from data base
        Optional<ProductModel> product = this.productRepository.findById(product_code);

        // verify if product exists in the data base 
        if (product.isEmpty()) {
            System.out.println("Product with id: " + product_code + " ALREADY DOES NOT EXISTE .");

        }
        
        // If defined condition above is false then execute this operation below
        this.productRepository.deleteById(product_code);
        // return the selected product before deleting it from the data base
        return product.get();
    }
    
    // ================== Assing Category To Product By Id ===================
   public String assingCategory(Long product_code, Long category_id){
       
       Optional<ProductModel> OptProduct = this.productRepository.findById(product_code);
       Optional<ProductCategoryModel> OptCategory = this.productCategoryRepository.findById(category_id);
       
       
       
       
       return "assining category " + category_id + " to product " + product_code;
   }
}
