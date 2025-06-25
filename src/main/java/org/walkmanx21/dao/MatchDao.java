package org.walkmanx21.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.walkmanx21.model.Match;
import org.walkmanx21.util.HibernateUtil;

public class MatchDao {
    private static final MatchDao INSTANCE = new MatchDao();

    private MatchDao(){}

    public static MatchDao getInstance() {
        return INSTANCE;
    }

    public void insertMatch(Match match) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(match);
            session.getTransaction().commit();
        }
    }
}
