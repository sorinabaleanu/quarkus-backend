package org.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client  extends PanacheEntity {
    private Long id;
    private String name;
    private String username;
    private String password;

    @OneToOne
    private Playlist likedSongs;

    public static Client findByUsername(String username){
        return find("username", username).firstResult();
    }


}