package org.boundary;

import org.control.ClientService;
import org.entity.Client;
import org.entity.Playlist;
import org.entity.Song;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/client")

public class ClientResource {

    private ClientService clientService;

    ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClient(Client client) {
        clientService.addClient(client);
        return Response.ok(client).status(201).build();
    }

    @GET
    public List<Client> getClients() {
        return clientService.listClients();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClient(Client client) {

        clientService.updateClient(client);
        return Response.ok(client).status(201).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Long id) {

        Client deletedClient = clientService.deleteClient(id);
        return Response.ok(deletedClient).status(201).build();
    }

    @GET
    @Path("/{id}")
    public Response getClientById(@PathParam("id")Long id){

        Client client = clientService.getClientById(id);
        return Response.ok(client).status(201).build();
    }

    @POST
    @Path("/login")
    public Client loginClient(Client client){
        return clientService.loginClient(client);
    }

}
