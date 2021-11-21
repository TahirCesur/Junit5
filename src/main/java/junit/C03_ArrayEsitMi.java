package junit;

import java.util.Arrays;

public class C03_ArrayEsitMi {

    /*
     iki array'i kiyaslayan method creat ediniz
    */

    public static boolean diziKiyasla(Object a[], Object b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }


}


