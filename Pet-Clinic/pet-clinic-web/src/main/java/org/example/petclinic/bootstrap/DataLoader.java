package org.example.petclinic.bootstrap;

import org.example.petclinic.model.Owner;
import org.example.petclinic.model.PetType;
import org.example.petclinic.model.Vet;
import org.example.petclinic.services.OwnerService;
import org.example.petclinic.services.PetTypeService;
import org.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Amira");
        owner1.setLastName("Fathy");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Amira2");
        owner2.setLastName("Fathy2");

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");



        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessi");
        vet2.setLastName("Porter");

        vetService.save(vet2);


        System.out.println("Loaded Vets.....");

    }
}
