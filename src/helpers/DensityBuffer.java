package helpers;

import java.util.ArrayList;
import java.util.List;

public class DensityBuffer {
    private Double x;
    private Double y;

    Double[][] densityValues;

    public DensityBuffer(Double x, Double y, Double[][] densityValues) {
        this.x = x;
        this.y = y;
        this.densityValues = densityValues;
    }

    public DensityBuffer(int rows, int columns) {
        this.x = 0.0;
        this.y = 0.0;
        this.densityValues = new Double[rows][columns];
    }

    public DensityBuffer(Double x, Double y, int rows, int columns) {
        this.x = x;
        this.y = y;
        this.densityValues = new Double[rows][columns];
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double[][] getDensityValues() {
        return densityValues;
    }

    public void setDensityValues(Double[][] densityValues) {
        this.densityValues = densityValues;
    }
}
