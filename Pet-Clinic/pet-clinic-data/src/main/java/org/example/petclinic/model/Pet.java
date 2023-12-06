package org.example.petclinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pet")

public class Pet extends BaseEntity{
//    @Builder
//    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visit) {
//        super(id);
//        this.name = name;
//        this.petType = petType;
//        this.owner = owner;
//        this.birthDate = birthDate;
//        this.visit=visit;
//    }
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visit= new HashSet<>();
}
