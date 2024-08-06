/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.orderDetails;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class OrderDetailService {

    private final IOrderDetailRepository orderDetailRepository;

    public OrderDetailService(IOrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    // ======================== save ========================
    public OrderDetailModel saveOrderDetail(OrderDetailModel newOrderDetail) {
        try {
            return this.orderDetailRepository.save(newOrderDetail);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    // ======================== Get All Order of products ========================
    public List<OrderDetailModel> getAll() {

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
