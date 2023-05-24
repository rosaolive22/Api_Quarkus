package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.acme.enun.Culture;
import org.acme.entity.ProductEntity;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class ProductDTO{
	 String name;
	 String description;
	 String area;
	 Culture culture;
	 BigDecimal price;

}



