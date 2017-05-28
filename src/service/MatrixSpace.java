package service;

import helpers.MatrixBuilder.IntegerMatrix;
import helpers.MatrixBuilder.PotentialMatrix;
import helpers.MyPair;
import helpers.Obstacle;
import helpers.PotentialPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSpace {

    private IntegerMatrix regionMatrix;
    private PotentialMatrix potentialMatrix;

    private Double jump;

    private Integer rows;
    private Integer columns;

    private List<Obstacle> obstacles;

    public MatrixSpace(IntegerMatrix integerMatrix, PotentialMatrix doubleMatrix, Double jump) {
        this.regionMatrix = integerMatrix;
        this.potentialMatrix = doubleMatrix;
        this.jump = jump;
        this.obstacles = new ArrayList<>();

        this.rows = integerMatrix.getMatrix().length;
        this.columns = integerMatrix.getMatrix()[0].length;

        evaluateXY();
    }

    public MatrixSpace addObstacle(Obstacle obstacle) {
        evaluateObstacleRegions(obstacle);
        System.out.println("Added obstacle");
        return this;
    }

    private void evaluateXY() {
        PotentialPoint[][] potentialPoints = potentialMatrix.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                potentialPoints[i][j].setX(i*jump);
                potentialPoints[i][j].setY(j*jump);
            }
        }

        potentialMatrix.setMatrix(potentialPoints);
    }

    private void evaluateObstacleRegions(Obstacle obstacle) {

        System.out.println("Calculating obstacles");
        int numberOfObstacles = obstacle.getMyPairs().size();
        List<MyPair> pairs = obstacle.getMyPairs();

        for (int i = 0; i < numberOfObstacles - 1; i++) {
            if ((pairs.get(i).getX() - pairs.get(i + 1).getX()) < 0.0) {
                for (double x = pairs.get(i).getX(); x <= pairs.get(i + 1).getX(); x += 1.0) {
                    int indexX = (int) (x);
                    int indexY = (int) pairs.get(i).getY();
                    this.regionMatrix.setValue(indexX, indexY, 1);
                }
            } else if ((pairs.get(i).getX() - pairs.get(i + 1).getX()) > 0.0) {
                for (double x = pairs.get(i).getX(); x >= pairs.get(i + 1).getX(); x -= 1.0) {
                    int indexX = (int) (x);
                    int indexY = (int) pairs.get(i).getY();
                    this.regionMatrix.setValue(indexX, indexY, 1);
                }
            } else if ((pairs.get(i).getY() - pairs.get(i + 1).getY()) < 0.0) {
                for (double y = pairs.get(i).getY(); y <= pairs.get(i + 1).getY(); y += 1.0) {
                    int indexX = (int) pairs.get(i).getX();
                    int indexY = (int) y;
                    this.regionMatrix.setValue(indexX, indexY, 1);
                }
            } else if ((pairs.get(i).getY() - pairs.get(i + 1).getY()) > 0.0) {
                for (double y = pairs.get(i).getY(); y >= pairs.get(i + 1).getY(); y -= 1.0) {
                    int indexX = (int) pairs.get(i).getX();
                    int indexY = (int) y;
                    this.regionMatrix.setValue(indexX, indexY, 1);
                }
            }
        }
        System.out.println("Finished calculating obstacles");
        fillObstacles();
        putRegionsInPotentialMatrix();
    }

    private void fillObstacles() {
        System.out.println("Filling obstacles");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.regionMatrix.getMatrix()[i][j] == 0 && checkIfFourNeighbors(this.regionMatrix.getMatrix(), i, j)) {
                    this.regionMatrix.getMatrix()[i][j] = 1;
                }
            }
        }
        System.out.println("Filled obstacles");
    }

    private  boolean checkIfFourNeighbors(Integer[][] array, int x, int y) {
        int count = 0;
        for (int i = x+1; i < array.length; i++) { // przeglad w dol
            if (array[i][y] == 1){
                count++;
                break;
            }
        }
        for (int i = x-1; i >-1; i--) { // przeglad w gore
            if (array[i][y] == 1){
                count++;
                break;
            }
        }
        for (int i = y+1; i < array[0].length; i++) { // przeglad w prawo
            if (array[x][i] == 1) {
                count++;
                break;
            }
        }
        for (int i = y-1; i > -1; i--) { // przeglad w prawo
            if (array[x][i] == 1){
                count++;
                break;
            }
        }

        return count == 4;
    }

    private void printArray() {
        for (Integer[] i : this.regionMatrix.getMatrix()) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n\n\n\n\n\n");
    }

    private void putRegionsInPotentialMatrix() {
        System.out.println("Setting obstacle flag");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.regionMatrix.getMatrix()[i][j] == 1) {
                    this.potentialMatrix.setPotentialPointIsObstacle(i, j, true); //for wariant A y-1
                }
            }
        }
        System.out.println("All obstacle flags set");
    }

    public void moveOldDensity() {
        PotentialPoint[][] potentialPoints = getDoubleMatrix().getMatrix();

        for (int i = 0; i < potentialPoints.length; i++) {
            for (int j = 0; j < potentialPoints[0].length; j++) {
                potentialPoints[i][j].setOldDensity(potentialPoints[i][j].getDensity());
            }
        }
        this.getDoubleMatrix().setMatrix(potentialPoints);
    }

    private int getIndexX(double x) {
        return (int) Math.round(((x)));
    }

    private int getIndexY(double y) {
        return rows - (int) ((y)); // for wariant A +0.0
    }

    public IntegerMatrix getIntegerMatrix() {
        return regionMatrix;
    }

    public PotentialMatrix getDoubleMatrix() {
        return potentialMatrix;
    }

    public Double getJump() {
        return jump;
    }

    public void setRegionMatrix(IntegerMatrix regionMatrix) {
        this.regionMatrix = regionMatrix;
    }

    public void setPotentialMatrix(PotentialMatrix potentialMatrix) {
        this.potentialMatrix = potentialMatrix;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }
}
