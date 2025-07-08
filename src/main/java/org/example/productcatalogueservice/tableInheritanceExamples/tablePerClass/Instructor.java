package org.example.productcatalogueservice.tableInheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_instructor")
public class Instructor extends User{
    private String companyName;
}
