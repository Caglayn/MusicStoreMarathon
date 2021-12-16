package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.GenreEntity;
import com.caglayan.maraton.model.GenreType;

import java.util.ArrayList;

public class GenreEntityController implements Controllable<GenreEntity> {
    @Override
    public void delete(GenreEntity entity) {

    }

    @Override
    public void update(GenreEntity entity) {

    }

    @Override
    public ArrayList<GenreEntity> list() {
        return null;
    }

    @Override
    public GenreEntity find(long id) {
        return null;
    }

    public void writeAllGenresToDb(){
        this.createMulti(GenreType.getAllGenres());
    }
}
