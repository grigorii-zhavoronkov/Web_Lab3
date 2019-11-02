package Controller;

public class CurrentPointBean {
    private float x;
    private float y;
    private float r;
    private boolean correct;
    private boolean in;

    public CurrentPointBean() {
        this.x = 0;
        this.y = 0;
        this.r = 1;
        this.correct = false;
        this.in = false;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public String getY() {
        return String.valueOf(y);
    }

    public void setY(String y) {
        try {
            this.y = Float.parseFloat(y);
        } catch (Exception e) {
            this.y = 0;
        }
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }
}
