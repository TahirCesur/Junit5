package junit5Tutorials;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class J05_RepeatedDisableTest {
    /*
    @RepeatedTest(a) --> test edilecek method a kadar dongu icinde test edilir
    junit 5 ile yeni gelmistir.
    */

    @AfterEach
    void afterEachTest() {
        System.out.println("After calisti");
        System.out.println("    *****    ");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before calisti");
    }

    @RepeatedTest(7)
    @DisplayName("Contains method 7 kez test edildi")
    void continesTest() {
        assertFalse("Erdem".contains("hi"));
        System.out.println("Contains method calisti");
    }

    @RepeatedTest(5)
    @DisplayName("Topla method 5 kez test edildi")
    void toplaTest() {
        assertEquals(5, (2 + 3));
        System.out.println("Topla method calisti");
    }

    @Disabled("Ham karpuz bicak vurmayin...")
    @Test
    void karpuzTest() {
        String karpuz = "Adana karpuzu, guldurur yuzu";
        assertEquals(28, karpuz.length());
    }
}
