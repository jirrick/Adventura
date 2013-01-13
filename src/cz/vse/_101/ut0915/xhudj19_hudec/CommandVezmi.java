/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;



/**
 * *****************************************************************************
 * Instance třídy {@code CommandVezmi} představují ...
 *
 * @author jméno autora
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandVezmi extends ACommand
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
    public CommandVezmi()
    {
        super("Vezmi", "Příkaz, který vezme věc od postavy a uloží do tašky.");
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
        Bag bag = Bag.getInstance();
        Place currentPlace = Place.getCurrentPlace();

        Person person = currentPlace.getPerson(personName);
        Thing thing = person.getObject(thingName);

        if ((thing != null) && (person != null)) {
            if (thing.getWeight() > 1) {
                return zTĚŽKÝ_PŘEDMĚT + thing.getName() + status();
            }
            if (bag.add(thing)) {
                person.remove(thing);
                return String.format(
                        nVZÍT_FORMÁT, person.getName(), thing.getName()) +
                       status();
            }
            return zBATOH_PLNÝ + thing.getName() + status();
        }
        if (thing == null) {
            return nVEZMI_PŘEDMĚT_CHYBA + status();
        }
        if (person == null) {
            return nPŘEDEJ_VEZMI_OSOBA_CHYBA + status();
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
//         CommandVezmi instance = new CommandVezmi();
//     }
//     /** @param args Parametry příkazového řádku - nepoužívané. */
//     public static void main(String[] args)  {  test();  }



