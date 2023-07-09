package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name ="owner")
public class Owner {
    @Id
    @Column(name="o_id")
    private String id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "owner")
    List<Pet> petList = new ArrayList<>();
}
