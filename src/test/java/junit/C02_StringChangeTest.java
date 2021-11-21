package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class C02_StringChangeTest {
    C02_StringChange strChange = new C02_StringChange();
    // static olmayan class'dan method call etmek icin obj creat edildi

    @BeforeEach
    void setUp() {
        strChange = new C02_StringChange();
        System.out.println("Test verisi creat edildi");
    }

    @AfterEach
    void tearDown() {
        strChange = null;
        System.out.println("test verisi delete edildi");
        System.out.println("          *****          ");
    }

    @ParameterizedTest
    @CsvSource(value = {"BC,AABC", "B,AB", "BCDE,BCDE", "'',AA", "B,B"})
    void ilkIkiASil(String kirpilmis, String girdi) {
        assertEquals(kirpilmis, strChange.ilkIkiASil(girdi));

        System.out.println("Ilk ikide olan A lar silindi");
    }
}