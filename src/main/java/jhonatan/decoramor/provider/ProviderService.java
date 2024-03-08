package jhonatan.decoramor.provider;

import java.util.List;
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
        try{
            return providerRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Fallo al buscar los clientes: " + e.getMessage());
        }
        
    }
}
