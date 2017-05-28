package helpers;

import java.util.ArrayList;
import java.util.List;

public class PotentialAndWirContainer {

    private List<Integer> iteration;
    private List<Double> potential;
    private List<Double> wir;

    private List<Double> potentialAnal;
    private List<Double> wirAnal;

    public PotentialAndWirContainer() {
        this.iteration = new ArrayList<>();
        this.potential = new ArrayList<>();
        this.wir = new ArrayList<>();

        this.potentialAnal = new ArrayList<>();
        this.wirAnal = new ArrayList<>();
    }

    public void addPoint(Integer iteration, Double potential, Double potentialAnal, Double wir, Double wirAnal) {
        this.iteration.add(iteration);
        this.potential.add(potential);
        this.wir.add(wir);

        this.potentialAnal.add(potentialAnal);
        this.wirAnal.add(wirAnal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < iteration.size(); i++) {
            sb.append(this.iteration.get(i)).append("\t").append(potential.get(i)).append("\t").append(potentialAnal.get(i))
                    .append("\t").append(wir.get(i)).append("\t").append(wirAnal.get(i)).append("\n");
        }
        return sb.toString();
    }

}
