package org.walkmanx21.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.walkmanx21.exceptions.GetSessionFactoryException;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;


public final class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().addAnnotatedClasses(Match.class, Player.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                throw new GetSessionFactoryException(e.getMessage());
            }
        }
        return sessionFactory;
    }

}
