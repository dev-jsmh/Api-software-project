/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.product_order;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import jhonatan.decoramor.orderDetails.IOrderDetailRepository;
import jhonatan.decoramor.orderDetails.OrderDetailModel;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class ProductOrderService {

    // create fields for the neccesary repositories
    private final IProductOrderRepository productOrderRepository;
    private final IOrderDetailRepository OrderDetailRepository;

    // inject repositories as dependencies inside the constructor
    public ProductOrderService(
            IProductOrderRepository productOrderRepository,
            IOrderDetailRepository OrderDetailRepository) {
        this.productOrderRepository = productOrderRepository;
        this.OrderDetailRepository = OrderDetailRepository;
    }

    // ======================== Get All Order of products ========================
    public List<ProductOrderModel> getAll() {

        try {
            return this.productOrderRepository.findAll();

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    // ======================== save ========================
    public ProductOrderModel saveOrder(ProductOrderModel newOrder) {

        try {
            // save the new order in the data base
            return this.productOrderRepository.save(newOrder);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    // ======================== new implementation of method save ========================
    public ProductOrderModel saveOrderO(ProductOrderModel newOrder) {

        try {
            // ======= create a new instance of productOrder ============
            ProductOrderModel order = new ProductOrderModel();

            //  set date to the new order 
            order.setDate(LocalDate.now());
            // set prodivder id 
            //
            // set total items 
            order.setTotal_items(newOrder.getTotal_items());

            // set Total value
            order.setTotal_value(newOrder.getTotal_value());

            // save the new order in the data base
            // store the operation result in a variable
            ProductOrderModel createdOrder = this.productOrderRepository.save(order);

            // ====================== setting list ======================
            // get the detail list from the json receive from the post request
            Set<OrderDetailModel> ListOfDetails = newOrder.getDetails();

            // get the number of purchase items
            int detailsCount = ListOfDetails.size();
            // create the variable to store the new array 
            OrderDetailModel detailsArray[] = new OrderDetailModel[detailsCount];
            // convert the set to an array 
            detailsArray = ListOfDetails.toArray(detailsArray);
            //
            System.out.print("Number of the order: " + createdOrder.getId_order());

            // ================== loop over all elementes in the List of detail ==================
            for (int d = 0; d < detailsCount; d++) {

                // create new order detail
                OrderDetailModel order_detail = new OrderDetailModel();
                // set the value of each attribute to the new instance of order_detail
                order_detail.setProduct_name(detailsArray[d].getProduct_name()); // product name
                order_detail.setProduct_model(detailsArray[d].getProduct_model());// product model
                order_detail.setQuantity(detailsArray[d].getQuantity());// product quantity
                order_detail.setUnit_value(detailsArray[d].getUnit_value()); // product price per unit
                order_detail.setTotal_value(detailsArray[d].getTotal_value());  // total value
                // assing the detail to the previouslly created order
                order_detail.setOrder(createdOrder);
                //  store the operation result in a variable
                OrderDetailModel createdOrderDetail = this.OrderDetailRepository.save(order_detail);

                System.out.print("number of the order detial : " + createdOrderDetail.getDetail_id());

            }
            // =============== return the order ===============
            return order;

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
