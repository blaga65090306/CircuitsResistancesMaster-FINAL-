package ca.cegepjonquiere.simulohmatique;

import java.util.Stack;

public class FabriqueCircuit {

    public static AbstractCircuit fabriquerCircuit(String description) {
        AbstractCircuit p = null;
        Stack<AbstractCircuit> pileSousCircuit = new Stack<>();
        String[] sousCircuit = description.split(" ");
        for (String s : sousCircuit) {
            switch (s) {
                case "(" -> {
                    CircuitSerie cs1 = new CircuitSerie();
                    if (!pileSousCircuit.empty()) {
                        pileSousCircuit.peek().ajouterComposant(cs1);
                    }
                    pileSousCircuit.push(cs1);
                }
                case ")", "]" -> p = pileSousCircuit.pop();
                case "[" -> {
                    CircuitParallele cp1 = new CircuitParallele();
                    if (!pileSousCircuit.empty()) {
                        pileSousCircuit.peek().ajouterComposant(cp1);
                    }
                    pileSousCircuit.push(cp1);
                }
                default -> {
                    Resistor r = FabriqueResistor.fabriquerResistor(s);
                    if (r != null) {
                        pileSousCircuit.peek().ajouterComposant(r);
                    } else {
                        return null;
                    }
                }
            }

        }
        return p;
    }
}

