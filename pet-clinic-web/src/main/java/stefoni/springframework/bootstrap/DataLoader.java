package stefoni.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import stefoni.springframework.model.Owner;
import stefoni.springframework.model.PetType;
import stefoni.springframework.model.Vet;
import stefoni.springframework.services.OwnerService;
import stefoni.springframework.services.PetTypeService;
import stefoni.springframework.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jordan");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shrek");
        owner2.setLastName("First");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Johnny");
        vet1.setLastName("Bravo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Frodo");
        vet2.setLastName("Baggins");

        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }
}
