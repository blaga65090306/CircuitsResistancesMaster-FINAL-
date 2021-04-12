package ca.cegepjonquiere.simulohmatique;

import ca.cegepjonquiere.simulohmatique.IComposant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractCircuit implements IComposant {

    protected List<IComposant> iComposantList = new ArrayList<>();
    protected double tension;

    public List<IComposant> getiComposantList() {
        return iComposantList;
    }

    public boolean empty() {
        if (iComposantList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void setiComposantList(List<IComposant> iComposantList) {
        this.iComposantList = iComposantList;
    }

    public void ajouterComposant (IComposant c){
        iComposantList.add(c);
    }

    public double calculerTension(){
        return tension;
    }

    public abstract double calculerResistance();

    public double calculerCourant(){
        return calculerTension() / calculerResistance();
    }

    @Override
    public String toString() {
        return "AbstractCircuit{" +
                "iComposantList=" + iComposantList +
                ", tension=" + tension +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCircuit that = (AbstractCircuit) o;
        return Objects.equals(iComposantList, that.iComposantList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iComposantList);
    }
}