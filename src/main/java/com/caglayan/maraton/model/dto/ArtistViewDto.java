package com.caglayan.maraton.model.dto;


import com.caglayan.maraton.entities.ArtistEntity;
import javafx.beans.property.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class ArtistViewDto {
    private LongProperty id;
    private StringProperty name;
    private StringProperty lastName;
    private StringProperty description;
    private LinkedList<Long> cdAlbumIds;
    private LinkedList<Long> dvdAlbumIds;
    private LinkedList<Long> vinylAlbumIds;

    public ArtistViewDto() {
        this.id = new SimpleLongProperty();
        this.name = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.cdAlbumIds = new LinkedList<>();
        this.dvdAlbumIds = new LinkedList<>();
        this.vinylAlbumIds = new LinkedList<>();
    }

    public ArtistViewDto(ArtistEntity entity){
        this();
        this.id.set(entity.getArtistId());
        this.name.set(entity.getArtistName());
        this.lastName.set(entity.getArtistLastName());
        this.description.set(entity.getDescription());
        entity.getCdAlbums().forEach(i-> this.cdAlbumIds.add(i.getCdId()));
        entity.getDvdAlbums().forEach(i-> this.dvdAlbumIds.add(i.getDvdId()));
        entity.getVinylAlbums().forEach(i-> this.vinylAlbumIds.add(i.getVinylId()));
    }
}
