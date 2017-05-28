package fileproc;

import helpers.PotentialPoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {

    public static void readFromFile(String filename, PotentialPoint[][] potentialPoints) {
        Scanner scanner;
        File file = new File(filename);
        try {
            int k = 0;
            scanner = new Scanner(file);
            for (int i = 0; i < potentialPoints.length; i++) {
                for (int j = 0; j < potentialPoints[0].length; j++) {
                    if (scanner.hasNextLine()) {
                        String[] line = scanner.nextLine().split(" ");
                        List<String> lines = Stream.of(line).filter(l -> !l.equals(" ") && !l.equals("")).collect(Collectors.toList());

                        potentialPoints[i][j].getVelocity().setU(Double.valueOf(lines.get(2)));
                        potentialPoints[i][j].getVelocity().setV(Double.valueOf(lines.get(3)));
                        potentialPoints[i][j].setObstacle(Integer.valueOf(lines.get(4)) == 0);

                    }
                }
                System.out.println("K = " + k++);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
