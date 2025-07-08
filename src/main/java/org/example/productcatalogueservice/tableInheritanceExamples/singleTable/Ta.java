package org.example.productcatalogueservice.tableInheritanceExamples.singleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_ta")
@DiscriminatorValue(value = "11")
public class Ta extends User{
    private Long numberOfRatings;
}
