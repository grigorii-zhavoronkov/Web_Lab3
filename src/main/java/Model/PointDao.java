package Model;

import Entities.Point;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

@Named
@RequestScoped
public class PointDao {

    @PersistenceContext(unitName = "ITMO")
    private EntityManager entityManager;

    @Transactional
    public void savePoint(Point point) {
        entityManager.persist(point);
    }

    public List<Point> getPoints() {
        TypedQuery<Point> query
                = entityManager.createQuery("SELECT p FROM Point p ORDER BY p.id DESC", Point.class);
        return query.getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
