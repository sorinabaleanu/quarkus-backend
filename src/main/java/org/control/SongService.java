package org.control;

import org.entity.Client;
import org.entity.Playlist;
import org.entity.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class SongService {

    @Transactional
    public void addSong(Song song) {

        song.persist();
        System.out.println("Song created");
    }//trebuie verificat daca artistul exista in baza de date altfel eroare

    public List<Song> listAllSongs() {
        return Song.listAll();
    }

    @Transactional
    public Boolean likeSong(Long songId, Long clientId) {
        Song song = Song.findById(songId);
        Client client = Client.findById(clientId);

        if(client.getLikedSongs().getSongs() == null) {
            Set<Song> likedSongs = new HashSet<>();
            likedSongs.add(song);
            client.getLikedSongs().setSongs(likedSongs);
            return Boolean.TRUE;
        }else{
            if(client.getLikedSongs().getSongs().contains(song))
            {
                client.getLikedSongs().getSongs().remove(song);
                return Boolean.FALSE;
            }else{
                client.getLikedSongs().getSongs().add(song);
                return Boolean.TRUE;
            }

        }
    }

    public Set<Song> listLikedSongs(Long id){
        Client client = Client.findById(id);
        return client.getLikedSongs().getSongs();
    }

    public Boolean isSongLiked(Long songId,Long clientId){
        Client client = Client.findById(clientId);
        Song song = Song.findById(songId);
        Set<Song> likedSongs = client.getLikedSongs().getSongs();
        return likedSongs.contains(song);
        
        
    }


    public Song getSongById(Long id){
        Song song = Song.findById(id);
        return song;
    }

    public Song getNextSong(Long id){
        Song song = Song.findById(id);
        List<Song> songs = new ArrayList<>(Song.listAll());

        Integer index = songs.indexOf(song);

        if(index+1 == songs.size()) return song;
        return songs.get(index+1);
    }

    public Song getPreviousSong(Long id){
        Song song = Song.findById(id);
        List<Song> songs = new ArrayList<>(Song.listAll());

        Integer index = songs.indexOf(song);

        if(index == 0) return song;
        return songs.get(index-1);
    }

}
