import fileproc.CustomFileWriter;
import helpers.MatrixBuilder;
import helpers.Obstacle;
import helpers.PotentialPoint;
import service.MatrixSpace;
import service.WariantAAlt;

public class Main {

    public static void zadanie1() {

        MatrixSpace matrixSpace1 = new MatrixSpace(
                //                                  rows          columns
                MatrixBuilder.buildIntegerMatrix(301, 91),
                MatrixBuilder.buildDoubleMatrix(301, 91),
                0.01
        );
        WariantAAlt wariantAAlt1 = new WariantAAlt(matrixSpace1);
        wariantAAlt1.executeLeapFrog(20, 25);

        CustomFileWriter.writeToFile(
                wariantAAlt1.getDensityBuffer().toString(), "zad1_den.dat"
        );

    }

    public static void zadanie2() {

        MatrixSpace matrixSpace1 = new MatrixSpace(
                //                                  rows          columns
                MatrixBuilder.buildIntegerMatrix(301, 91),
                MatrixBuilder.buildDoubleMatrix(301, 91),
                0.01
        );
        WariantAAlt wariantAAlt1 = new WariantAAlt(matrixSpace1, "predkosc.dat");
        wariantAAlt1.executeLeapFrog(20, 25);

        CustomFileWriter.writeToFile(
                wariantAAlt1.getDensityBuffer().toString(), "zad2_den.dat"
        );

    }

    public static void zadanie3() {
        MatrixSpace matrixSpace1 = new MatrixSpace(
                //                                  rows          columns
                MatrixBuilder.buildIntegerMatrix(301, 91),
                MatrixBuilder.buildDoubleMatrix(301, 91),
                0.01
        );
        WariantAAlt wariantAAlt1 = new WariantAAlt(matrixSpace1, "predkosc.dat");
        wariantAAlt1.executeLeapFrog(20, 25);

        CustomFileWriter.writeToFile(
                wariantAAlt1.getDensityBuffer().toString(), "zad3_den.dat"
        );
    }

    public static void main(String[] args) {


        zadanie1();

        zadanie2();
        System.out.println("Hello World!");
    }
}
