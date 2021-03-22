package ca.cegepjonquiere.simulohmatique;

public interface IComposant {

    void mettreSousTension(double tension);

    double calculerTension();

    double calculerCourant();

    double calculerResistance();
}
