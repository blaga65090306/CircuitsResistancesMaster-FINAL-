package ca.cegepjonquiere.simulohmatique;

import java.util.stream.Collectors;

public class CircuitParallele extends AbstractCircuit {

    @Override
    public double calculerResistance(){
        return 1 / iComposantList.stream().mapToDouble(c -> 1 / c.calculerResistance()).sum();
    }

    @Override
    public void mettreSousTension(double tension) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("\nVotre tension est nulle et cela peut causer un court-circuit... Veuillez mettre une tension à votre ciruit.");
        this.tension = tension;
        iComposantList.forEach(iComposant -> iComposant.mettreSousTension(tension));
        if (tension == 0) {
            throw illegalArgumentException;
        }
    }

    @Override
    public String toString() {
        String total = iComposantList.stream().map(c -> "\n[" + c.toString() + "]").collect(Collectors.joining(" "));
        return "\nVotre circuit en parallele fait un total de: " + "[" + calculerResistance() + "Ω, " + calculerCourant() + "A, " + calculerTension() + "V]" +
                "\n\nChacun de vos resisteurs dans votre circuit en parallele font: " + total;
    }
}
