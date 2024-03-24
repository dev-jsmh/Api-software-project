package jhonatan.decoramor.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jhonatan.decoramor.clients.ClientModel;

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
    private String date;

    private String description;
    private double estimate_value;

// I defined here the relation between many services to one client
    @JsonIgnoreProperties("purchased_services")
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientModel client;

    // constructor for the service model
    public ServiceModel() {

    }

    public ServiceModel(String date, String description, double estimate_value) {
        this.date = date;
        this.description = description;
        this.estimate_value = estimate_value;
    }

// Entity Getters and Setters
    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

}
