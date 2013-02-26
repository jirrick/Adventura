/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



/*******************************************************************************
 * Třída {@code Run} je knihovní třídou poskytující metodu {@code test},
 * která provede všechny testy, jejichž názvy obdrží v parametrech.
 * Metoda slouží k tomu, aby se v průběhu vývoje dalo co nejsnadněji definovat,
 * které testy se budou a nebudou spouštět - stačí jenom zakomentovat řádky
 * s názvy nespouštěných testů.
 * <p>
 * Abychom se nemuseli při zakomentovávání neprováděných testů zabývat tím,
 * zda právě nezakomentováváme poslední test, za nímž (na rozdíl od ostatních)
 * již není čárka, můžeme zako poslední název zadat prázdný řetězec,
 * který pak bude metoda ignorovat.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version X
 */
public class JUnit
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    private static String currentTestName;



//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================

    /***************************************************************************
     * Vrátí název aktuálně spuštěného testu.
     *
     * @return Název aktuálně spuštěného testu
     */
    public static String getCurrentTestName()
    {
        return currentTestName;
    }



//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Postupně spustí každý ze zadaných testů přičemž po jeho skončení
     * toto oznámí v dialogovém okně a uklidí po něm plátno.
     * Slouží k tomu, aby se v průběhu vývoje dalo co nejsnadněji definovat,
     * které testy se budou a nebudou spouštět - stačí jenom zakomentovat řádky
     * s názvy nespouštěných testů.
     * <p>
     * Abychom se nemuseli při zakomentovávání neprováděných testů zabývat tím,
     * zda právě nezakomentováváme poslední test,
     * za nímž (na rozdíl od ostatních) již není čárka,
     * můžeme jako poslední název zadat prázdný řetězec,
     * který pak bude metoda ignorovat.
     * <b>Obecně metoda ignoruje všechny názvy následující
     * za případným prázdným řetězcem.</b>
     *
     * @param klass      Testovací třída, jejíž testy budeme spouštět
     * @param testNames  Názvy spouštěných testů
     */
    public static void test(Class<?> klass, String... testNames)
    {
        JUnitCore jUnitCore = new JUnitCore();
        String className = klass.getSimpleName();
        for (String name : testNames) {
            if (name.isEmpty()) {
                return;
            }
            currentTestName = className + " . " + name;
            Description dsc = Description.createTestDescription(klass, name);
            Request request = Request.aClass(klass).filterWith(dsc);
            Result   result = jUnitCore.run(request);
            if (result.wasSuccessful()) {
                IO.zpráva(dsc + "\n\nTest úspěšný");
            }
            else {
                StringBuilder sb = new StringBuilder("Test se nezdařil\n");
                sb.append(dsc);
                List<Failure> failures = result.getFailures();
                for (Failure failure : failures) {
                    sb.append(failure);
                }
                System.out.println(sb);
                IO.zpráva(sb);
            }
        }
        currentTestName = null;
    }



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    private JUnit()
    {
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================

    /***************************************************************************
     * Instance třídy {@code Run.TD} (TD od {@code tearDown})
     * zabezpečí úklid mezi testy, který není možno zakomponovat do metody
     * {@code tearDown()}, dokud nebudou studenti umět programovat.
     */
    public static interface ITD
    {
        /***********************************************************************
         * Uklidí po testu tak, aby mohl ihned odstartovat další test.
         */
        public void tearDown();
    }



//== TESTING CLASSES AND METHODS ===============================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        SpuštěníTestů inst = new SpuštěníTestů();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
