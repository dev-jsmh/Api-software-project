package jhonatan.decoramor.products;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    // create field for the service
    private final IProductRepository productRepository;

    // create constructor and inject dependencies
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
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

}
