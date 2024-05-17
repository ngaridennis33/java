package com.denraxcoding.springDataJpaAlibou.models.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_order")
public class Order implements Serializable {

    @EmbeddedId
    private OrderId id;

    @Embedded
    private Address address;

    private String orderInfo;

    private String anotherField;
}
