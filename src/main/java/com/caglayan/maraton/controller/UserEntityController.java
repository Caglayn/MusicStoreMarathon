package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.UserEntity;
import com.caglayan.maraton.utils.AccountUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public class UserEntityController implements Controllable<UserEntity> {
    @Override
    public void delete(UserEntity entity) {
        try {
            UserEntity tempEntity = find(entity.getUserId());
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
    public void update(UserEntity entity) {
        try {
            UserEntity tempEntity = find(entity.getUserId());
            tempEntity.setBaskets(entity.getBaskets());
            tempEntity.setUserName(entity.getUserName());
            tempEntity.setUserLastname(entity.getUserLastname());
            tempEntity.setEMail(entity.getEMail());
            tempEntity.setPassword(entity.getPassword());
            tempEntity.setIsAdmin(entity.getIsAdmin());
            tempEntity.setPhoneNumber(entity.getPhoneNumber());

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
    public ArrayList<UserEntity> list() {
        Session session = databaseConnectionHibernate();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
        criteria.from(UserEntity.class);

        ArrayList<UserEntity> users = (ArrayList<UserEntity>) session.createQuery(criteria).getResultList();

//        if (users.size() > 0) {
//            LogUtil.getInstance().logInfo("Kayitlar bulundu.");
//        } else
//            LogUtil.getInstance().logInfo("Listelenecek kayit bulunamadi !");

        return users;
    }

    @Override
    public UserEntity find(long id) {
        Session session = databaseConnectionHibernate();
        UserEntity tempEntity = null;
        try {
            tempEntity = session.find(UserEntity.class, id);

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

    public UserEntity findByName(String name) {
        Session session = databaseConnectionHibernate();

        String hql = "SELECT entity from UserEntity as entity WHERE entity.userName =:key";
        TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
        typedQuery.setParameter("key", name);
        ArrayList<UserEntity> list = (ArrayList<UserEntity>) typedQuery.getResultList();
        return list.get(0);
    }

    public UserEntity findByNameAndPassword(String name, String password) {
        Session session = databaseConnectionHibernate();

        String hql = "SELECT entity from UserEntity as entity WHERE entity.userName =:key1 and entity.password =:key2";
        TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
        typedQuery.setParameter("key1", name);
        typedQuery.setParameter("key2", password);
        ArrayList<UserEntity> list = (ArrayList<UserEntity>) typedQuery.getResultList();

        if (list.size()>0)
            return list.get(0);
        else
            return null;
    }

    public boolean LoginWithUsernameAndPassword(String username, String password){
        UserEntity loginUser = findByNameAndPassword(username, password);
        if (loginUser != null){
            AccountUtil.getInstance().setActiveUser(loginUser);
            return true;
        }
        else {
            return false;
        }
    }
}
