package org.acme.service;

import io.smallrye.common.constraint.NotNull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

//Busca na lista os clientes
    public List<CustomerDTO> findAllCustomers () {
        List<CustomerDTO> customers = new ArrayList<>();
        customerRepository.findAll().stream().forEach(item -> {
            customers.add(mapCustomerEntityToDTO(item));
        });
        return customers;
    }
//Cria usando hibernet
        public void createNewCustomer (CustomerDTO customerDTO){
            customerRepository.persist(mapCustomerDtoToEntity(customerDTO));
        }

//Faz alterações de informações
    public void changeCustomer(Long id, CustomerDTO customerDTO){

        CustomerEntity customer = customerRepository.findById(id);

        customer.setName(customerDTO.getName());
        customer.setPhone(customerDTO.getPhone());
        customer.setE_mail(customerDTO.getE_mail());

        customerRepository.persist(customer);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }


    private CustomerDTO mapCustomerEntityToDTO (CustomerEntity customer){

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setName(customer.getName());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setE_mail(customer.getE_mail());

        return customerDTO;

    }
        private CustomerEntity mapCustomerDtoToEntity (CustomerDTO customer){

            CustomerEntity customerEntity = new CustomerEntity();

            customerEntity.setName(customer.getName());
            customerEntity.setPhone(customer.getPhone());
            customerEntity.setE_mail(customer.getE_mail());

            return customerEntity;
        }


    }

