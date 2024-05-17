package com.denraxcoding.springDataJpaAlibou.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Section extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int sectionOrder;

    @ManyToOne
    @JoinColumn( name = "course_id" )
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

}
