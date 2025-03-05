/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.product_order;

import java.util.List;
import jhonatan.decoramor.productOrderDetails.ProductOrderDetailModel;
import jhonatan.decoramor.productOrderDetails.ProductOrderDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@RequestMapping("/api/v1/product-orders")
public class ProductOrderController {

    private ProductOrderService productOrderService;
    private ProductOrderDetailService orderDetailService;

    public ProductOrderController(
            ProductOrderService productOrderService,
            ProductOrderDetailService orderDetailService) {
        this.productOrderService = productOrderService;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public List<ProductOrderModel> getAllOrders() {
        return (List<ProductOrderModel>) this.productOrderService.getAll();
    }

    @PostMapping
    public ProductOrderModel createNewOrder(@RequestBody ProductOrderModel order) {
        return this.productOrderService.saveOrderO(order);
    }

    @GetMapping("/details")
    public List<ProductOrderDetailModel> getAllOrdersDetails() {
        return this.orderDetailService.getAll();
    }

    @PostMapping("/details")
    public ProductOrderDetailModel createNewOrderDetail(@RequestBody ProductOrderDetailModel orderDetail) {
        return this.orderDetailService.saveOrderDetail(orderDetail);
    }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */