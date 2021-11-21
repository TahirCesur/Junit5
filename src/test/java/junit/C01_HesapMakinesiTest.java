package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class C01_HesapMakinesiTest {

    @Test
    @DisplayName("Sayilari Toplar")
    void topla() {
        assertEquals(3, C01_HesapMakinesi.topla(1, 2));
        assertEquals(4, C01_HesapMakinesi.topla(-8, 12));
        assertEquals(-1, C01_HesapMakinesi.topla(1, -2));
        // assertEquals(3,HesapMakinesi.topla(1,12));
        // Expected :3.0 Actual   :13.0
    }

    @Test
    void carp() {
        assertEquals(2, C01_HesapMakinesi.carp(1, 2));
        assertEquals(-96, C01_HesapMakinesi.carp(-8, 12));
        assertEquals(-2, C01_HesapMakinesi.carp(1, -2));
    }
}