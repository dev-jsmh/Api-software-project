package jhonatan.decoramor.neighborhood;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import jhonatan.decoramor.clients.ClientModel;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "neighborhood")
public class NeighborhoodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // create an empty constructor method --------------
    public NeighborhoodModel() {
    };
    
    // relation one client to many barrios --------------
    @OneToMany(mappedBy = "neighborhood")
    private Set<ClientModel> clientList = new HashSet<>();

    // create the constructor method --------------------
    public NeighborhoodModel(String name) {
        this.name = name;
    }
    
// getters an setters for neighborhood ----------------------------
    public Set<ClientModel> getClientList() {
        return clientList;
    }

    
    public void setClientList(Set<ClientModel> clientList) {    
        this.clientList = clientList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
