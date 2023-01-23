package org.boundary;

import org.control.ArtistService;
import org.entity.Artist;
import org.entity.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/artist")
@ApplicationScoped
public class ArtistResource {
    ArtistService artistService;

    ArtistResource(ArtistService artistService) {
        this.artistService = artistService;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addArtist(Artist artist) {

        artistService.addArtist(artist);;
        return Response.ok(artist).status(201).build();
    }

    @GET
    public List<Artist> getArtists() {
        return artistService.listArtists();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateArtist(@PathParam("id") Long id, Artist artist) {

        artistService.updateArtist(id, artist);
        return Response.ok(artist).status(201).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteArtist(@PathParam("id") Long id) {

        Artist deletedArtist = artistService.deleteArtist(id);
        return Response.ok(deletedArtist).status(201).build();
    }

    @GET
    @Path("/{id}")
    public Response getArtistById(@PathParam("id")Long id){

        Artist artist = artistService.getArtistById(id);
        return Response.ok(artist).status(201).build();
    }
}
