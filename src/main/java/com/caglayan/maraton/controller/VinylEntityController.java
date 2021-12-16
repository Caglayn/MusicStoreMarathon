package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.DVDEntity;
import com.caglayan.maraton.entities.VinylEntity;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public class VinylEntityController implements Controllable<VinylEntity> {
    @Override
    public void delete(VinylEntity entity) {
        {
            try {
                VinylEntity tempEntity = find(entity.getVinylId());
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
    }

    @Override
    public void update(VinylEntity entity) {
        try {
            VinylEntity tempEntity = find(entity.getVinylId());
            tempEntity.setVinylArtist(entity.getVinylArtist());
            tempEntity.setCanSold(entity.getCanSold());
            tempEntity.setGenres(entity.getGenres());
            tempEntity.setPrice(entity.getPrice());
            tempEntity.setAlbumName(entity.getAlbumName());
            tempEntity.setDiscountRate(entity.getDiscountRate());
            tempEntity.setDiameter(entity.getDiameter());
            tempEntity.setSpeed(entity.getSpeed());

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
    public ArrayList<VinylEntity> list() {
        Session session = databaseConnectionHibernate();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<VinylEntity> criteria = builder.createQuery(VinylEntity.class);
        criteria.from(VinylEntity.class);

        ArrayList<VinylEntity> vinylAlbums = (ArrayList<VinylEntity>) session.createQuery(criteria).getResultList();

//        if (users.size() > 0) {
//            LogUtil.getInstance().logInfo("Kayitlar bulundu.");
//        } else
//            LogUtil.getInstance().logInfo("Listelenecek kayit bulunamadi !");

        return vinylAlbums;
    }

    @Override
    public VinylEntity find(long id) {
        Session session = databaseConnectionHibernate();
        VinylEntity tempEntity = null;
        try {
            tempEntity = session.find(VinylEntity.class, id);

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

    public ArrayList<VinylEntity> getDiscountedAlbums (){
        Session session = databaseConnectionHibernate();

        String hql = "SELECT entity from VinylEntity as entity WHERE entity.discountRate >:key";
        TypedQuery<VinylEntity> typedQuery = session.createQuery(hql, VinylEntity.class);
        typedQuery.setParameter("key", 0.0);
        ArrayList<VinylEntity> list = (ArrayList<VinylEntity>) typedQuery.getResultList();

        return list;
    }
}
