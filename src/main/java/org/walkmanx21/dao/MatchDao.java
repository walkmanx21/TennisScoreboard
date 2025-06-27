package org.walkmanx21.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.walkmanx21.model.Match;
import org.walkmanx21.model.Player;
import org.walkmanx21.util.HibernateUtil;

import java.util.List;

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

    public List<Match> getAllMatches() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        List<Match> matches;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            String hql = "FROM Match";
            var selectionQuery = session.createSelectionQuery(hql, Match.class);
            matches = selectionQuery.getResultList();
            session.getTransaction().commit();
        }

        return matches;
    }
}
