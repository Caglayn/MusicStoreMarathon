package com.caglayan.maraton.model;

import com.caglayan.maraton.entities.GenreEntity;

import java.util.ArrayList;
import java.util.HashMap;

public enum GenreType {
    Pop(1, "Pop", "Pop iste nolacak"),
    Rock(2, "Rock", "Rock iste nolacak"),
    Classic(3, "Classic", "Classic iste nolacak"),
    Jazz(4, "Jazz", "Jazz iste nolacak"),
    Hiphop(5, "Hiphop", "Hiphop iste nolacak"),
    NO_GENRE(999, "NO_GENRE", "NO_GENRE iste nolacak");

    private static final HashMap<String, GenreType> BY_NAME = new HashMap<String, GenreType>();
    private static final HashMap<Long, GenreType> BY_ID = new HashMap<Long, GenreType>();
    private static final ArrayList<GenreEntity> ALL_GENRES = new ArrayList<>();

    static {
        for(GenreType genre : values()) {
            BY_NAME.put(genre.name, genre);
            BY_ID.put(genre.id, genre);
            ALL_GENRES.add(new GenreEntity(genre));
        }
    }

    private long id;
    private String name;
    private String description;

    private GenreType(long id, String name, String description) {
        this.id=id;
        this.name=name;
        this.description = description;
    }

    public static GenreType byName(String name) {
        GenreType genre = BY_NAME.get(name);
        if (genre != null)
            return BY_NAME.get(name);
        else
            return NO_GENRE;
    }

    public static ArrayList<GenreEntity> getAllGenres(){
        return ALL_GENRES;
    }

    public String getName(){
        return this.name;
    }

    public long getId(){
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public static GenreType getById(long id){
        return BY_ID.get(id);
    }
}
