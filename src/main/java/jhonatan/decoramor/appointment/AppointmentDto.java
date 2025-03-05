package jhonatan.decoramor.appointment;

import jhonatan.decoramor.neighborhood.NeighborhoodDto;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * Jhonatan Samuel Martinez Hernandez
 */
public class AppointmentDto {

    // details for schedule service
    private LocalDate date;
    private LocalTime time;
    private String category;
    private Long id;
    private String description;
    private double estimatedValue;
    // client details -----------------------
    private String ClientFullName;
    private String phone;
    private NeighborhoodDto neighborhood;
    private String address;
    // indicates if the client has been served or not
    private String state;

    public AppointmentDto() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public String getClientFullName() {
        return ClientFullName;
    }

    public void setClientFullName(String ClientFullName) {
        this.ClientFullName = ClientFullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NeighborhoodDto getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NeighborhoodDto neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
