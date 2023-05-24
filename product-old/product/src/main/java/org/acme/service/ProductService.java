package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;
import org.acme.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductDTO> findAllProducts () {
		List<ProductDTO> products = new ArrayList<>();
        productRepository.findAll().stream().forEach(item ->{
			products.add(mapProductEntityToDTO(item));
		});
		return products;
	}
			private ProductDTO mapProductEntityToDTO(ProductEntity productEntity){

				ProductDTO product = new ProductDTO();

				product.setName(productEntity.getName());
				product.setDescription(productEntity.getDescription());
				product.setArea(productEntity.getArea());
				product.setPrice(productEntity.getPrice());
				return product;
			}



	//Relacionamento com o micro serviço Order		
	public ProductDTO getProductsById(Long id){
		return mapProductEntityToDTO(productRepository.findById(id));
	}
	



	public void createNewProduct(ProductDTO productDTO){
    		productRepository.persist(mapProductDTOToEntity(productDTO));

	}
		private ProductEntity mapProductDTOToEntity(ProductDTO productDTO){

			ProductEntity product = new ProductEntity();
		
			product.setName(productDTO.getName());
			product.setDescription(productDTO.getDescription());
			product.setArea(productDTO.getArea());
			product.setPrice(productDTO.getPrice());
		
			return product;
		}
	
	public void changeProduct(Long id, ProductDTO product){
		ProductEntity productEntity = productRepository.findById(id);

		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setArea(product.getArea());
		productEntity.setPrice(product.getPrice());

		productRepository.persist(productEntity);
	}

	public void deleteProduct(Long id){
		productRepository.deleteById(id);
	    }
	
}

    

