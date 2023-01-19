package com.janek.letsner.domain.student;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class AcademyStudent extends Student {
}
