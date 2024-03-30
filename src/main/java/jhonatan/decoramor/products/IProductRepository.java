/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.products;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author samuel
 */
public interface IProductRepository extends JpaRepository<ProductModel, Long > {
    
}
