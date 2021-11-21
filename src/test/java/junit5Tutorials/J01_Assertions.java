package junit5Tutorials;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class J01_Assertions {

    @Test
    @DisplayName("ToAssert testi")
    void testToAssert() {
        int actual = "Tahir".length(); // 5
        int expected = 5;

        //1. assertEquals(); -->Eexpected ve actual degerlerinin esit olma  durumunda  test basarili --> passed
        assertEquals(expected, actual, "Beklenen ve aktuel deger esit");

        // inLine style: Her zaman kullanilmaz simple test'e aykiridir. Code cosmetic'i acisindan tavsiye edilmez.
        assertEquals(5, "Tahir".length(), "Bu yontem cok kullanilmaz");

        //2. assertNotEquals(); --> Expected ve actual degerlerinin esit olmama  durumunda  test basarili-->passed
        expected = 4;
        assertNotEquals(expected, actual, "Beklenen ve aktuel deger esit degil");

        //3. assertTrue(): --> Olusturulan sart(boolean) true ise test basarili -->passed
        expected = 5;
        assertTrue(expected == actual, "Sart saglandi true degeri verdi");

        //4. assertFalse(): --> Olusturulan sart(boolean) false ise test basarili -->passed
        expected = 5;
        assertFalse(expected != actual, "Sart saglandı false degeri verdi");
        // Esit olmadigi icin false verdi..
    }

    @Test
    @DisplayName("ToConvertUpper test")
    void testToConvertUpper() {
        String expected = "HAKAN";
        String actual = "hakan".toUpperCase();

        assertEquals(actual, expected); // passed
        assertTrue(expected.equals(actual)); // passed
        assertFalse(!actual.equals(expected)); // passed

        actual = null;
        assertNull(actual, "actual deger null degil"); // passed-->TEST: parametre null ise basarılı

        // assertNotNull(actual, "actual değer null "); // failed -->TEST: parametre notnull ise basarılı

        actual = "Kenan";
        assertNotNull(actual, "actual deger null "); // passed

    }

    @Test
    @DisplayName("ToContain testi")
    void testToContain() {

        boolean actual = "Erdem".contains("Hi"); // false
        boolean expected = false;
        assertEquals(expected, actual, "Degerler esit degil");
        // actual=false , expected=false --> actual=expected -->TEST:passed

    }

    @Test
    @DisplayName("arrays test")
    void testWithArrays() {

        String str = "junit ile ebik gabik testler";
        String actual[] = str.split(" ");
        // {"junit", "ile", "ebik", "gabik", "testler"}
        // String expected[]={"junit", "ile", "ebik", "gabik", "testler"}; // passed

        String expected[] = {"ile", "ebik", "gabik", "testler"}; // failed

        // assertArrayEquals(actual,expected, "array'ler esit degil"); // failed

    }

}