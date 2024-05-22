/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.product_order;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import jhonatan.decoramor.orderDetails.OrderDetailModel;
/*

This class represents a bill for an order when purchasing products to a provider

*/
public class ProductOrderModel {

    // needed information for making an order of products to a provider
    private Long id_order;
    private Long id_provider;
    private LocalTime date;
    private int total_items;
    private double total_value;
    // this hashset representes a list of all details of a order
    private Set<OrderDetailModel> details = new HashSet<>();
// ================ empty constructor ================
    public ProductOrderModel(){}
    
    // ================ getters and setters ================
    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public Long getId_provider() {
        return id_provider;
    }

    public void setId_provider(Long id_provider) {
        this.id_provider = id_provider;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    public int getTotal_items() {
        return total_items;
    }

    public void setTotal_items(int total_items) {
        this.total_items = total_items;
    }

    public double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(double total_value) {
        this.total_value = total_value;
    }

    public Set<OrderDetailModel> getDetails() {
        return details;
    }

    public void setDetails(Set<OrderDetailModel> details) {
        this.details = details;
    }

    
    
    
    
}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
