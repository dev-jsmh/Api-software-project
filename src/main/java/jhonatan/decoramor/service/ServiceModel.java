package jhonatan.decoramor.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Jhonatan samuel Martinez Hernandez
 */
@Entity
@Table(name = "service")
public class ServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_id;
    private LocalDate date;
    private LocalTime hour;
    @Column(name = "description", length = 65535)
    private String description;
    private double estimate_value;

    // field for the client
    private Long client_id;
    private String clientFullName;
    private String phone;
    private String neighborhood;
    private String address;


    /* I defined here the relation between many services to one client
    @JsonIgnoreProperties("purchased_services")  
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientModel client;
     */
    // constructor for the service model
    public ServiceModel() {

    }

    public ServiceModel(LocalDate date, String description, double estimate_value) {
        this.date = date;
        this.description = description;
        this.estimate_value = estimate_value;
    }

// Entity Getters and Setters
    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimate_value() {
        return estimate_value;
    }

    public void setEstimate_value(double estimate_value) {
        this.estimate_value = estimate_value;
    }

    // getters and setters for the client contact data
    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    
    
}
