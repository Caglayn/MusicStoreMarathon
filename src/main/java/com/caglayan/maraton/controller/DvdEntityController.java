package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.CDEntity;
import com.caglayan.maraton.entities.DVDEntity;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public class DvdEntityController implements Controllable<DVDEntity> {
    @Override
    public void delete(DVDEntity entity) {
        try {
            DVDEntity tempEntity = find(entity.getDvdId());
            if (tempEntity != null) {
                Session session = databaseConnectionHibernate();
                session.getTransaction().begin();
                session.remove(tempEntity);
                session.getTransaction().commit();
//                LogUtil.getInstance().logInfo("Silme  islemi tamamlandi : >> " + tempEntity);
            }
        } catch (Exception e) {
//            LogUtil.getInstance().logError("Silme sirasinda hata meydana geldi : >> " + this.getClass());
        }
    }

    @Override
    public void update(DVDEntity entity) {
        try {
            DVDEntity tempEntity = find(entity.getDvdId());
            tempEntity.setDvdArtist(entity.getDvdArtist());
            tempEntity.setCanSold(entity.getCanSold());
            tempEntity.setGenres(entity.getGenres());
            tempEntity.setPrice(entity.getPrice());
            tempEntity.setAlbumName(entity.getAlbumName());
            tempEntity.setDiscountRate(entity.getDiscountRate());
            tempEntity.setQuality(entity.getQuality());

            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.merge(tempEntity);
            session.getTransaction().commit();
//            LogUtil.getInstance().logInfo("Guncelleme islemi tamamlandi : >> " + tempEntity);
        } catch (Exception e) {
            e.printStackTrace();
//            LogUtil.getInstance().logError("Guncelleme sirasinda hata meydana geldi : >> " + this.getClass());
        }
    }

    @Override
    public ArrayList<DVDEntity> list() {
        Session session = databaseConnectionHibernate();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DVDEntity> criteria = builder.createQuery(DVDEntity.class);
        criteria.from(DVDEntity.class);

        ArrayList<DVDEntity> dvdAlbums = (ArrayList<DVDEntity>) session.createQuery(criteria).getResultList();

//        if (users.size() > 0) {
//            LogUtil.getInstance().logInfo("Kayitlar bulundu.");
//        } else
//            LogUtil.getInstance().logInfo("Listelenecek kayit bulunamadi !");

        return dvdAlbums;
    }

    @Override
    public DVDEntity find(long id) {
        Session session = databaseConnectionHibernate();
        DVDEntity tempEntity = null;
        try {
            tempEntity = session.find(DVDEntity.class, id);

//            if (tempEntity != null) {
//                LogUtil.getInstance().logInfo("Kayit bulundu : >> " + tempEntity);
//            } else {
//                LogUtil.getInstance().logInfo("Aradiginiz kriterde kayit bulunamadi !!");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempEntity;
    }

    public ArrayList<DVDEntity> getDiscountedAlbums (){
        Session session = databaseConnectionHibernate();

        String hql = "SELECT entity from DVDEntity as entity WHERE entity.discountRate >:key";
        TypedQuery<DVDEntity> typedQuery = session.createQuery(hql, DVDEntity.class);
        typedQuery.setParameter("key", 0.0);
        ArrayList<DVDEntity> list = (ArrayList<DVDEntity>) typedQuery.getResultList();

        return list;
    }
}
