package com.caglayan.maraton.utils;


import com.caglayan.maraton.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(ArtistEntity.class);
            configuration.addAnnotatedClass(CDEntity.class);
            configuration.addAnnotatedClass(DVDEntity.class);
            configuration.addAnnotatedClass(GenreEntity.class);
            configuration.addAnnotatedClass(UserEntity.class);
            configuration.addAnnotatedClass(VinylEntity.class);
            configuration.addAnnotatedClass(BasketEntity.class);
            configuration.addAnnotatedClass(BasketRowEntity.class);

            SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return factory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
