package junit5Tutorials;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class J03_TestingExceptions {
    /*
    assertThrow() metodu --> belirtilen işlemin (executable) belirtilen türde bir
    Exception oluşturup oluşturmadığını test eder.
        Dolayısıyla 2 parametre alır.
        1. parametre --> expected(beklenen) Exception(istisna) türü,
        2. parametre --> actual(oluşacak)  çalıştırılacak olan işlemdir.
    Eğer işlem belirtilen türde bir exception oluşturursa test başarılı olur.TEST PASSED
    Ama exception oluşmaz ise veya türü yanlış olursa test başarısız olur.TEST FAILED
    TRİCKK : Exception.IO türünde parent-child ilişkisi var ise yine test başarılı sayılır.
    */

    @Test
    @DisplayName("NumberFormatException TEST")
    void testException1() {
        String strSayi = "1453";
        // Integer intSayi= Integer.parseInt(strSayi); // 1453
        // String strSayi="14a3"; // NumberFormatException firlatir...


        assertThrows(NumberFormatException.class, () -> Integer.parseInt("14a3")); // passed
        // assertThrows(NumberFormatException.class, ()->Integer.parseInt(strSayi)); // failed
        assertThrows(Exception.class, () -> Integer.parseInt("14a3"));// passed
        // --> Exception parent NumberFormatException child

    }

    @Test
    @DisplayName("NullPointerException TEST")
    void testException2() {
        String str = null;
        // String str ="hakan";
        // str.length();
        assertThrows(NullPointerException.class, () -> str.length()); // passed
        // assertThrows(NumberFormatException.class, () -> str.length()); // failed
        // --> farklı tür exception fırlatır

    }

    @Test
    @DisplayName("IllegalArgumentException TEST")
    void testException3() {
        assertThrows(IllegalArgumentException.class, () -> yasYazdir(-2)); // passed
    }

    void yasYazdir(int yas) {
        if (yas < 0) {
            throw new IllegalArgumentException();
        } else System.out.println(yas);

    }

    @Test
    @DisplayName("ArithmeticException TEST")
    void testException4() {
        // assertThrows(ArithmeticException.class, () ->bol(3,2)); // failed
        assertThrows(ArithmeticException.class, () -> bol(3, 0)); // passed

    }

    int bol(int a, int b) {
        return a / b;
    }
}