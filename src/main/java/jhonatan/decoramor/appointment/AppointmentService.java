package jhonatan.decoramor.appointment;


import java.util.List;
import java.util.Optional;
import jhonatan.decoramor.clients.ClientModel;
import jhonatan.decoramor.clients.IClientRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonatan samuel Martinez Hernandez
 */

/*
This service class has all the logic refered to services, allowing us
to create, find, select, delete, edit data of a group of services or a specific one
 */
@Service
public class AppointmentService {

    // Create a field for the service repository interface
    private final IAppointmentRepository appointmentRepository;

    // Create a field for the client repository interface
    private final IClientRepository clientRepository;

    // Make here a dependency injection of the corresponding repositories
    public AppointmentService(IAppointmentRepository serviceRepository, IClientRepository clientRepository) {
        this.appointmentRepository = serviceRepository;
        this.clientRepository = clientRepository;

    }

// ---------------------------------------------------------------------
// Gets a list of services with its respective information
    public List<AppointmentModel> getAllAppointments() {
        try {
            return this.appointmentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Fallo al devolver la lista de servicios. " + e.getMessage());
        }

    }

    // -------------------------- create a new appointment  --------------------
    public AppointmentModel createAppointment( AppointmentModel newAppointment ){

        return this.appointmentRepository.save( newAppointment );
       
    }

     //==================== create a new appointment for a client ===============
    public AppointmentModel scheduleServiceToClient(AppointmentModel appointmentRequest, Long client_id) {
        try {
            // get optional of client 
            Optional<ClientModel> Opclient = clientRepository.findById(client_id);
            // get client entity from the optional 
            ClientModel clientTemp = Opclient.get();

            // create a new service
            AppointmentModel newAppointment = new AppointmentModel();
            
            
            // set the info
            
            newAppointment.setDate(appointmentRequest.getDate());
            newAppointment.setHour( appointmentRequest.getHour() );
            newAppointment.setDescription( appointmentRequest.getDescription() );
            newAppointment.setEstimatedValue(appointmentRequest.getEstimatedValue() );
            
           // -------------------------- setting the client contact data ------------------------
       
            newAppointment.setClient(clientTemp );

            // verify if service info came to the service layer of client
            System.out.println("This is the client id: " + clientTemp.getId() + " and this the info for the new schedule service: ");
            System.out.println(newAppointment.getDate());
            System.out.println(newAppointment.getDescription());
            //convert the price of the service ( Double ) to String
            System.out.println(String.valueOf(newAppointment.getEstimatedValue()));
            // save the new service to the data base
            return this.appointmentRepository.save(newAppointment);
        } catch (Exception e) {
            throw new RuntimeException("Error al agendar el servicio al cliente solicitado. " + e.getMessage());
        }
    }
}
