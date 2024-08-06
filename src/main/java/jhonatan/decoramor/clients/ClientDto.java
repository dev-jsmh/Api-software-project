
package jhonatan.decoramor.clients;

import java.time.LocalDate;
import jhonatan.decoramor.dtos.NeighborhoodDto;

/**
 * Jhonatan Samuel Martinez Hernandez
 * year 2024
 * Analyts and Software Development
 */
public class ClientDto {
    
    private Long id;
    private String dni;
    private String phone;
    private String names;
    private String lastNames;
    private String address;
    private String image; // it is the URL of the client photo profile
    private LocalDate lastMaintenance;
    private LocalDate nextMaintenance;
    private Boolean hasBeenServed;
    private NeighborhoodDto neighborhood;
    
    // empty constructor 
    public ClientDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
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

    public void setLastMaintenance(LocalDate lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public LocalDate getNextMaintenance() {
        return nextMaintenance;
    }

    public void setNextMaintenance(LocalDate NextMaintenance) {
        this.nextMaintenance = NextMaintenance;
    }

    public Boolean getHasBeenServed() {
        return hasBeenServed;
    }

    public void setHasBeenServed(Boolean hasBeenServed) {
        this.hasBeenServed = hasBeenServed;
    }

    public NeighborhoodDto getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NeighborhoodDto neighborhood) {
        this.neighborhood = neighborhood;
    }
    
    

}
