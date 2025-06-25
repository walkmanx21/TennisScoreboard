package org.walkmanx21.dao;

import org.walkmanx21.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.walkmanx21.util.HibernateUtil;


public class PlayerDao {
    private static final PlayerDao INSTANCE = new PlayerDao();

    public static PlayerDao getInstance() {
        return INSTANCE;
    }

    private PlayerDao(){}

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertPlayers(Player firstPlayer, Player secondPlayer) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.persist(firstPlayer);
            session.persist(secondPlayer);

            session.getTransaction().commit();
        }
    }
}
