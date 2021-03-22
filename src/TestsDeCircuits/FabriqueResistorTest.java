package TestsDeCircuits;

import ca.cegepjonquiere.simulohmatique.FabriqueResistor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueResistorTest {

    @Test
    void fromCodeQuatreResistance() {
        Assertions.assertEquals(270, FabriqueResistor.fabriquerResistor("RMBo").getResistance());
        assertEquals(1200000, FabriqueResistor.fabriquerResistor("BRVo").getResistance());
    }

    @Test
    void fromCodeCinqResistance() {
        assertEquals(270, FabriqueResistor.fabriquerResistor("RMNNA").getResistance());
        assertEquals(100000, FabriqueResistor.fabriquerResistor("BNNOB").getResistance());
        assertEquals(274, FabriqueResistor.fabriquerResistor("RMJNR").getResistance());
        assertEquals(10000, FabriqueResistor.fabriquerResistor("BNNRB").getResistance());
        assertEquals(35.2, FabriqueResistor.fabriquerResistor("OVRoo").getResistance());
    }

    @Test
    void fromCodeQuatreTolerance() {
        assertEquals(0.05, FabriqueResistor.fabriquerResistor("RMBo").getTolerance());
    }

    @Test
    void fromCodeCinqTolerance() {
        assertEquals(0.1, FabriqueResistor.fabriquerResistor("RMNNA").getTolerance());
    }
    @Test
    void fromCodeInvalid() {
        assertNull(FabriqueResistor.fabriquerResistor(""));
        assertNull(FabriqueResistor.fabriquerResistor("NoNono"));
        assertNull(FabriqueResistor.fabriquerResistor("oBbo"));
        assertNull(FabriqueResistor.fabriquerResistor("XZXZZ"));
        assertNull(FabriqueResistor.fabriquerResistor("RMNNL"));
    }

    @Test
    void fromCodeNull() {
        assertNull(FabriqueResistor.fabriquerResistor(null));
    }

    //C'est le test que j'ai créé
    @Test
    void fromCode() {
        assertEquals(3000, FabriqueResistor.fabriquerResistor("ONRo").getResistance());
        assertEquals(10000, FabriqueResistor.fabriquerResistor("BNOo").getResistance());
        assertEquals(5000, FabriqueResistor.fabriquerResistor("VNRo").getResistance());
        assertEquals(2050, FabriqueResistor.fabriquerResistor("RNVBo").getResistance());
        assertEquals(1400000, FabriqueResistor.fabriquerResistor("BJVo").getResistance());
    }
}