package com.janek.letsner.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@ToString
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseEntity {

    private LocalDate createdDate;

    public BaseEntity(LocalDate createdDate) {
        this.createdDate = createdDate == null ? LocalDate.now() : createdDate;
    }

}
