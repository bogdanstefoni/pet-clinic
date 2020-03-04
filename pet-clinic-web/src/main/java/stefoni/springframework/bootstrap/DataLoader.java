package stefoni.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import stefoni.springframework.model.Owner;
import stefoni.springframework.model.Vet;
import stefoni.springframework.services.OwnerService;
import stefoni.springframework.services.VetService;
import stefoni.springframework.services.map.OwnerServiceMap;
import stefoni.springframework.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirsName("Michael");
        owner1.setLastName("Jordan");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirsName("Shrek");
        owner2.setLastName("First");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirsName("Johnny");
        vet1.setLastName("Bravo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirsName("Frodo");
        vet2.setLastName("Baggins");

        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }
}
