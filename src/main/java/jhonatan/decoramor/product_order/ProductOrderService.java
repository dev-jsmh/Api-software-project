/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.product_order;

import java.util.List;
import java.util.Set;
import jhonatan.decoramor.productOrderDetails.ProductOrderDetailModel;
import jhonatan.decoramor.provider.IProviderRepository;
import jhonatan.decoramor.provider.ProviderModel;
import java.util.Optional;
import org.springframework.stereotype.Service;
import jhonatan.decoramor.productOrderDetails.IProductOrderDetailRepository;
import jhonatan.decoramor.products.IProductRepository;
import jhonatan.decoramor.products.ProductModel;

/**
 *
 * @author samuel
 */
@Service
public class ProductOrderService {

    // create fields for the neccesary repositories
    private final IProductOrderRepository productOrderRepository;
    private final IProductOrderDetailRepository OrderDetailRepository;
    private final IProviderRepository providerRepository;
    private final IProductRepository productRepository;

    // inject repositories as dependencies inside the constructor
    public ProductOrderService(
            IProductOrderRepository productOrderRepository,
            IProductOrderDetailRepository OrderDetailRepository,
            IProviderRepository providerRepository,
            IProductRepository productRepository) {
        this.productOrderRepository = productOrderRepository;
        this.OrderDetailRepository = OrderDetailRepository;
        this.providerRepository = providerRepository;
        this.productRepository = productRepository;
    }

    // ======================== Get All Order of products ========================
    public List<ProductOrderModel> getAll() {

        try {
            return this.productOrderRepository.findAll();

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
            order.setDate(newOrder.getDate());
            // -------- set provider id --------

            Optional<ProviderModel> OptProvider = providerRepository.findById(newOrder.getProvider().getProviderId());
            //  validates if the provider exist in the data base
            if (OptProvider.isPresent()) {
                // get the entity from the optional 
                ProviderModel providerTemp = OptProvider.get();
                // set the entity to the new order
                order.setProvider(providerTemp);
            } else {
                throw new RuntimeException("El proveedor seleccionado no existe. compruebe el id del proveedor o que esté registrado en la base de datos. ");
            }

            // set total items 
            order.setTotalItems(newOrder.getTotalItems());

            // set Total value
            order.setTotalValue(newOrder.getTotalValue());

            // save the new order in the data base
            // store the operation result in a variable
            ProductOrderModel createdOrder = this.productOrderRepository.save(order);

            // ====================== setting list ======================
            // get the detail list from the json receive from the post request
            Set<ProductOrderDetailModel> ListOfDetails = newOrder.getDetails();

            // get the number of purchase items
            int detailsCount = ListOfDetails.size();
            // create the variable to store the new array 
            ProductOrderDetailModel detailsArray[] = new ProductOrderDetailModel[detailsCount];
            // convert the set to an array 
            detailsArray = ListOfDetails.toArray(detailsArray);
            //
            System.out.print("Number of the order: " + createdOrder.getOrderId());

            // ================== loop over all elements in the List of detail ==================
            for (int d = 0; d < detailsCount; d++) {

                // extract the id of the current product
                Long productId = detailsArray[d].getProduct().getProductId();
                // extract the quantity of products from details 
                int productQuantity = detailsArray[d].getQuantity();
                // extract  the new price for the product
                double unitPrice = detailsArray[d].getUnitValue();
                // extract the product entity from the optional
                ProductModel productEntity = productRepository.findById(productId).get();

                // add stock to the product
                int newStock = productEntity.getStock() + productQuantity;
                productEntity.setStock(newStock);
                // update price of the product
                productEntity.setPrice(unitPrice);

                // save the product updates make to available stock and unit value
                productRepository.save(productEntity);

                // create new order detail
                ProductOrderDetailModel order_detail = new ProductOrderDetailModel();
                // set the value of each attribute to the new instance of order_detail
                order_detail.setQuantity(detailsArray[d].getQuantity());// product quantity
                order_detail.setUnitValue(detailsArray[d].getUnitValue()); // product price per unit
                order_detail.setTotalValue(detailsArray[d].getTotalValue());  // total value
                // set product 
                order_detail.setProduct(productEntity);
                // assing the detail to the previouslly created order
                order_detail.setOrder(createdOrder);
                //  store the operation result in a variable
                ProductOrderDetailModel createdOrderDetail = this.OrderDetailRepository.save(order_detail);

                System.out.print("number of the order detail : " + createdOrderDetail.getDetailId());

            }

            // =============== return the order ===============
            return createdOrder;

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
