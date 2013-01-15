/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;



/**
 * *****************************************************************************
 * Instance třídy {@code CommandPolož} představují ...
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandPolož extends ACommand
{
    //== KONSTANTNÍ ATRIBUTY TŘÍDY =============================================
    //== PROMĚNNÉ ATRIBUTY TŘÍDY ===============================================
    //== STATICKÝ INICIALIZAČNÍ BLOK - STATICKÝ KONSTRUKTOR ====================
    //== KONSTANTNÍ ATRIBUTY INSTANCÍ ==========================================
    //== PROMĚNNÉ ATRIBUTY INSTANCÍ ============================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ TŘÍDY ====================================
    //== OSTATNÍ NESOUKROMÉ METODY TŘÍDY =======================================
    //##########################################################################
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    /**
     * *************************************************************************
     *
     */
    public CommandPolož()
    {
        super("Polož", "Příkaz, který položí do prostoru věc z tašky");
    }


    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return zPŘEDMĚT_NEZADAN + status();
        }
        String thingName = arguments[1];

        Bag bag = Bag.getInstance();
        Place currentPlace = Place.getCurrentPlace();

        Thing thing = bag.getObject(thingName);
        if (thing == null) {
            return zNENÍ_V_BATOHU + thingName + status();
        }
        else {
            currentPlace.add(thing);
            bag.remove(thing);
            return zPOLOŽENO + thing.getName() + status();
        }

    }


}



//== SOUKROMÉ A POMOCNÉ METODY TŘÍDY =======================================
//== SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
//== INTERNÍ DATOVÉ TYPY ===================================================
//== TESTOVACÍ METODY A TŘÍDY ==============================================
//
//     /********************************************************************
//      * Testovací metoda.
//      */
//     public static void test()
//     {
//         CommandPolož instance = new CommandPolož();
//     }
//     /** @param args Parametry příkazového řádku - nepoužívané. */
//     public static void main(String[] args)  {  test();  }



