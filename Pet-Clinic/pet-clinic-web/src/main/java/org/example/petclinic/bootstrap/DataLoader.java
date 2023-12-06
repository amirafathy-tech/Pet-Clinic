package org.example.petclinic.bootstrap;

import org.example.petclinic.model.*;
import org.example.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;

        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {


        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery= new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Amira");
        owner1.setLastName("Fathy");
        owner1.setAddress("5 st");
        owner1.setCity("Alex");
        owner1.setTelephone("1234567");

//        Owner.builder().address("ASFD").id(3).firstName().build();

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDog);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Amira2");
        owner2.setLastName("Fathy2");
        owner2.setAddress("5 st");
        owner2.setCity("Alex");
        owner2.setTelephone("1234567");

        Pet fionasCat=new Pet();
        fionasCat.setPetType(savedCat);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just cat");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners.....");



        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessi");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);


        System.out.println("Loaded Vets.....");

    }
}
