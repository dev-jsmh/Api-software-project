package jhonatan.decoramor.service;

import java.time.LocalDate;
import java.util.List;
import jhonatan.decoramor.clients.IClientRepository;
import jhonatan.decoramor.dtos.AppointmentDto;
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
public class ServiceService {

    // Create a field for the service repository interface
    private final IServiceRepository serviceRepository;

    // Create a field for the client repository interface
    private final IClientRepository clientRepository;

    // Make here a dependency injection of the corresponding repositories
    public ServiceService(IServiceRepository serviceRepository, IClientRepository clientRepository) {
        this.serviceRepository = serviceRepository;
        this.clientRepository = clientRepository;

    }

// ---------------------------------------------------------------------
// Gets a list of services with its respective information
    public List<ServiceModel> getAllServices() {
        try {
            return this.serviceRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Fallo al devolver la lista de servicios. " + e.getMessage());
        }

    }

    public AppointmentDto storeAppointment() {

        AppointmentDto appointment = new AppointmentDto();

        appointment.setDate(LocalDate.MAX);
        appointment.setCategory("mantenimiento");
        appointment.setEstimatedValue(54000);
        appointment.setClientFullName("Jhonatan Samuel Martinez Hernandez");

        return appointment;
    }

}
