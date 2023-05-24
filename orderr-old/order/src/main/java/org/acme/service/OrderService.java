package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.OrderDTO;
import org.acme.entity.OrdertEntity;
import org.acme.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OrderService {

    @Inject
	private OrderRepository orderRepository;

	@Inject
	@RestCliente
	private CustomerClient customerClient;
	@Inject
	@RestCliente
	private ProductClient productClient;

    public List<OrderDTO> findAllOrders () {

		List<OrderDTO> orders = new ArrayList<>();

        orderRepository.findAll().stream().forEach(item ->{
			orders.add(mapOrderEntityToDTO(item));
		});
		return orders;
	}
	public void saveNewProduct(OrderDTO orderDTO){
		OrderDTO orderDTO =customerClient.getCustomerById(orderDTO.getCustomer());
		if(cutomerDTO.getName().equals(orderDTO.getCustomerName())
			&& productClient.getProductById(orderDTO.getProductId()) != null){
			orderRepository.persist(mapDTOToEntity(OrderDTO));
		}else {
			throw new NotFoundException();
		}

	}
	private OrderDTO mapEntityToDTO(OrderEntity item){
		OrderDTO orderDTO = new OrderDTO();
	}




	//--------------------------



			private OrderDTO mapOrderstEntityToDTO(OrdertEntity ordertEntity){

				OrderDTO orders = new OrderDTO();

				orders.setName(ordertEntity.getName());
				orders.setDescription(ordertEntity.getDescription());
				orders.setArea(ordertEntity.getArea());
				orders.setPrice(ordertEntity.getPrice());
				return product;
			}


	public void createNewProduct(OrderDTO orderDTO){
    		orderRepository.persist(mapProductDTOToEntity(orderDTO));

	}
		private OrdertEntity mapProductDTOToEntity(OrderDTO orderDTO){

			OrdertEntity product = new OrdertEntity();
		
			product.setName(orderDTO.getName());
			product.setDescription(orderDTO.getDescription());
			product.setArea(orderDTO.getArea());
			product.setPrice(orderDTO.getPrice());
		
			return product;
		}
	
	public void changeProduct(Long id, OrderDTO product){
		OrdertEntity ordertEntity = orderRepository.findById(id);

		ordertEntity.setName(product.getName());
		ordertEntity.setDescription(product.getDescription());
		ordertEntity.setArea(product.getArea());
		ordertEntity.setPrice(product.getPrice());

		orderRepository.persist(ordertEntity);
	}

	public void deleteProduct(Long id){
		orderRepository.deleteById(id);
	    }
	
}

    

