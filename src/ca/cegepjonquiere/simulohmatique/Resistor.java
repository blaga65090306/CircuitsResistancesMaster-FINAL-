package ca.cegepjonquiere.simulohmatique;

import java.util.Objects;

public class Resistor implements IComposant {

    private double tolerance;
    private double resistance;
    private double tension;

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public double getTension() {return tension;}

    public void setTension(double tension) {this.tension = tension;}

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    @Override
    public void mettreSousTension(double tension) {
        this.tension = tension;
    }

    @Override
    public double calculerTension() {return tension;}

    @Override
    public double calculerCourant() {return tension/calculerResistance();}

    @Override
    public double calculerResistance() {return resistance;}

    @Override
    public String toString() {
        return  calculerCourant() + "A, " +
                resistance + "Ω, " +
                tension + "V";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resistor resistor = (Resistor) o;
        return Double.compare(resistor.tolerance, tolerance) == 0 && Double.compare(resistor.resistance, resistance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tolerance, resistance);
    }
}

