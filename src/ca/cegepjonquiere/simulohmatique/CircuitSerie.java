package ca.cegepjonquiere.simulohmatique;

public class CircuitSerie extends AbstractCircuit {

    @Override
    public double calculerResistance(){
        double resistanceTotale = 0;
        int i = 0;
        for (i = 0; i < iComposantList.size(); i++) {
            if(iComposantList.get(i) != null) {
                resistanceTotale += iComposantList.get(i).calculerResistance();
            }
        }
        return resistanceTotale;
    }

    @Override
    public void mettreSousTension(double tension) {
        this.tension = tension;
        for (IComposant iComposant : iComposantList) {
            iComposant.mettreSousTension(iComposant.calculerResistance() * calculerCourant());
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
        return "\nVotre circuit en serie fait un total de: " + "[" + calculerResistance() + "Ω, " + calculerCourant() + "A, " + calculerTension() + "V]" +
                "\nChacun de vos resisteurs dans votre circuit en serie font: " + total;
    }
}

