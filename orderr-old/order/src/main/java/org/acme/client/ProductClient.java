@Path("/products")
@RegisterRestClient
@ApplicationScoped
public interface ProductClient {

    @GET
    @Path("/{id}")
    CustomerDTO getProductById(@PathParam("id")Long id);
}
