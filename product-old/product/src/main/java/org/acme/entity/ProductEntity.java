package org.acme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "tb_product")
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Data
public class ProductEntity {
    @GeneratedValue
    @Column(name= "ID")
    private Long id;
    @Column(name = "Name",unique = true)
    @NotBlank(message ="Include one name, please!")
    private String name;
    @Column(name = "Description")
    @NotBlank(message ="Include a description, please!")
    private String description;
    @Column(name = "Area Suported")
    @NotBlank(message ="Include a area, please!")
    private String area;
    //@NotBlank(message ="Include a culture type, please!")
    //Culture culture;
    @Column(name = "Price")
    private BigDecimal price;
}
