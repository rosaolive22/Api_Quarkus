package org.acme.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CustomerDTO;
import org.acme.service.CustomerService;

import java.util.List;

@Path("/api/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;
    @GET
    @RolesAllowed("manager")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> finAllCustomers(){
        return customerService.findAllCustomers();
    }
    @POST
    @RolesAllowed("manager")
    @Transactional//toda vez que for alterar algum dado
    public Response saveCustomer(CustomerDTO customerDTO){
        try {
            customerService.createNewCustomer(customerDTO);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return  Response.serverError().build();
        }
    }
    @PUT
    @Path("/{id}")
    @Transactional Response changeCustomer(@PathParam("id")Long id, CustomerDTO customerDTO){
        try {
            customerService.changeCustomer(id, customerDTO);
            return Response.accepted().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id")Long id){
        try {
            customerService.deleteCustomer(id);
            return Response.accepted().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
