import Bean.PointBean;
import org.junit.Test;
import org.junit.Assert;

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
        Assert.assertEquals(1, pointBean.getCorrect());
    }

    @Test
    public void checkCorrectPointWithIncorrectX() {
        PointBean pointBean = new PointBean();

        pointBean.setX(-5);
        pointBean.setY(2);
        pointBean.setR(2);
        pointBean.setCorrectToPoint();

        Assert.assertEquals(0, pointBean.getCorrect());
    }

    @Test
    public void checkCorrectPointWithIncorrectY() {
        PointBean pointBean = new PointBean();

        pointBean.setX(1);
        pointBean.setY(-10);
        pointBean.setR(2);
        pointBean.setCorrectToPoint();

        Assert.assertEquals(0, pointBean.getCorrect());
    }

    @Test
    public void checkCorrectPointWithIncorrectR() {
        PointBean pointBean = new PointBean();

        pointBean.setX(1);
        pointBean.setY(2);
        pointBean.setR(-2);
        pointBean.setCorrectToPoint();

        Assert.assertEquals(0, pointBean.getCorrect());
    }

    @Test
    public void checkPointIn_FirstQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(2);
        pointBean.setY(1);
        pointBean.setR(3);
        pointBean.setInToPoint();

        Assert.assertEquals(1, pointBean.getIn());
    }

    @Test
    public void checkPointOut_FirstQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(1);
        pointBean.setY(1);
        pointBean.setR(2.75F);
        pointBean.setInToPoint();

        Assert.assertEquals(0, pointBean.getIn());
    }

    @Test
    public void checkPointIn_SecondQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(-1);
        pointBean.setY(0.5F);
        pointBean.setR(2.75F);
        pointBean.setInToPoint();

        Assert.assertEquals(1, pointBean.getIn());
    }

    @Test
    public void checkPointOut_SecondQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(-2);
        pointBean.setY(1);
        pointBean.setR(2.75F);
        pointBean.setInToPoint();

        Assert.assertEquals(0, pointBean.getIn());
    }

    @Test
    public void checkPointIn_ThirdQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(-2);
        pointBean.setY(-0.75F);
        pointBean.setR(2.75F);
        pointBean.setInToPoint();

        Assert.assertEquals(1, pointBean.getIn());
    }

    @Test
    public void checkPointOut_ThirdQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(-3);
        pointBean.setY(-0.7F);
        pointBean.setR(3.25F);
        pointBean.setInToPoint();

        Assert.assertEquals(0, pointBean.getIn());
    }

    @Test
    public void checkPointIn_ForthQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(1);
        pointBean.setY(-0.25F);
        pointBean.setR(1.5F);
        pointBean.setInToPoint();

        Assert.assertEquals(1, pointBean.getIn());
    }

    @Test
    public void checkPointOut_ForthQuoter() {
        PointBean pointBean = new PointBean();

        pointBean.setX(2);
        pointBean.setY(-2);
        pointBean.setR(3.5F);
        pointBean.setInToPoint();

        Assert.assertEquals(0, pointBean.getIn());
    }
}
