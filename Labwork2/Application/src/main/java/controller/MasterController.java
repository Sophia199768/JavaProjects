package controller;

import dao.CatDao;
import dao.MastersDao;
import model.Master;
import service.MasterService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/masters")
public class MasterController {
    @Inject
    private MasterService mastersService = new MasterService(new MastersDao());

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        Master master = mastersService.findById(id);

        if (master == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(master).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Master master) {
        mastersService.update(master);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        mastersService.delete(id);
        return Response.noContent().build();
    }
}
