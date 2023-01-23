package org.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Song extends PanacheEntity {

    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="artist")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Artist artist;


}

