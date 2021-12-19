package com.caglayan.maraton.utils;

import com.caglayan.maraton.controller.ArtistEntityController;
import com.caglayan.maraton.model.dto.ArtistViewDto;

import java.util.ArrayList;
import java.util.TreeMap;

public class ArtistProvider {
    private static ArtistProvider instance;

    private TreeMap<String, ArtistViewDto> artistList;

    private ArtistProvider() {
    }

    public static ArtistProvider getInstance(){
        if (instance == null){
            instance = new ArtistProvider();
        }
        return instance;
    }

    private void getArtistsFromDb(){
        this.artistList = new TreeMap<>();
        ArtistEntityController artistEntityController = new ArtistEntityController();
        artistEntityController.list().forEach(i-> this.artistList.put(i.getArtistName(), new ArtistViewDto(i)));
    }

    public ArrayList<ArtistViewDto> getAllArtists(){
        if (this.artistList == null){
            getArtistsFromDb();
        }
        return new ArrayList<>(this.artistList.values());
    }

    public ArtistViewDto getArtistByName(String name){
        if (this.artistList == null){
            getArtistsFromDb();
        }
        return this.artistList.get(name);
    }
}
