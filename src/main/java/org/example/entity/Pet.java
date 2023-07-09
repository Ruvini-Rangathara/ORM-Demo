package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="pet")
public class Pet {
    @Id
    @Column(name="pet_id")
    private String id;
    private String color;
    private int age;

    @ManyToOne
            // no needed
    @JoinColumn (
            name = "owner_id",
            nullable = false,
            referencedColumnName = "o_id"
    )
    Owner owner = new Owner();
}
