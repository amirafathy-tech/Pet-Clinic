package org.example.petclinic.services.map;

import org.example.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "john";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }
    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteByID() {
        ownerMapService.deleteByID(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner john = ownerMapService.findByLastName(lastName);

        assertNotNull(john);

        assertEquals(ownerId, john.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner john = ownerMapService.findByLastName("foo");

        assertNull(john);
    }

}