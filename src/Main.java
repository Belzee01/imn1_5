import fileproc.CustomFileWriter;
import helpers.MatrixBuilder;
import helpers.Obstacle;
import helpers.PotentialPoint;
import service.MatrixSpace;
import service.WariantAAlt;

public class Main {

    public static void zestawA() {

        MatrixSpace matrixSpace4 = new MatrixSpace(
                //                                  rows          columns
                MatrixBuilder.buildIntegerMatrix(301, 91),
                MatrixBuilder.buildDoubleMatrix(301, 91),
                0.01
        );
        WariantAAlt wariantAAlt = new WariantAAlt(matrixSpace4);
        wariantAAlt.executeLeapFrog(20, 25);

        CustomFileWriter.writeToFile(
                wariantAAlt.getDensityBuffer().toString(), "zad1_den.dat"
        );

    }

    public static void main(String[] args) {


        zestawA();

        System.out.println("Hello World!");
    }
}
