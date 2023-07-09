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
@Entity(name="module")
public class Module {
    @Id
    @Column(name="module_id")
    private String id;
    private String subject;

    @ManyToMany
    @JoinTable(
            name = "lecturer_details",
            joinColumns = @JoinColumn(name = "module_code", nullable = false, referencedColumnName = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id", nullable = false, referencedColumnName = "lec_id")
    )
    List<Lecturer> lecturerList = new ArrayList<>();

}
