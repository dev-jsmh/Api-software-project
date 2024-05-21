/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
package jhonatan.decoramor.provider;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel
 */
@Service
public class ProviderService {

    private final IProviderRepository providerRepository;

    /*
    inject the interface IProviderRepository that represents 
    the repository of providers in the contructor of the class as a dependencie
     */
    public ProviderService(IProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    // returns a list of all providers from the data base 
    public List<ProviderModel> getAllproviders() {
        try {
            return providerRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Fallo al buscar los clientes: " + e.getMessage());
        }

    }

    // ========== get an specified provider ===========
    public ProviderModel getById(Long id_provider) {
        // try to find the provider from data base
        try {
            // first, get an optional of the object
            Optional<ProviderModel> OptProvider = this.providerRepository.findById(id_provider);
            // validates if providers is empty or not 
            if (!OptProvider.isEmpty()) {
                // return the object gotten from the optional if true
                return OptProvider.get();
            } else {
                // else if was not posible to find the provider with the specified id print error message
                throw new RuntimeException("There is no provider with " + id_provider + "id number.");

            }
            // in case that happends other kind of exception then print error and the log message
        } catch (Exception ex) {
            throw new RuntimeException("Not possible to find the provider. Response is empty: " + ex.getMessage());
        }

    }

    // ========== create a new provider ===============
    public ProviderModel create(ProviderModel newProvider) {
        try {
            // request for the object that contains the information of the new provider
            // save the object to data base
            return this.providerRepository.save(newProvider);
            // if there happends any kind of error, Prints the log in the console
        } catch (Exception ex) {
            throw new RuntimeException("Not possible to create the new provider. Cause: " + ex.getMessage());
        }
    }

    // ========== update an specified provider =========
    public ProviderModel updateProvider(Long id_provider, ProviderModel modProvider) {
        try {
            // first, get an optional of the object
            Optional<ProviderModel> OptProvider = this.providerRepository.findById(id_provider);
            // validates if providers is empty or not 
            if (!OptProvider.isEmpty()) {

                // store the object in a variable
                ProviderModel oldProvider = OptProvider.get();
                // set the new values to the old provider 
                oldProvider.setNit(modProvider.getNit());
                oldProvider.setName(modProvider.getName());
                oldProvider.setPhone(modProvider.getPhone());
                oldProvider.setAddress(modProvider.getAddress());
                // save the new data  and return the result
                return this.providerRepository.save(oldProvider);

            } else {
                // else if was not posible to find the provider with the specified id print error message
                throw new RuntimeException("There is no provider with " + id_provider + "id number.");

            }
        } catch (Exception ex) {
            // else if was not posible to update provider's data, print error message
            throw new RuntimeException("There was not possible to update provider data with id " + id_provider + " because: " + ex.getMessage());

        }
    }

    // ========== delete an specified provider ==========
    public void delete(Long id_provider) {
        try {
            // try to delete provider
            this.providerRepository.deleteById(id_provider);
            // if happends any kind of error print log message in the console
        } catch (Exception ex) {
            throw new RuntimeException("Error while trying to delete provider N° " + id_provider + ". Because: " + ex.getMessage());
        }
    }
}
/*
Developed by Jhonatan Samuel Martinez Hernandez year 2024
Software Analyst and Developer
 */
