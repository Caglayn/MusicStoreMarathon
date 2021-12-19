package com.caglayan.maraton.model.dto;


import com.caglayan.maraton.entities.CDEntity;
import com.caglayan.maraton.model.GenreType;
import javafx.beans.property.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class CdViewDto {
    private LongProperty id;
    private StringProperty albumName;
    private DoubleProperty price;
    private BooleanProperty canSold;
    private DoubleProperty discountRate;
    private StringProperty artistName;
    private ObjectProperty<ArtistViewDto> artist;
    private LinkedList<ObjectProperty<GenreType>> genres;

    public CdViewDto(){
        this.id = new SimpleLongProperty();
        this.albumName = new SimpleStringProperty();
        this.price = new SimpleDoubleProperty();
        this.canSold = new SimpleBooleanProperty();
        this.discountRate = new SimpleDoubleProperty();
        this.artistName = new SimpleStringProperty();
        this.artist = new SimpleObjectProperty<>();
        this.genres = new LinkedList<>();
    }

    public CdViewDto(CDEntity entity){
        this();
        this.id.set(entity.getCdId());
        this.albumName.set(entity.getAlbumName());
        this.price.set(entity.getPrice());
        this.canSold.set(entity.getCanSold());
        this.discountRate.set(entity.getDiscountRate());
        this.artistName.set(entity.getCdArtist().getArtistName());
        this.artist.set(new ArtistViewDto(entity.getCdArtist()));
        entity.getGenres().forEach(i-> genres.add(new SimpleObjectProperty<GenreType>(GenreType.getById(i.getGenreId()))));
    }

    public void addGenre(GenreType genre){
        this.genres.add(new SimpleObjectProperty<GenreType>(genre));
    }
}
