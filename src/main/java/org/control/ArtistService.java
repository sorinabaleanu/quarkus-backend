package org.control;

import org.entity.Artist;
import org.entity.Client;
import org.entity.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ArtistService {

    @Transactional
    public Artist addArtist(Artist artist) {
        artist.persist();
        return artist;
    }

    public List<Artist> listArtists() {
        return Artist.listAll();
    }

    @Transactional
    public Artist updateArtist(Long id, Artist updateArtist) {
        Artist artist = Artist.findById(id);
        artist.setName(updateArtist.getName());
        return artist;
    }

    public Artist getArtistById(Long id) {
        Artist artist = Artist.findById(id);
        return artist;
    }

    @Transactional
    public Artist deleteArtist(Long id){
        Artist artist = Artist.findById(id);
        artist.delete();
        return artist;
    }


}
