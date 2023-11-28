package org.example.petclinic.services;

import org.example.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save (Vet vet);
    Set<Vet> findAll();
}
