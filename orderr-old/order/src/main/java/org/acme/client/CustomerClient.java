
@Path("/customers")
@RegisterRestClient
@ApplicationScoped
public interface CustomerClient {

    @GET
    @Path("/{id}")
    CustomerDTO getCustomerById(@PathParam("id")Long id);
}