/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.orderDetails;

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
public class OrderDetailModel {

    private Long detail_id;
    // private Long product_order_id;
    private String product_name;
    private String product_model;
    private int quantity;
    private double value;

    public OrderDetailModel() {
    }

    public OrderDetailModel(
            String product_name,
            String product_model,
            int quantity,
            double value) {
        this.product_name = product_name;
        this.product_model = product_model;
        this.quantity = quantity;
        this.value = value;
    }

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
