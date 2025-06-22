import model.Match;
import model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClasses(Player.class, Match.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Player firstPlayer = new Player("Sergey");
            Player secondPlayer = new Player("Ilmira");

            session.persist(firstPlayer);
            session.persist(secondPlayer);

            session.getTransaction().commit();






        }
    }
}
