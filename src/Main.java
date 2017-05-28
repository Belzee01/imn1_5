import helpers.MatrixBuilder;
import helpers.Obstacle;
import helpers.PotentialPoint;
import service.MatrixSpace;
import service.WariantAAlt;

public class Main {

    public static void zestawA() {
        MatrixSpace matrixSpace = new MatrixSpace(
                //                                  rows          columns
                MatrixBuilder.buildIntegerMatrix(301, 91),
                MatrixBuilder.buildDoubleMatrix(301, 91),
                0.01
        );

        WariantAAlt wariantA = new WariantAAlt(matrixSpace);

        PotentialPoint[][] potentialPoints = wariantA.getMatrixSpace().getDoubleMatrix().getMatrix();

        wariantA.executeTaskOne();

        MatrixSpace matrixSpace4 = new MatrixSpace(
                //                                  rows          columns
                MatrixBuilder.buildIntegerMatrix(301, 91),
                MatrixBuilder.buildDoubleMatrix(301, 91),
                0.01
        );
        final Obstacle obstacle3 = new Obstacle()
                .addNewObstaclePoint(85.0, 90.0)
                .addNewObstaclePoint(85.0, 70.0) //A
                .addNewObstaclePoint(101.0, 70.0) //B
                .addNewObstaclePoint(101.0, 50.0) //C
                .addNewObstaclePoint(116.0, 50.0) //D
                .addNewObstaclePoint(116.0, 90.0)
                .addNewObstaclePoint(85.0, 90.0);

    }

    public static void main(String[] args) {


        zestawA();

        System.out.println("Hello World!");
    }
}
