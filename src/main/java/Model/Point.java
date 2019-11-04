package Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Entity
@Table(name = "WEB_LAB3", schema = "S265077")
public class Point {
    @Column(name = "X")
    private float x;
    @Column(name = "Y")
    private float y;
    @Column(name = "R")
    private float r;
    @Column(name = "CORRECT")
    private int correct; // 0 - некорректно, 1 - корректно
    @Column(name = "ISIN")
    private int in; // 0 - не попало, 1 - попало
    @Id
    @Column(name = "ID")
    private BigDecimal id;

    public Point() {
        this.x = 0;
        this.y = 0;
        this.r = 1;
        this.correct = 0;
        this.in = 0;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public String savePoint() {
        this.correct = isCorrect() ? 1 : 0;
        this.in = isIn() ? 1 : 0;
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ITMO");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Query q = entityManager.createNativeQuery("SELECT ID_SEQ.nextval FROM dual");
        this.id  = (BigDecimal) q.getSingleResult();

        entityManager.persist(this);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        return "index.xhtml?faces-redirect=true";
    }

    public List<Point> getPoints() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ITMO");
        EntityManager entityManager = factory.createEntityManager();
        TypedQuery<Point> query = entityManager.createQuery("SELECT с FROM Point AS с ORDER BY id DESC", Point.class);
        List<Point> result = query.getResultList();
        entityManager.close();
        factory.close();
        return result;
    }

    private boolean isCorrect() {
        return true;
    }

    private boolean isIn() {
        return true;
    }
}
