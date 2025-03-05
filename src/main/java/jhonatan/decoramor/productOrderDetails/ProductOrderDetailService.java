/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.productOrderDetails;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class ProductOrderDetailService {

    private final IProductOrderDetailRepository orderDetailRepository;

    public ProductOrderDetailService(IProductOrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    // ======================== save ========================
    public ProductOrderDetailModel saveOrderDetail(ProductOrderDetailModel newOrderDetail) {
        try {
            return this.orderDetailRepository.save(newOrderDetail);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    // ======================== Get All Order of products ========================
    public List<ProductOrderDetailModel> getAll() {

        try {
            return this.orderDetailRepository.findAll();

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
