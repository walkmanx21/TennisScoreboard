package org.walkmanx21.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.walkmanx21.model.Match;
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

    public List <Match> getMatches (String playerName, int page, int countOfRows) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        List<Match> matches;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            String hql;
            if (playerName != null) {
                hql = "FROM Match WHERE firstPlayer.name = '" + playerName + "' OR secondPlayer.name = '" + playerName + "'";
            } else {
                hql = "FROM Match";
            }
            var selectionQuery = session.createSelectionQuery(hql, Match.class);
            selectionQuery.setFirstResult((page - 1) * countOfRows);
            selectionQuery.setMaxResults(countOfRows);
            matches = selectionQuery.getResultList();
            session.getTransaction().commit();
        }

        return matches;
    }

    public long getAllMatchesCount() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        long count;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Match";

            var selectionQuery = session.createSelectionQuery(hql, Long.class);
            count = selectionQuery.getSingleResult();

            session.getTransaction().commit();
        }

        return count;
    }

}
