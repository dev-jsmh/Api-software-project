/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
*/

package jhonatan.decoramor.products;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Api/v1/products")
public class ProductsController {
    
    // create field for services
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    
    // create constructor and inject dependencies
    public ProductsController(
            ProductService productService,
            ProductCategoryService productCategoryService
            ){
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }
    
    // -------------------------- Controller methods ---------------------------
    
    // ------------------------ creates a new product --------------------------
    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel newProduct
    ){
        return this.productService.createProduct(newProduct);
    };
    // ---------------------- Gets all existing product ------------------------
    @GetMapping
    public List<ProductModel> getProducts(){
        return this.productService.getProducts();
    };
    
    // ---------------------- Gets an epecified product ------------------------
    @GetMapping("/{product_code}")
    public ProductModel getProducts(
            @PathVariable("{product_code}") Long product_code){
        return this.productService.getProductById(product_code);
    };
    
    
    
}
