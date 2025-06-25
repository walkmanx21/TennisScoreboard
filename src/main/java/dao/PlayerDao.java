package dao;

import model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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

    public void insertPlayers(model.Player firstPlayer, Player secondPlayer) {

        Long after;
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClasses(Player.class, model.Match.class);



        Long before = System.currentTimeMillis();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            after = System.currentTimeMillis();
            Long time = after - before;
            System.out.println();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.persist(firstPlayer);
            session.persist(secondPlayer);

            session.getTransaction().commit();
        }



    }
}
