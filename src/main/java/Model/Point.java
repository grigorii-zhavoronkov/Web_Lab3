package Model;

import javax.persistence.*;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    private int in; // 0 - некорректно, 1 - корректно
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "ID_SEQ", allocationSize = 100)
    @Column(name = "ID")
    private int id;

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void savePoint() {
//        try {
//            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ITMO");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(this);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
