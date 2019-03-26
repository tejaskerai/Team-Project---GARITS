package com.quickfixfitters.garits.entities;

import javax.persistence.*;
import java.util.List;

// Need to fix this entity



@Entity
@Table(name = "Mechanic")
public class Mechanic {

    @Id
    @Column(name = "MechanicId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mechanicId;

    @Column(name = "EmployeeNo")
    private int employeeNo;

    @OneToMany(mappedBy = "mechanic")
    private List<JobSheet> jobSheets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeNo", insertable = false, updatable = false)
    private Employee employee;

}
