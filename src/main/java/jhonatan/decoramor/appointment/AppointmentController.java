package jhonatan.decoramor.appointment;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@RequestMapping(value = "/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

// -----------------------------------------------------------------------------
// get a list of all exiting Appointments 
    @GetMapping
    public List<AppointmentModel> getAllAppointments() {
        try {
            return appointmentService.getAllAppointments();
        } catch (Exception e) {
            throw new RuntimeException("Error al intentar obtener los servicios agendados. " + e.getMessage());
        }
    }

    // ---------------------- create a new appointment -------------------------
    @PostMapping
    public AppointmentModel create( @RequestBody AppointmentModel newAppointment) {

        try {
           return this.appointmentService.createAppointment(newAppointment);

        } catch (Exception ex) {
            throw new RuntimeException("Error al intentar agendar el nuevo servicio. " + ex.getMessage());
        }
    }

    
    // ---------------------------------------------------------------------
// create or save a new service for a client
    @PostMapping("/{client_id}/schedule-service")
    public AppointmentModel scheduleServiceToClient(
            @RequestBody AppointmentModel newservice,
            @PathVariable Long client_id) {
        try {
            return appointmentService.scheduleServiceToClient(newservice, client_id);

        } catch (Exception e) {
            throw new RuntimeException("Error al agendar servicio a el cliente. " + e.getMessage());
        }
    }
}
