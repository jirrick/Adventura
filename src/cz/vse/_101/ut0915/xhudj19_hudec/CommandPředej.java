/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;



/**
 * *****************************************************************************
 * Instance třídy {@code CommandPolož} představují ...
 *
 * @author jméno autora
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandPředej extends ACommand
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
    public CommandPředej()
    {
        super("Předej", "Příkaz, který předá věc z tašky určené postavě.");
    }


    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 3) {
            return nPŘEDMĚT_NEBO_OSOBA_NEZADÁNA + status();
        }

        String thingName = arguments[1];
        String personName = arguments[2];
        Bag BAG = Bag.getInstance();
        Place currentPlace = Place.getCurrentPlace();

        Thing thing = BAG.getObject(thingName);
        Person person = currentPlace.getPerson(personName);
        if ((thing != null) && (person != null)) {
            person.add(thing);
            BAG.remove(thing);
            return String.format(
                    nPŘEDAT_FORMÁT, person.getName(), thing.getName()) +
                   status();
        }
        if (thing == null) {
            return nPŘEDEJ_PŘEDMĚT_CHYBA + status();
        }
        if (person == null) {
            return nPŘEDEJ_OSOBA_CHYBA + status();
        }
        return zZANP + status();
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



