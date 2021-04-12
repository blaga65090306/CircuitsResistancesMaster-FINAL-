package ca.cegepjonquiere.simulohmatique;

public class CircuitParallele extends AbstractCircuit {

    @Override
    public double calculerResistance(){
        double resistanceTotale = 0;
        int i = 0;
        for (i = 0; i < iComposantList.size(); i++) {
            if(iComposantList.get(i) != null) {
                resistanceTotale += 1 / iComposantList.get(i).calculerResistance();
            }
        }
        return 1 / resistanceTotale;
    }

    @Override
    public void mettreSousTension(double tension) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("\nVotre tension est nulle et cela peut causer un court-circuit... Veuillez mettre une tension à votre ciruit.");
        this.tension = tension;
        for (IComposant iComposant : iComposantList) {
            iComposant.mettreSousTension(tension);
        }
        if (tension == 0) {
            throw illegalArgumentException;
        }
    }

    @Override
    public String toString() {
        String total = "";
        for (IComposant iComposant : iComposantList) {
            if (iComposant != null) {
                total += "\n[" + iComposant.toString() + "]";
            }
        }
        return "\nVotre circuit en parallele fait un total de: " + "[" + calculerResistance() + "Ω, " + calculerCourant() + "A, " + calculerTension() + "V]" +
                "\nChacun de vos resisteurs dans votre circuit en parallele font: " + total;
    }
}
