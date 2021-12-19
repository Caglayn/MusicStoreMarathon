package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.CDEntity;
import com.caglayan.maraton.utils.LogUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public class CDEntityController implements Controllable<CDEntity> {
    @Override
    public void delete(long id) {
        try {
            CDEntity tempEntity = find(id);
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
    public void update(CDEntity entity) {
        try {
            CDEntity tempEntity = find(entity.getCdId());
            tempEntity.setCdArtist(entity.getCdArtist());
            tempEntity.setAlbumName(entity.getAlbumName());
            tempEntity.setCanSold(entity.getCanSold());
            tempEntity.setGenres(entity.getGenres());
            tempEntity.setPrice(entity.getPrice());
            tempEntity.setDiscountRate(entity.getDiscountRate());

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
    public ArrayList<CDEntity> list() {
        Session session = databaseConnectionHibernate();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CDEntity> criteria = builder.createQuery(CDEntity.class);
        criteria.from(CDEntity.class);

        ArrayList<CDEntity> cdAlbums = (ArrayList<CDEntity>) session.createQuery(criteria).getResultList();

        if (cdAlbums.size() > 0) {
            LogUtil.getInstance().logInfo("Kayitlar bulundu.");
        } else
            LogUtil.getInstance().logInfo("Listelenecek kayit bulunamadi !");

        return cdAlbums;
    }

    @Override
    public CDEntity find(long id) {
        Session session = databaseConnectionHibernate();
        CDEntity tempEntity = null;
        try {
            tempEntity = session.find(CDEntity.class, id);

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

    public ArrayList<CDEntity> getDiscountedAlbums (){
        Session session = databaseConnectionHibernate();

        String hql = "SELECT entity from CDEntity as entity WHERE entity.discountRate >:key";
        TypedQuery<CDEntity> typedQuery = session.createQuery(hql, CDEntity.class);
        typedQuery.setParameter("key", 0.0);
        ArrayList<CDEntity> list = (ArrayList<CDEntity>) typedQuery.getResultList();

        return list;
    }
}
