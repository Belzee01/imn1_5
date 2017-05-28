package helpers;

public class PotentialPoint {

    private Double x;
    private Double y;

    private Boolean isObstacle;
    private Double value;
    private Double wir;

    private Double density;
    private MyPair velocity;

    public PotentialPoint() {
        x = 0.0;
        y = 0.0;

        isObstacle = false;
        value = 0.0;
        this.wir = 0.0;
        this.density = 0.0;
        this.velocity = new MyPair(0.0, 0.0);
    }

    public PotentialPoint(Double x, Double y, Boolean isObstacle, Double value, Double wir, Double density, MyPair velocity) {
        this.x = x;
        this.y = y;
        this.isObstacle = isObstacle;
        this.value = value;
        this.wir = wir;
        this.density = density;
        this.velocity = velocity;
    }

    public PotentialPoint(Double x, Double y) {
        this.x = x;
        this.y = y;
        isObstacle = false;
        value = 0.0;
        this.wir = 0.0;
    }

    public PotentialPoint(PotentialPoint other) {
        this.x = other.x;
        this.y = other.y;
        this.isObstacle = other.isObstacle;
        this.value = other.value;
        this.wir = other.wir;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Boolean getObstacle() {
        return isObstacle;
    }

    public Double getValue() {
        return value;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setObstacle(Boolean obstacle) {
        isObstacle = obstacle;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setWir(Double wir) {
        this.wir = wir;
    }

    public Double getWir() {
        return wir;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public MyPair getVelocity() {
        return velocity;
    }

    public void setVelocity(MyPair velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return "[" + x + " " + y + " " + wir+" " + value+ "] ";
    }
}

