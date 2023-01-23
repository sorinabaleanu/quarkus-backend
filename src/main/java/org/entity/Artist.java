package org.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Artist extends PanacheEntity {
    private Long id;
    private String name;


    @OneToMany(mappedBy="artist")
    @JsonIgnore
    private List<Song> songs;

}
