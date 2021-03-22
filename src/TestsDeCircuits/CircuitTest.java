package TestsDeCircuits;


import ca.cegepjonquiere.simulohmatique.AbstractCircuit;
import ca.cegepjonquiere.simulohmatique.CircuitParallele;
import ca.cegepjonquiere.simulohmatique.CircuitSerie;
import ca.cegepjonquiere.simulohmatique.Resistor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CircuitTest {

    private Resistor[] res;

    @Test
    public void serieTest() {
        CircuitSerie p1 = new CircuitSerie();
        for (Resistor r : res)
            p1.ajouterComposant(r);

        p1.mettreSousTension(24);

        assertEquals(29, p1.calculerResistance(), 0.1);
        assertEquals(0.827, p1.calculerCourant(), 0.1);
        assertEquals(24, p1.calculerTension(), 0.1);
    }

    //C'est mon test de circuit en serie
    @Test
    public void serieTest2(){
        CircuitSerie cs1 = new CircuitSerie();
        for (Resistor r : res)
            cs1.ajouterComposant(r);

        cs1.mettreSousTension(9);

        assertEquals(29, cs1.calculerResistance(), 0.1);
        assertEquals(0.31, cs1.calculerCourant(), 0.1);
        assertEquals(9, cs1.calculerTension(),0.1);
    }

    @Test
    public void mixteTest(){
        Resistor r1 = new Resistor();
        r1.setResistance(5);
        Resistor r2 = new Resistor();
        r2.setResistance(8);
        Resistor r3 = new Resistor();
        r3.setResistance(8);
        Resistor r4 = new Resistor();
        r4.setResistance(6);
        AbstractCircuit circuit = new CircuitParallele();
        circuit.ajouterComposant(r2);
        circuit.ajouterComposant(r3);
        AbstractCircuit circuit2 = new CircuitSerie();
        circuit2.ajouterComposant(r1);
        circuit2.ajouterComposant(circuit);
        circuit2.ajouterComposant(r4);
        assertEquals(15, circuit2.calculerResistance(), 0.1);
        assertEquals(4, circuit2.calculerCourant(), 0.1);
        assertEquals(60, circuit2.calculerTension(), 0.1);
    }

    @Test
    public void paralleleTest() {
        CircuitParallele p1 = new CircuitParallele();
        for (Resistor r : res)
            p1.ajouterComposant(r);

        p1.mettreSousTension(120);

        assertEquals(1.518, p1.calculerResistance(), 0.1);
        assertEquals(79.05, p1.calculerCourant(), 0.1);
        assertEquals(120, p1.calculerTension(), 0.1);
    }

    @BeforeEach
    public void setUpResistors() {
        res = new Resistor[4];
        res[0] = new Resistor();
        res[0].setResistance(5);
        res[1] = new Resistor();
        res[1].setResistance(4);
        res[2] = new Resistor();
        res[2].setResistance(12);
        res[3] = new Resistor();
        res[3].setResistance(8);
    }
}
