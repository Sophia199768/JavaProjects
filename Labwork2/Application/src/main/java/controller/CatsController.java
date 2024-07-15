package controller;

import dao.CatDao;
import model.Cat;
import service.CatsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cats")
public class CatsController {
    @Inject
    private CatsService catsService = new CatsService(new CatDao());

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        Cat cat = catsService.findById(id);

        if (cat == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(cat).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Cat cat) {
        catsService.update(cat);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        catsService.delete(id);
        return Response.noContent().build();
    }
}
