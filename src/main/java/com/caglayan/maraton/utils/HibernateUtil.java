package com.caglayan.maraton.utils;


import com.caglayan.maraton.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static HibernateUtil instance;
    private Session session;

    private final SessionFactory sessionFactory = createSessionFactory();

    private HibernateUtil(){
    }

    public static HibernateUtil getInstance(){
        if (instance == null)
            instance = new HibernateUtil();
        return instance;
    }

    private SessionFactory createSessionFactory() {
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

    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }

    public Session getOpenSession(){
        if (this.session == null || !this.session.isConnected())
            this.session = this.getSessionFactory().openSession();
        return this.session;
    }
}
