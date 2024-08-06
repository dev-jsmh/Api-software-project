/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.orderDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jhonatan.decoramor.product_order.ProductOrderModel;

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
public class OrderDetailModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long detail_id;
    // private Long product_order_id;
    private String product_name;
    private String product_model;
    private int quantity;
    private double unit_value;
     private double total_value;

     // many to one relations ship
     @JsonIgnoreProperties("details")
     @ManyToOne
     @JoinColumn( name = "id_order")
     private ProductOrderModel order;
     
    // empty constructor 
    public OrderDetailModel() {}
 // filled constructor with parameters
    public OrderDetailModel(
            String product_name,
            String product_model,
            int quantity,
            double unit_value
            ) {
        this.product_name = product_name;
        this.product_model = product_model;
        this.quantity = quantity;
        this.unit_value = unit_value;
    }
//  ============== getters and setters ==============
    public Long getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Long detail_id) {
        this.detail_id = detail_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_model() {
        return product_model;
    }

    public void setProduct_model(String product_model) {
        this.product_model = product_model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_value() {
        return unit_value;
    }

    public void setUnit_value(double unit_value) {
        this.unit_value = unit_value;
    }

    public double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(double total_value) {
        this.total_value = total_value;
    }

   public ProductOrderModel getOrder(){
       return this.order;
   }
   
   public void setOrder(ProductOrderModel order){
       this.order = order; 
   }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
