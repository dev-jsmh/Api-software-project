
package jhonatan.decoramor.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

/**

 * @author Jhonatan samuel Martinez Hernandez
 */ 

/*
This interface represent the repository of services 
that a user can ask for in the business
*/
public interface IAppointmentRepository extends JpaRepository<AppointmentModel, Long> {

   
}
