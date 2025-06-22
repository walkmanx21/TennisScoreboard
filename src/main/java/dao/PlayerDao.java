package dao;

import exceptions.PlayerAlreadyExistException;
import model.Match;
import model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.processing.SQL;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

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

    public void insertPlayers(List<Player> players) {
        Configuration configuration = new Configuration().addAnnotatedClasses(Player.class, Match.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Player firstPlayer = players.get(0);
            Player secondPlayer = players.get(1);
            session.persist(firstPlayer);
            session.persist(secondPlayer);

            session.getTransaction().commit();
        }
    }
}
