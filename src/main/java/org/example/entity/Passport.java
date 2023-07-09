package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "passport")
public class Passport {

    @Id
    @Column(name="pass_id")
    private String id;
    @Column(name="passport_number")
    private int passNo;
    private Date issueDate;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;
}
