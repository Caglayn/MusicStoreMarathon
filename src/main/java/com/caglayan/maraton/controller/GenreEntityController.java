package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.GenreEntity;
import com.caglayan.maraton.model.GenreType;
import com.caglayan.maraton.utils.LogUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public class GenreEntityController implements Controllable<GenreEntity> {
    @Override
    public void delete(long id) {
        try {
            GenreEntity tempEntity = find(id);
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
    public void update(GenreEntity entity) {
        try {
            GenreEntity tempEntity = find(entity.getGenreId());
            tempEntity.setGenreName(entity.getGenreName());
            tempEntity.setGenreDescription(entity.getGenreDescription());
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
    public ArrayList<GenreEntity> list() {
        Session session = databaseConnectionHibernate();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GenreEntity> criteria = builder.createQuery(GenreEntity.class);
        criteria.from(GenreEntity.class);

        ArrayList<GenreEntity> genres = (ArrayList<GenreEntity>) session.createQuery(criteria).getResultList();

        if (genres.size() > 0) {
            LogUtil.getInstance().logInfo("Kayitlar bulundu.");
        } else
            LogUtil.getInstance().logInfo("Listelenecek kayit bulunamadi !");

        return genres;
    }

    @Override
    public GenreEntity find(long id) {
        Session session = databaseConnectionHibernate();
        GenreEntity tempEntity = null;
        try {
            tempEntity = session.find(GenreEntity.class, id);

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

    public void writeAllGenresToDb(){
        this.createMulti(GenreType.getAllGenres());
    }
}
