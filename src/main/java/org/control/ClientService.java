package org.control;

import org.entity.Client;
import org.entity.Playlist;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@ApplicationScoped
public class ClientService {

    @Transactional
    public Client addClient(Client client) {
        Playlist playlist = new Playlist();
        playlist.setClient(client);
        client.setLikedSongs(playlist);
        playlist.persist();
        client.persist();
        return client;
    }

    @Transactional
    public Client updateClient(Client updateClient) {

       Client client = Client.findById(updateClient.getId());
       client.setName(updateClient.getName());
       client.setUsername(updateClient.getUsername());
       client.setPassword(updateClient.getPassword());

       return client;

    }

    @Transactional
    public Client deleteClient(Long id) {
        Client client = Client.findById(id);
        client.getLikedSongs().setSongs(new HashSet<>());
        client.delete();
        return client;
    }

    public Client getClientById(Long id) {

        Client client = Client.findById(id);
        return client;
    }
    public List<Client> listClients() {
        return Client.listAll();
    }

    public Client loginClient(Client client){
        Client detailedClient = Client.findByUsername(client.getUsername());
        if(detailedClient != null){
            if(detailedClient.getPassword().equals(client.getPassword())) {
                return detailedClient;
            }
            else{
                return null;
            }
        }else{
            return null;
        }
    }
}
