package org.control;

import org.entity.Client;
import org.entity.Playlist;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlaylistService {

    @Transactional
    public Playlist getPlaylistByClient(Long id){
        Client client = Client.findById(id);
        return client.getLikedSongs();

    }

    public List<Playlist> getAllPlaylists() {
        return Playlist.listAll();
    }
}
