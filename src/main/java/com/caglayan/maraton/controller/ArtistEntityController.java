package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.ArtistEntity;
import com.caglayan.maraton.utils.LogUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public class ArtistEntityController implements Controllable<ArtistEntity>{
    @Override
    public void delete(ArtistEntity entity) {
        try {
            ArtistEntity tempEntity = find(entity.getArtistId());
            if (tempEntity != null) {
                Session session = databaseConnectionHibernate();
                session.getTransaction().begin();
                session.remove(tempEntity);
                session.getTransaction().commit();
                LogUtil.getInstance().logInfo("Silme  islemi tamamlandi : >> " + tempEntity);
            }
        } catch (Exception e) {
            LogUtil.getInstance().logError("Silme sirasinda hata meydana geldi : >> " + this.getClass());
        }
    }

    @Override
    public void update(ArtistEntity entity) {
        try {
            ArtistEntity tempEntity = find(entity.getArtistId());
            tempEntity.setArtistName(entity.getArtistName());
            tempEntity.setArtistLastName(entity.getArtistLastName());
            tempEntity.setDescription(entity.getDescription());
            tempEntity.setCdAlbums(entity.getCdAlbums());
            tempEntity.setDvdAlbums(entity.getDvdAlbums());
            tempEntity.setVinylAlbums(entity.getVinylAlbums());

            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.merge(tempEntity);
            session.getTransaction().commit();
            LogUtil.getInstance().logInfo("Guncelleme islemi tamamlandi : >> " + tempEntity);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.getInstance().logError("Guncelleme sirasinda hata meydana geldi : >> " + this.getClass());
        }
    }

    @Override
    public ArrayList<ArtistEntity> list() {
        Session session = databaseConnectionHibernate();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ArtistEntity> criteria = builder.createQuery(ArtistEntity.class);
        criteria.from(ArtistEntity.class);

        ArrayList<ArtistEntity> artists = (ArrayList<ArtistEntity>) session.createQuery(criteria).getResultList();

        if (artists.size() > 0) {
            LogUtil.getInstance().logInfo("Kayitlar bulundu.");
        } else
            LogUtil.getInstance().logInfo("Listelenecek kayit bulunamadi !");

        return artists;
    }

    @Override
    public ArtistEntity find(long id) {
        Session session = databaseConnectionHibernate();
        ArtistEntity tempEntity = null;
        try {
            tempEntity = session.find(ArtistEntity.class, id);

            if (tempEntity != null) {
                LogUtil.getInstance().logInfo("Kayit bulundu : >> " + tempEntity);
            } else {
                LogUtil.getInstance().logInfo("Aradiginiz kriterde kayit bulunamadi !!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempEntity;
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
