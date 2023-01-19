package com.janek.letsner.domain.student;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class IndividualStudent extends Student {
}
