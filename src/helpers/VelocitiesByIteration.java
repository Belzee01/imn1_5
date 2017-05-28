package helpers;

import java.util.ArrayList;
import java.util.List;

public class VelocitiesByIteration {

    private List<Double> velocity;
    private List<Double> velocityAnal;

    public VelocitiesByIteration() {
        this.velocity = new ArrayList<>();
        this.velocityAnal = new ArrayList<>();
    }

    public void addVelocities(Double vel, Double velAnal) {
        this.velocity.add(vel);
        this.velocityAnal.add(velAnal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < velocity.size(); i++) {
            sb.append(i+1).append("\t").append(velocity.get(i)).append("\t").append(velocityAnal.get(i)).append("\n");
        }

        return sb.toString();
    }

}
