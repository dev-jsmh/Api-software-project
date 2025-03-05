/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.productOrderDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jhonatan.decoramor.product_order.ProductOrderModel;
import jhonatan.decoramor.products.ProductModel;

/**
 *
 * @author samuel
 */

/*
This represents a detail for an order product bill 
the needed information is

product name
model
quantity
value
 */
@Entity
@Table( name = "product_order_detail")
public class ProductOrderDetailModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long detailId;
    private int quantity;
    private double unitValue;
     private double totalValue;
    @ManyToOne()
    @JoinColumn(name="product_id" )
   private ProductModel product;

     // many to one relations ship
     @JsonIgnoreProperties("details")
     @ManyToOne
     @JoinColumn( name = "order_id")
     private ProductOrderModel order;
     
    // empty constructor 
    public ProductOrderDetailModel() {}
    // filled constructor with parameters
    public ProductOrderDetailModel(
            ProductModel product,
            int quantity,
            double unitValue
            ) {
        this.product = product;
        this.quantity = quantity;
        this.unitValue = unitValue;
    }
//  ============== getters and setters ==============

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
   
    
    
   
   public void setOrder(ProductOrderModel order){
       this.order = order; 
   }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
