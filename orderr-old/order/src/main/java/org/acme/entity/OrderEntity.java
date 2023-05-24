package org.acme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderProducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name= "ID Order")
    private Long orderId;
    @Column(name = "Name")
    @NotBlank(message ="Include one name, please!")
    private String customerName;
    @GeneratedValue
    @Column(name= "ID Customer")
    private Long customerid;
    @GeneratedValue
    @Column(name= "ID Product")
    private Long productId;

}
