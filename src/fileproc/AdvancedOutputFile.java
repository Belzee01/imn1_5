package fileproc;

import helpers.PotentialPoint;

import java.util.ArrayList;
import java.util.List;

public class AdvancedOutputFile<T> {

    private List<Section<Double>> sections;

    private String filename;

    public AdvancedOutputFile(PotentialPoint[][] potential, double delta, String filename) {
        this.sections = new ArrayList<>();

        for (double i = 0; i < potential.length; i+=1.0) {
            Section<Double> section = new Section<>();
            for (double j = 0; j < potential[0].length; j+=1.0) {
                section.addRecord(new Record<>(i*delta, j*delta, potential[(int)i][(int)j].getValue()));
            }
            sections.add(section);
        }

        this.filename = filename;
    }

    public AdvancedOutputFile(PotentialPoint[][] wir, double delta, String filename, int k) {
        this.sections = new ArrayList<>();

        for (double i = 0; i < wir.length; i+=1.0) {
            Section<Double> section = new Section<>();
            for (double j = 0; j < wir[0].length; j+=1.0) {
                section.addRecord(new Record<>(i*delta, j*delta, wir[(int)i][(int)j].getWir()));
            }
            sections.add(section);
        }

        this.filename = filename;
    }

    public AdvancedOutputFile(double[][] potential, int numberOfPoints, String filename) {
        this.sections = new ArrayList<>();

        for (int i = 0; i <= numberOfPoints; i ++) {
            Section<Double> section = new Section<>();
            for (int j =0; j <= numberOfPoints; j ++) {
                section.addRecord(new Record<>((double)i, (double)j, potential[i][j]));
            }
            sections.add(section);
        }

        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.sections.forEach(s -> sb.append(s.toString()));

        return sb.toString();
    }

    private class Record<R> {
        private R x;
        private R y;
        private R z;

        public Record(R x, R y, R z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return String.valueOf(x) + "\t" + String.valueOf(y) + "\t" + String.valueOf(z) + "\n";
        }
    }

    private class Section<S> {
        private List<Record<S>> records;

        public Section() {
            this.records = new ArrayList<>();
        }

        public List<Record<S>> getRecords() {
            return records;
        }

        public void addRecord(Record<S> record) {
            this.records.add(record);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            this.records.forEach(r -> sb.append(r.toString()));
            sb.append("\n");

            return sb.toString();
        }
    }
}
