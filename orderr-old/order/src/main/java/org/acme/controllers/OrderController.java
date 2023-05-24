package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.OrderDTO;
import org.acme.service.OrderService;
import java.util.List;

@Path("/api/order")
public class OrderController {

    @Inject
    OrderService orderService;

    @GET
    //@RolesAllowed("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDTO> findAllProduct() {
        return orderService.findAllProducts();
    }

    @POST
    //@RolesAllowed("manager")
    @Transactional//usa quando altera algum dado BD
    public Response saveProduct(OrderDTO orderDTO) {
        try {
            orderService.createNewProduct(orderDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    Response changeProduct(@PathParam("id") Long id, OrderDTO orderDTO) {
        try {
            orderService.changeProduct(id, orderDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteProduct(@PathParam("id") Long id) {
        try {
            orderService.deleteProduct(id);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}