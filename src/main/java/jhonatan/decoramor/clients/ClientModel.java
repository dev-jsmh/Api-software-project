/*

Developed by Jhonatan Samuel Martinez Hernandez

 */
package jhonatan.decoramor.clients;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import jhonatan.decoramor.neighborhood.NeighborhoodModel;
import jhonatan.decoramor.service.ServiceModel;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String phone;
    private String first_name;
    private String secund_name;
    private String first_lastname;
    private String secund_lastname;
    private String address;
    // and relation with the neighborhood table 
    private String image; // it is the URL of the client photo profile
    private String last_meet;

    /* I use here the @JsonIgnoreProperties annotation as it allows 
    me to prevent the infinite loop that i got here becuase one-to-many 
    relationship is a bidirectional relation. it means we can obtenin 
    informacion about the related entities by querying 
    each one separately
    */
    //@JsonIgnoreProperties("clientList")   
    @ManyToOne()
    @JoinColumn(name = "neighborhood_id", referencedColumnName = "id")
    private NeighborhoodModel neighborhood;

    // I have to ignore the properti client of the service object 
    // so i don't get the client data for each service it has bought
    // and don't get an infite loop error when requesting clients
    @JsonIgnoreProperties("client")
// relation one client to many services
    @OneToMany(mappedBy = "client")
    private Set<ServiceModel> purchased_services = new HashSet<>();
    
    // getters and setters for the class
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecund_name() {
        return secund_name;
    }

    public void setSecund_name(String secund_name) {
        this.secund_name = secund_name;
    }

    public String getFirst_lastname() {
        return first_lastname;
    }

    public void setFirst_lastname(String first_lastname) {
        this.first_lastname = first_lastname;
    }

    public String getSecund_lastname() {
        return secund_lastname;
    }

    public void setSecund_lastname(String secund_lastname) {
        this.secund_lastname = secund_lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLast_meet() {
        return last_meet;
    }

    public void setLast_meet(String last_meet) {
        this.last_meet = last_meet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Adds a new service to the purchased services list of the client
    public void scheduleService(ServiceModel newService) {

        this.purchased_services.add(newService);
    }

    public Set<ServiceModel> getPurchased_services() {
        return purchased_services;
    }

    public void setPurchased_services(Set<ServiceModel> purchased_services) {
        this.purchased_services = purchased_services;
    }
    
    public NeighborhoodModel getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NeighborhoodModel neighborhood) {
        this.neighborhood = neighborhood;
    }

}
