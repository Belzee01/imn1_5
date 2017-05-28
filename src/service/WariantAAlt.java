package service;

import fileproc.CustomFileReader;
import helpers.DensityBuffer;
import helpers.PotentialPoint;

public class WariantAAlt {

    private MatrixSpace matrixSpace;

    private double Q = -1.0;
    private double ni = 1.0;
    private double jump = 0.01;

    private Double maximumVelocity;
    private Double delta;

    private DensityBuffer densityBuffer;

    private void calculateInitialMaximumVelocity(PotentialPoint[][] potentialPoints) {
        this.maximumVelocity = Math.sqrt(Math.pow(matrixSpace.getDoubleMatrix().getMatrix()[0][0].getVelocity().getU(), 2.0) +
                Math.pow(matrixSpace.getDoubleMatrix().getMatrix()[0][0].getVelocity().getV(), 2.0)
        );
    }

    public WariantAAlt(MatrixSpace matrixSpace) {
        this.matrixSpace = matrixSpace;
        this.jump = matrixSpace.getJump();
        this.densityBuffer = new DensityBuffer(301, 91, jump);

        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();

        //Domyslna wartosc maksymalnej predkosci
        calculateInitialMaximumVelocity(potentialPoints);

        //Obliczenie predkosc dla U oraz aktualizacja maksymalnej predkosci na podstawie nowych wartosci skladowych predkosci
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 91; j++) {
                potentialPoints[i][j].getVelocity().setU(evaluateVelocity(j * jump));
                Double tempVelocity = Math.sqrt(Math.pow(potentialPoints[i][j].getVelocity().getU(), 2.0) +
                        Math.pow(potentialPoints[i][j].getVelocity().getV(), 2.0)
                );
                if (tempVelocity > this.maximumVelocity)
                    this.maximumVelocity = tempVelocity;
            }
        }
        matrixSpace.getDoubleMatrix().setMatrix(potentialPoints);

        this.delta = jump / (4.0 * this.maximumVelocity);

        evaluateInitialDensity();
    }

    public WariantAAlt(MatrixSpace matrixSpace, String filename) {
        this.matrixSpace = matrixSpace;
        this.jump = matrixSpace.getJump();
        this.densityBuffer = new DensityBuffer(301, 91, jump);

        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();
        // Set up U and V velocities from file
        loadVelocitiesFromFile(filename);
        //Domyslna wartosc maksymalnej predkosci
        calculateInitialMaximumVelocity(potentialPoints);

        //Obliczenie predkosc dla U oraz aktualizacja maksymalnej predkosci na podstawie nowych wartosci skladowych predkosci
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 91; j++) {
                Double tempVelocity = Math.sqrt(Math.pow(potentialPoints[i][j].getVelocity().getU(), 2.0) +
                        Math.pow(potentialPoints[i][j].getVelocity().getV(), 2.0)
                );
                if (tempVelocity > this.maximumVelocity)
                    this.maximumVelocity = tempVelocity;
            }
        }
        matrixSpace.getDoubleMatrix().setMatrix(potentialPoints);

        this.delta = jump / (4.0 * this.maximumVelocity);

        evaluateInitialDensity();
    }

    private void loadVelocitiesFromFile(String filename) {
        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();

        CustomFileReader.readFromFile(filename, potentialPoints);
    }

    private void evaluateInitialDensity() {
        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();

        //// Density 0
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 91; j++) {
                potentialPoints[i][j].setOldDensity(
                        calculateInitialDensity(i * jump, j * jump)
                );
            }
        }

        ///Density 1
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 91; j++) {
                potentialPoints[i][j].setDensity(
                        calculateInitialDensity(i * jump - potentialPoints[i][j].getVelocity().getU() * delta,
                                j * jump - potentialPoints[i][j].getVelocity().getV() * delta)
                );
            }
        }

        matrixSpace.getDoubleMatrix().setMatrix(potentialPoints);
    }

    private Double calculateI() {
        Double I = 0.0;

        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 91; j++) {
                I += potentialPoints[i][j].getDensity();
            }
        }
        return I;
    }


    private double[][] generateNextDensity() {
        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();

        int k = 0;
        double[][] newDensity = new double[301][91];
        for (int i = 1; i < 300; i++) {
            for (int j = 1; j < 90; j++) {
                Double value = potentialPoints[i][j].getOldDensity() -
                        this.delta * (potentialPoints[i][j].getVelocity().getU() * ((potentialPoints[i + 1][j].getDensity() - potentialPoints[i - 1][j].getDensity()) / (jump)) +
                                potentialPoints[i][j].getVelocity().getV() * ((potentialPoints[i][j + 1].getDensity() - potentialPoints[i][j - 1].getDensity()) / (jump)));

                newDensity[i][j] = value;
            }
        }

        return newDensity;
    }

    public void executeLeapFrog(double iterations, int frequency) {

        double k = 0;
        int counter = 0;

        while (k < iterations) {
            //System.out.println("Iteration delta : " + k);

            /// Generate new denisty based on old and current density
            double[][] density = generateNextDensity();

            /// Reassign current density on old density
            movePotentialPointDensityValues();

            /// Assign newly generated density as current density
            reassignNewOnCurrentDensity(density);
            k += this.delta;

            Double I = calculateI();
            System.out.println("I value : " + I);

            if (counter++%(int)((iterations/delta)/frequency) == 0) {
                densityBuffer.addDensityMatrix(matrixSpace.getDoubleMatrix().getMatrix());
            }
        }

    }

    private void reassignNewOnCurrentDensity(double[][] newDensity) {
        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();

        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 91; j++) {
                potentialPoints[i][j].setDensity(newDensity[i][j]);
            }
        }
        matrixSpace.getDoubleMatrix().setMatrix(potentialPoints);
    }

    private void movePotentialPointDensityValues() {
        PotentialPoint[][] potentialPoints = matrixSpace.getDoubleMatrix().getMatrix();

        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 91; j++) {
                potentialPoints[i][j].setOldDensity(potentialPoints[i][j].getDensity());
            }
        }
        matrixSpace.getDoubleMatrix().setMatrix(potentialPoints);
    }

    private Double calculateInitialDensity(Double x, Double y) {
        return Math.exp(-25.0 * (Math.pow(x - 0.4, 2.0) + Math.pow(y - 0.45, 2.0)));
    }

    private Double evaluateVelocity(Double y) {
        return (Q / (2 * ni)) * (y - 0.0) * (y - 0.9);
    }

    public MatrixSpace getMatrixSpace() {
        return matrixSpace;
    }

    public DensityBuffer getDensityBuffer() {
        return densityBuffer;
    }
}
