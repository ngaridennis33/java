package com.denraxcoding.springDataJpaAlibou.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity {

    String name;

    @ManyToOne
    @JoinColumn( name = "section_id")
    private Section section;

    @OneToOne
    @JoinColumn( name = "resource_id")
    private Resource resource;
}
