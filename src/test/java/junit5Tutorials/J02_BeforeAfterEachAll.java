package junit5Tutorials;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class J02_BeforeAfterEachAll {

    /* =========================================== @BeforeEach - @AfterEach ==================================

   A-) @BeforeEach anatosyonu kullanılan bir method, her test methodu çalışmadan önce çalıştırılır.
       Bu özelliği sayesinde test verilerinin ayarlanması (başlatılması) için kullanılabilir.
       Araç --> her vites'te debriyaja basma   Namaz --> her rekatın Fatiha'sı

   B-) @AfterEach anatosyonu kullanılan bir method, her test metodu bittikten sonra çalıştırılır.
       Bu özelliği sayesinde test verilerinin temizlenmesi için kullanılabilir.
       Araç --> her vites'te debriyajdan ayagı cekme   Namaz --> her rekatın ayaga kalkma'sı

   C-) JUnit4 de bu anatosyonlar yerine @Before ve @After kullanıyordu.

   D-) AHAN DA TRİCKKK:  @AfterEach veya @BeforeEach anotasyonunda yazım sırası önemli değildir.
       Hangisi önce önce yazılırsa yazılsın JAVA önce @BeforeEach sonra @AfterEach compile eder.

        ========================================== @BeforeAll - @AfterAll ==================================
	 A-) @BeforeALl tüm test methodlarından önce çalışan bir method oluşturmak için kullanılır.
         Dolayısıyla veritabanı içeren bir test işleminde ilk olarak veritabanına bağlanmak gerekeceğinden
         @BeforeAll anatosyonu ile bir method tanımlanarak ilk olarak veritabanına b
         ağlanma prosedürü işletilebilir.
         Araç --> kontagı acma   Namaz --> Namazın tekbiri...


	 B-) @AfterAll ile tüm test metotlari bittikten sonra çalışan bir metot olusturulabilir.
         Bu özelliği sayesinde testler bittikten sonra veritabani oturumu kapatilabilir.
         Araç --> kontagı kapatma   Namaz --> Namazın selamı...

	     AHAN DA TRİCKKK: @BeforeAll ve @AfterAll anotasyonlarının kullanıldığı metotlar static olmalıdır.
	     Not2: JUnit4 de @BeforeClass ve  @AfterClass metotları kulanılmaktadır.

     */

    @AfterAll
    static void veritabaniBaglantiKapat() {
        System.out.println("@AfterAll --> Veritabani baglantisi kapatildi (NAMAZ SELAMI VERILDI)");

    }

    @BeforeAll
    static void veritabaniBaglantiKur() {

        System.out.println("@BeforeAll --> Veritabani baglantisi kuruldu (NAMAZ TEKBIRI ALINDI)");
    }

    @AfterEach
    void clean(TestInfo bilgi) { // TestInfo-->@DisplayName; anotasyonundaki veriyi return eder.
        str = "";
        System.out.println("@AfterEach --> Clean method run edildi (HER REKAT ICIN AYAGA KALKILDI) "
                + bilgi.getDisplayName());
    }

    @BeforeEach
    void setUp(TestInfo bilgi) { // TestInfo-->@DisplayName; anotasyonundaki veriyi return eder.
        str = "javaCAN'lara selam olsun";
        System.out.println("@BeforeEach --> setUp method run edildi (HER REKAT ICIN FATIHA OKUNDU) "
                + bilgi.getDisplayName());

    }

    String str = ""; // global veriable

    @Test
    @DisplayName("Lenght method test")
    void testStringLength() {

        int actual = str.length();
        int expected = 24;
        assertEquals(expected, actual, "Degerler Esit degil");
        System.out.println("TEST 1 --> Lenght method run edildi");
    }

    @Test
    @DisplayName("arrays test")
    void testWithArrays() {

        String actual[] = str.split(" ");

        String expected[] = {"javaCAN'lara", "selam", "olsun"};

        assertArrayEquals(actual, expected, "Array ler esit degil");
        System.out.println("TEST 2 --> Arrays method run edildi");

    }
}