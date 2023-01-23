package org.boundary;

import org.control.ClientService;
import org.control.SongService;
import org.entity.Client;
import org.entity.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/song")
public class SongResource {
    @Inject
    private SongService songService;

    SongResource(SongService songService) {
        this.songService = songService;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSong(Song song) {

        songService.addSong(song);
        return Response.ok(song).status(201).build();
    }

    @GET
    public List<Song> getClients() {
        return songService.listAllSongs();
    }

    @PUT
    @Path("like/{songId}/{clientId}")
    public JsonObject likeSong(@PathParam("songId")Long songId, @PathParam("clientId") Long clientId){
        Boolean isLiked = songService.likeSong(songId,clientId);
        JsonObject object =  Json.createObjectBuilder().add("key",isLiked).build();
        return object;
    }

    @GET
    @Path("client/likes/{id}")
    public Set<Song> getLikedSongs(@PathParam("id") Long id) {
        return songService.listLikedSongs(id);
    }

    @GET
    @Path("/{id}")
    public Song getSongById(@PathParam("id") Long id) {
        return songService.getSongById(id);
    }

    @GET
    @Path("like/{songId}/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject isSongLiked(@PathParam("songId")Long songId, @PathParam("clientId") Long clientId) {
        Boolean isLiked = songService.isSongLiked(songId,clientId);
        JsonObject object =  Json.createObjectBuilder().add("key",isLiked).build();
        return object;
    }

    @GET
    @Path("next/{id}")
    public Song getNextSong(@PathParam("id")Long id){
        return this.songService.getNextSong(id);
    }

    @GET
    @Path("previous/{id}")
    public Song getPreviousSong(@PathParam("id")Long id){
        return this.songService.getPreviousSong(id);
    }


}
