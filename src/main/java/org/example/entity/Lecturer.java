package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="lecturer")
public class Lecturer {
    @Id
    @Column(name="lec_id")
    private String id;
    private String name;

    @ManyToMany(mappedBy = "lecturerList")
    List<Module> moduleList = new ArrayList<>();
}
