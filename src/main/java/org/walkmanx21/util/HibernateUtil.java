package org.walkmanx21.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;


public final class HibernateUtil {

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().addAnnotatedClasses(Match.class, Player.class);
        return configuration.buildSessionFactory();
    }

}
