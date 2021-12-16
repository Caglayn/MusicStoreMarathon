package com.caglayan.maraton.model;

import com.caglayan.maraton.entities.GenreEntity;

import java.util.ArrayList;
import java.util.HashMap;

public enum QualityType {
    p144(1, "144p"),
    p240(2,"240p"),
    p480(3, "480p"),
    p720(4, "720p"),
    p1080(5,"1080p");

    private static final HashMap<String, QualityType> BY_NAME = new HashMap<String, QualityType>();
    private static final HashMap<Integer, QualityType> BY_ID = new HashMap<Integer, QualityType>();

    static {
        for(QualityType quality : values()) {
            BY_NAME.put(quality.quality, quality);
            BY_ID.put(quality.id, quality);
        }
    }

    private int id;
    private String quality;

    QualityType(int id, String quality) {
        this.id = id;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public static QualityType getById(int id){
        return BY_ID.get(id);
    }

    public static ArrayList<QualityType> getAllQualities(){
        return (ArrayList<QualityType>)BY_ID.values().stream().toList();
    }
}
