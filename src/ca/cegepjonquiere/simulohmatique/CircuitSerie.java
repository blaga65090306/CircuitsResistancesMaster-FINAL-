package ca.cegepjonquiere.simulohmatique;

import java.util.stream.Collectors;

public class CircuitSerie extends AbstractCircuit {

    @Override
    public double calculerResistance(){
        return iComposantList.stream().mapToDouble(IComposant::calculerResistance).sum();
    }

    @Override
    public void mettreSousTension(double tension) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("\nVotre tension est nulle et cela peut causer un court-circuit... Veuillez mettre une tension à votre ciruit.");
        this.tension = tension;
        iComposantList.forEach(iComposant -> iComposant.mettreSousTension(iComposant.calculerResistance() * calculerCourant()));
        if (tension == 0) {
            throw illegalArgumentException;
        }
    }

    @Override
    public String toString() {
        String total = iComposantList.stream().map(IComposant::toString).collect(Collectors.joining(" "));
        return "\nVotre circuit en serie fait un total de: " + "[" + calculerResistance() + "Ω, " + calculerCourant() + "A, " + calculerTension() + "V]" +
                "\nChacun de vos resisteurs dans votre circuit en serie font: " + total;
    }
}

