package Model;

import Entities.Point;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Named
@ApplicationScoped
public class PointDao {

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PersistenceContext(unitName = "ITMO")
    private EntityManager entityManager;

    @Transactional
    public void savePoint(Point point) {
        if (point.getCorrect() == 1) {
            entityManager.persist(point);
        }
    }

    public List<Point> getPoints() {
        TypedQuery<Point> query
                = entityManager.createQuery("SELECT p FROM Point p ORDER BY p.id DESC", Point.class);
        return query.getResultList();
    }
}
