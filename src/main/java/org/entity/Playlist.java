package org.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Playlist extends PanacheEntity {
    private Long id;

    @OneToOne
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @OneToMany
    @JsonIgnore
    private Set<Song> songs;


}
