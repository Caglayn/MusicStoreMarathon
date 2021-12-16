package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.ArtistEntity;
import com.caglayan.maraton.entities.UserEntity;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ArtistEntityController implements Controllable<ArtistEntity>{
    @Override
    public void delete(ArtistEntity entity) {

    }

    @Override
    public void update(ArtistEntity entity) {

    }

    @Override
    public ArrayList<ArtistEntity> list() {
        return null;
    }

    @Override
    public ArtistEntity find(long id) {
        return null;
    }

    public ArrayList<ArtistEntity> findByName(String name) {
        Session session = databaseConnectionHibernate();

        String hql = "SELECT entity from ArtistEntity as entity WHERE entity.artistName =:key";
        TypedQuery<ArtistEntity> typedQuery = session.createQuery(hql, ArtistEntity.class);
        typedQuery.setParameter("key", name);
        ArrayList<ArtistEntity> list = (ArrayList<ArtistEntity>) typedQuery.getResultList();
        return list;
    }
}
