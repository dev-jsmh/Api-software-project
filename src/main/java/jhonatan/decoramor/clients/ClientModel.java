/*

Developed by Jhonatan Samuel Martinez Hernandez

 */
package jhonatan.decoramor.clients;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String names;
    private String lastNames;
    private String address;
    // and relation with the neighborhood table 
    private String image; // it is the URL of the client photo profile
    private LocalDate lastMaintenance;
    private LocalDate nextMaintenance;
    private Boolean hasBeenServed;

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
    
    
   /* @JsonIgnoreProperties("client")
// relation one client to many services
    @OneToMany(mappedBy = "client")
    private Set<ServiceModel> purchased_services = new HashSet<>();
    */
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

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String LastNames) {
        this.lastNames = LastNames;
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

    public LocalDate getLastMaintenance() {
        return lastMaintenance;
    }

    public void setlastMaintenance(LocalDate lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }
    public LocalDate getNextMaintenance() {
        return nextMaintenance;
    }

    public void setNextMaintenance(LocalDate NextMaintenance) {
        this.nextMaintenance = NextMaintenance;
    }

    public Boolean getHasBeenServed(){
        return hasBeenServed;
    }

    public void setHasBeenServed( Boolean hasBeenServed){
this.hasBeenServed = hasBeenServed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public NeighborhoodModel getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NeighborhoodModel neighborhood) {
        this.neighborhood = neighborhood;
    }

}
