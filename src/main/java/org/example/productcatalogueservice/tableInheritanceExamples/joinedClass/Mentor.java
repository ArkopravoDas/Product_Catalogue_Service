package org.example.productcatalogueservice.tableInheritanceExamples.joinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jc_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User{
    private Long numberOfHours;
}
