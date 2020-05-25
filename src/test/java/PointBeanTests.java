import Bean.PointBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointBeanTests {
    @Test
    public void checkCorrectPoint() {
        //arrange
        PointBean pointBean = new PointBean();
        //act
        pointBean.setX(1);
        pointBean.setY(2);
        pointBean.setR(2);
        pointBean.setCorrectToPoint();

        //assert
        Assertions.assertEquals(1, pointBean.getCorrect());
    }

    @Test
    public void checkCorrectPointWithIncorrectX() {
        PointBean pointBean = new PointBean();

        pointBean.setX(-5);
        pointBean.setY(2);
        pointBean.setR(2);
        pointBean.setCorrectToPoint();

        Assertions.assertEquals(0, pointBean.getCorrect());
    }

    @Test
    public void checkCorrectPointWithIncorrectY() {
        PointBean pointBean = new PointBean();

        pointBean.setX(1);
        pointBean.setY(-10);
        pointBean.setR(2);
        pointBean.setCorrectToPoint();

        Assertions.assertEquals(0, pointBean.getCorrect());
    }

    @Test
    public void checkCorrectPointWithIncorrectR() {
        PointBean pointBean = new PointBean();

        pointBean.setX(1);
        pointBean.setY(2);
        pointBean.setR(-2);
        pointBean.setCorrectToPoint();

        Assertions.assertEquals(0, pointBean.getCorrect());
    }

    @Test
    public void checkPointIn_FirstQuoter() {

    }

    @Test
    public void checkPointOut_FirstQuoter() {

    }

    @Test
    public void checkPointIn_SecondQuoter() {

    }

    @Test
    public void checkPointOut_SecondQuoter() {

    }

    @Test
    public void checkPointIn_ThirdQuoter() {

    }

    @Test
    public void checkPointOut_ThirdQuoter() {

    }

    @Test
    public void checkPointIn_ForthQuoter() {

    }

    @Test
    public void checkPointOut_ForthQuoter() {

    }
}
