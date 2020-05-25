import Entities.Point;
import Model.PointDao;
import org.junit.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class PointDaoTests {

    private EntityManager entityManager;

    private final Set<Point> points = new HashSet<>();

    @Before
    public void setupContext() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
        entityManager = factory.createEntityManager();
    }

    @After
    public void deletePoints() {
        entityManager.getTransaction().begin();
        points.forEach(p -> {
            entityManager.remove(p);
        });
        entityManager.getTransaction().commit();
    }

    @Test
    public void testPersistAndGetPoint() {
        Point point = new Point();
        PointDao pointDao = new PointDao();
        pointDao.setEntityManager(entityManager);
        point.setCorrect(1);
        point.setIn(1);
        point.setX(0);
        point.setY(0);
        point.setR(0);
        entityManager.getTransaction().begin();
        pointDao.savePoint(point);
        entityManager.getTransaction().commit();
        points.add(point);

        TypedQuery<Point> query = entityManager.createQuery("SELECT p FROM Point p", Point.class);
        Point first = query.getResultList().get(0);

        Assert.assertEquals(first, point);
    }
}
