package org.acme.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@AllArgsConstructor//substitui os métodos contrutores
@NoArgsConstructor//constroi construtores sem atributos
public class CustomerDTO {
    @Column(name = "Name")
    private String name;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "E_mail",unique = true)
    private String e_mail;
}
