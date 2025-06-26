package org.walkmanx21.dao;

import org.hibernate.exception.ConstraintViolationException;
import org.walkmanx21.exceptions.PlayerAlreadyExistException;
import org.walkmanx21.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.walkmanx21.util.HibernateUtil;

import java.sql.SQLException;


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

    public void insertPlayer(Player player) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(player);
            session.getTransaction().commit();
        } catch (ConstraintViolationException ignored) {}
    }
}
