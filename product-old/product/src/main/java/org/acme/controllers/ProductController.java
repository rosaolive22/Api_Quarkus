package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ProductDTO;
import org.acme.service.ProductService;
import java.util.List;

@Path("/api/product")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    //@RolesAllowed("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> findAllProduct() {
        return productService.findAllProducts();
    }



    //Relacionamento com o Microsserviço Order
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO findProductById(@PathParam("id")Long id) {
        return productService.getProductsById(id);
    }
    




    @POST
    //@RolesAllowed("manager")
    @Transactional//usa quando altera algum dado BD
    public Response saveProduct(ProductDTO productDTO) {
        try {
            productService.createNewProduct(productDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    @PUT
    @Path("/{id}")
    @Transactional
    Response changeProduct(@PathParam("id") Long id, ProductDTO productDTO) {
        try {
            productService.changeProduct(id, productDTO);
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
            productService.deleteProduct(id);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}