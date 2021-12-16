package com.caglayan.maraton.entities;

import com.caglayan.maraton.model.QualityType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "dvd_albums")
public class DVDEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long dvdId;

    @Enumerated(value = EnumType.STRING)
    private QualityType quality;

    @Column(name = "name")
    private String albumName;

    @Column(name = "price")
    private double price;

    @Column(name = "can_sold")
    private Boolean canSold = true;

//    @Lob
//    @Column(name = "album_image", columnDefinition = "BLOB")
//    private byte[] albumImage;

    @Column(name = "discount_rate")
    private double discountRate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    protected ArtistEntity dvdArtist;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(targetEntity = GenreEntity.class, fetch = FetchType.EAGER)
    protected Set<GenreEntity> genres = new HashSet<>();

    public void addGenre(GenreEntity genre ){
        if (this.genres == null){
            this.genres = new HashSet<>();
        }
        this.genres.add(genre);
    }
}
