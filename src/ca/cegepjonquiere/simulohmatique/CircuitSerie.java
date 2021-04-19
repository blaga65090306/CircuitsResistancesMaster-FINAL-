package ca.cegepjonquiere.simulohmatique;

import java.util.stream.Collectors;

public class CircuitSerie extends AbstractCircuit {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

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
        String total = iComposantList.stream().map(c -> "\n[" + c.toString() + "]").collect(Collectors.joining(" "));
        return "\nVotre circuit en " + ANSI_BLUE + "serie" + ANSI_RESET + " fait un total de: " + "[" + calculerResistance() + "Ω, " + calculerCourant() + "A, " + calculerTension() + "V]" +
                "\n\nChacun de vos resisteurs dans votre circuit en " + ANSI_BLUE + "serie" + ANSI_RESET + " font: " + total;
    }
}

