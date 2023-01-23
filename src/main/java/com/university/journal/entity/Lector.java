package com.university.journal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Lector extends Person {

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @ManyToMany(mappedBy = "lectors")
    private List<Department> departments;
}
