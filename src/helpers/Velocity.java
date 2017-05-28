package helpers;

public class Velocity {

    private Double u;
    private Double v;

    public Velocity(Double u, Double v) {
        this.u = u;
        this.v = v;
    }

    public Velocity() {
        this.u = 0.0;
        this.v = 0.0;
    }

    public Double getU() {
        return u;
    }

    public void setU(Double u) {
        this.u = u;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }
}
