
import model.Match;
import model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(Match.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Player player1 = new Player("Sergey");
            Player player2 = new Player("Ilmira");
            Match match = new Match(player1, player2);
            match.setWinner(player2);
            player2.setWonMatches(new ArrayList<>(Collections.singletonList(match)));
            player1.setPlayedMatches(new ArrayList<>(Collections.singletonList(match)));
            player2.setPlayedMatches(new ArrayList<>(Collections.singletonList(match)));
            session.persist(match);
            session.persist(player1);
            session.persist(player2);
            Match findingMatch = session.find(Match.class, 1);
            System.out.println(findingMatch);

            session.getTransaction().commit();
        }
    }
}