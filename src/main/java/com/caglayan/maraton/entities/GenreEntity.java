package com.caglayan.maraton.entities;

import com.caglayan.maraton.model.GenreType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "genres")
public class GenreEntity {
    @Id
    private long genreId;

    @Column(name = "genre_name")
    private String genreName;

    @Column(name = "description")
    private String genreDescription;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private Set<CDEntity> cdAlbums = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private Set<DVDEntity> dvdAlbums = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private Set<VinylEntity> vinylAlbums = new HashSet<>();

    public GenreEntity(GenreType genreType) {
        this.genreId = genreType.getId();
        this.genreName = genreType.getName();
        this.genreDescription = genreType.getDescription();
    }

    public void addCdAlbums(CDEntity album){
        if (this.cdAlbums == null){
            this.cdAlbums = new HashSet<>();
        }
        this.cdAlbums.add(album);
    }

    public void addDvdAlbums(DVDEntity album){
        if (this.dvdAlbums == null){
            this.dvdAlbums = new HashSet<>();
        }
        this.dvdAlbums.add(album);
    }

    public void addVinylAlbums(VinylEntity album){
        if (this.vinylAlbums == null){
            this.vinylAlbums = new HashSet<>();
        }
        this.vinylAlbums.add(album);
    }
}
