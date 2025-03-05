/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.product_order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import jhonatan.decoramor.productOrderDetails.ProductOrderDetailModel;
import jhonatan.decoramor.provider.ProviderModel;
/*
This class represents a bill for an order when purchasing products to a provider
*/
@Entity
@Table( name = "product_order")
public class ProductOrderModel {

    // needed information for making an order of products to a provider
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long orderId;
   // private ProviderModel provider;
    private LocalDate date;
    private int totalItems;
    private double totalValue;
    // this hashset represents a list of all details of a order
    @JsonIgnoreProperties("order")
    @OneToMany( mappedBy = "order")
    private Set<ProductOrderDetailModel> details = new HashSet<>();
    
    // this represents who was the provider we bought the products to
    @ManyToOne()
    @JoinColumn( name="provider_id", referencedColumnName="providerId")
    private ProviderModel provider; 
    
// ================ empty constructor ================
    public ProductOrderModel(){}
    
    // ================ getters and setters ================

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public Set<ProductOrderDetailModel> getDetails() {
        return details;
    }

    public void setDetails(Set<ProductOrderDetailModel> details) {
        this.details = details;
    }

    public ProviderModel getProvider() {
        return provider;
    }

    public void setProvider(ProviderModel provider) {
        this.provider = provider;
    }
    
    
    
}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
