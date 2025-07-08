package org.example.productcatalogueservice.tableInheritanceExamples.joinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jc_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class Ta extends User {
    private Long numberOfRatings;
}
