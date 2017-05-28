package helpers;

import java.util.ArrayList;
import java.util.List;

public class DensityBuffer {
    private List<Double> x;
    private List<Double> y;

    private int rows;
    private int columns;

    private List<double[]> densityValues;


    public DensityBuffer(int rows, int columns, double jump) {
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();

        this.rows = rows;
        this.columns = columns;

        this.densityValues = new ArrayList<>();

        initializeXY(jump);
    }

    private void initializeXY(double jump) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Double x = j * jump;
                Double y = i * jump;
                this.x.add(x);
                this.y.add(y);
            }
        }
    }

    public void addDensityMatrix(PotentialPoint[][] potentialPoints) {
        double[] densityMatrix = new double[potentialPoints.length * potentialPoints[0].length];

        int k = 0;
        for (int i = 0; i < potentialPoints.length; i++) {
            for (int j = 0; j < potentialPoints[0].length; j++) {
                densityMatrix[k++] = potentialPoints[i][j].getDensity();
            }
        }
        this.densityValues.add(densityMatrix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int k = 0;
        for (int i = 0; i < this.densityValues.get(0).length; i++) {
            sb.append(this.y.get(i)).append("\t").append(this.x.get(i)).append("\t");
            for (int j = 0; j < this.densityValues.size(); j++) {
                sb.append(this.densityValues.get(j)[i]).append("\t");
            }
            sb.append("\n");
            if (++k%91 == 0.0 && k != 0)
                sb.append("\n");
        }

        return sb.toString();
    }
}
