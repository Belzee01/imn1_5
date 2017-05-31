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
        wariantAAlt1.executeLeapFrog(80, 40);

        CustomFileWriter.writeToFile(
                wariantAAlt1.getDensityBuffer().toString(), "zad1_den.dat"
        );

        CustomFileWriter.writeToFile(
                wariantAAlt1.getIntegralIByIteration().toString(), "zad1_I.dat"
        );

        CustomFileWriter.writeToFile(
                wariantAAlt1.getPacketByIteration().toString(), "zad1_packet.dat"
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
        wariantAAlt1.executeLeapFrog(20.0, 25);

        CustomFileWriter.writeToFile(
                wariantAAlt1.getDensityBuffer().toString(), "zad2_den.dat"
        );

        CustomFileWriter.writeToFile(
                wariantAAlt1.getIntegralIByIteration().toString(), "zad2_I.dat"
        );

        CustomFileWriter.writeToFile(
                wariantAAlt1.getPacketByIteration().toString(), "zad2_packet.dat"
        );

    }

    public static void zadanie3() {
        MatrixSpace matrixSpace1 = new MatrixSpace(
                //                                  rows          columns
                MatrixBuilder.buildIntegerMatrix(301, 91),
                MatrixBuilder.buildDoubleMatrix(301, 91),
                0.01
        );
        WariantAAlt wariantAAlt1 = new WariantAAlt(matrixSpace1, "predkosc.dat", 2.0);
        wariantAAlt1.executeLaxFriedrich(20, 25);

        CustomFileWriter.writeToFile(
                wariantAAlt1.getDensityBuffer().toString(), "zad3_den.dat"
        );

        CustomFileWriter.writeToFile(
                wariantAAlt1.getIntegralIByIteration().toString(), "zad3_I.dat"
        );

        CustomFileWriter.writeToFile(
                wariantAAlt1.getPacketByIteration().toString(), "zad3_packet.dat"
        );
    }

    public static void main(String[] args) {


        zadanie1();

        zadanie2();

        zadanie3();
        System.out.println("Hello World!");
    }
}
