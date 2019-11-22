package Bean;


import Entities.Point;
import Model.PointDao;
import org.primefaces.PrimeFaces;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.*;

public class PointBean implements Serializable {

    private Point point;
    @Inject
    private PointDao pointDao;

    public PointBean() {
        point = new Point();
        point.setX(0);
        point.setY(0);
        point.setR(1);
        point.setIn(0);
        point.setCorrect(0);
    }

    public void savePoint() {
        setCorrectToPoint();
        setInToPoint();
        String params = String.valueOf(point.getCorrect()) + ", "
                + String.valueOf(point.getIn()) + ", "
                + String.valueOf(point.getX()) + ", "
                + String.valueOf(point.getY()) + ", "
                + String.valueOf(point.getR());
        PrimeFaces.current().executeScript("drawPoint(" + params + ")");
        pointDao.savePoint(point);
    }

    public List<Point> getPoints() {
        return pointDao.getPoints();
    }

    public void viewPoints() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
        PrimeFaces.current().dialog().openDynamic("table", options, null);
    }

    private void setCorrectToPoint() {
        point.setCorrect((point.getX() >= -4) && (point.getX() <= 4) && (point.getR() >= 1) && (point.getR() <= 4) ? 1 : 0);
    }

    private void setInToPoint() {
        point.setIn(batman(point.getX(), point.getY(), point.getR()) ? 1 : 0);
    }

    public float getX() {
        return point.getX();
    }

    public void setX(float x) {
        point.setX(x);
    }

    public float getY() {
        return point.getY();
    }

    public void setY(float y) {
        point.setY(y);
    }

    public float getR() {
        return point.getR();
    }

    public void setR(float r) {
        point.setR(r);
    }

    private boolean batman (float xx, float y, float R){
        double rx = R/7.0;
        double ry = R/6.0;
        double x = xx+0.0;
        boolean elipce = ( (pow(x,2))/(49*pow(rx,2)) + (pow(y,2))/(9*pow(ry,2)) -1.0 ) <= 0.00000000000001;
        final double x1 = pow(x, 2) / (49 * pow(rx, 2)) + pow(y, 2) / (9 * pow(ry, 2)) - 1.0;
        System.out.println(x1);
        boolean elipce_down_x = (abs(x/rx)) >= 4;
        boolean elipce_down_y = (y/ry >= -3*sqrt(33)/7.0) && (y/ry <= 0);
        boolean elipce_up_x = (abs(x/rx)) >= 3;
        boolean elipce_up_y = y>=0;
        System.out.println("Elipce "+elipce);
        System.out.println("Elipce elipce_down_x "+elipce_down_x);
        System.out.println("Elipce elipce_down_y "+elipce_down_y);
        System.out.println("Elipce elipce_up_x "+elipce_up_x);
        System.out.println("Elipce elipce_up_y "+elipce_up_y);
        boolean full_elipce = (elipce&elipce_down_x&elipce_down_y) || (elipce&elipce_up_x&elipce_up_y);

        boolean smile = ( ((3*sqrt(33)-7)*pow(x,2))/(-112.0*pow(rx,2)) + abs(x/rx)/2
                +sqrt(1-pow(abs((abs(x/rx))-2)-1,2)) - y/ry -3) <=0;
        boolean smile_y = (y/ry>=-3) && (y/ry<=0);
        boolean smile_x = (x/ry<=4) && (x/ry>=-4);

        boolean full_smile = smile&smile_x&smile_y;


        boolean ears_y = y>=0;
        boolean ears_x = abs(x/rx)<=1 && abs(x/rx)>=0.75;
        boolean ears = -8*abs(x/rx)-y/ry+9>=0;

        boolean full_ears = ears&ears_x&ears_y;

        boolean ears2_x = abs(x/rx)<=0.75 && abs(x/rx)>=0.5;
        boolean ears2 = 3*abs(x/rx)-y/ry+0.75>=0;

        boolean full_ears2 = ears2&ears2_x&ears_y;

        boolean chelka_y = y>=0;
        boolean chelka_x = abs(x/rx)<=0.5;
        boolean chelka=9.0/4.0 - y/ry >=0;

        boolean chelka_full = chelka_x&&chelka_y&&chelka;

        boolean wings_x = abs(x/rx)<=3 && abs(x/rx)>=1;
        boolean wings_y = y>=0;
        boolean wings = -abs(x/rx)/2 - (3.0/7.0)*sqrt(10)*sqrt(4-pow(abs(x/rx)-1,2)) - y/ry + (6*sqrt(10))/7.0 + 1.5 >=0;

        boolean full_wings = wings&&wings_y&&wings_x;
        return !(full_elipce || full_smile || full_ears || full_ears2 || full_wings || chelka_full);
    }

}
