
package jhonatan.decoramor.provider;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author samuel
 */

@Table(name="provider")
@Entity
public class ProviderModel {
    
    @Id
    private Long id_provider;
    
    private String name;
    
    private String phone;
    
    private String address;
    
    public Long getId_provider(){
    return this.id_provider;
    }
    
    // getters and setters for the class 
    public void setId_provider( Long id_provider){
        this.id_provider = id_provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
