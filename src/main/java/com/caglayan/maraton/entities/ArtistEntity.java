package com.caglayan.maraton.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "artists")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long artistId;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "artist_lastname")
    private String artistLastName;

    @Column(name = "description")
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "cdArtist", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CDEntity> cdAlbums = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "dvdArtist", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DVDEntity> dvdAlbums = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "vinylArtist", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<VinylEntity> vinylAlbums = new HashSet<>();

    public void addCdAlbum(CDEntity album){
        if (this.cdAlbums == null){
            this.cdAlbums = new HashSet<>();
        }
        this.cdAlbums.add(album);
    }

    public void addDvdAlbum(DVDEntity album){
        if (this.dvdAlbums == null){
            this.dvdAlbums = new HashSet<>();
        }
        this.dvdAlbums.add(album);
    }

    public void addVinylAlbum(VinylEntity album){
        if (this.vinylAlbums == null){
            this.vinylAlbums = new HashSet<>();
        }
        this.vinylAlbums.add(album);
    }
}
