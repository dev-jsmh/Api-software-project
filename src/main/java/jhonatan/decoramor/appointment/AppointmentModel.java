package jhonatan.decoramor.appointment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import jhonatan.decoramor.clients.ClientModel;

/**
 *
 * @author Jhonatan samuel Martinez Hernandez
 */
@Entity
@Table(name = "appointments")
public class AppointmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private LocalDate date;
    private LocalTime hour;
    @Column(name = "description", length = 65535)
    private String description;
    private double estimatedValue;
    private Boolean isFinished;

    // field for the client
    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientModel client;

    /* I defined here the relation between many services to one client
    @JsonIgnoreProperties("purchased_services")  
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientModel client;
     */
    // constructor for the service model
    public AppointmentModel() {
    }

    public AppointmentModel(
            LocalDate date,
            LocalTime hour,
            String description,
            double estimatedValue
    ) {
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.estimatedValue = estimatedValue;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(double estimatedValue) {
        this.estimatedValue = estimatedValue;
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

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    
    
}
