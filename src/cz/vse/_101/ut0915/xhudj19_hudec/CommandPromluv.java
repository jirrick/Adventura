package cz.vse._101.ut0915.xhudj19_hudec;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;



/**
 * *****************************************************************************
 * Instance třídy {@code CommandNastraz} představují ...
 *
 * @author jméno autora
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandPromluv extends ACommand
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
     * ***********************************************************************
     * Vytvoří příkaz nastražující pastičku.
     */
    public CommandPromluv()
    {
        super("promluv",
              "Pokusí se o rozhovor s danou postavou");
    }


    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    /**
     * ***********************************************************************
     * Instance třídy CommandNastraz představují příkazy realizující
     * nastražení pastičky. Pokud je v místnosti myš a v rukou pastička,
     * vyndá z rukou pastičku a vloží do nich myš a to samé i v místnosti.
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return nROZHOVOR_NIKDO + status();
        }

        String result = "";
        ConditionManager CM = ConditionManager.getInstance();
        Place currentPlace = Place.getCurrentPlace();
        String osoba = arguments[1];

        if (currentPlace.getObject(osoba) != null) {
            result = nROZHOVOR_NEJDE;

            if (CM.get_rA() && (osoba.equals("arthur"))) {
                result = rA;
                CM.evaluate_rA();
            }
            if (CM.get_rB() && (osoba.equals("prosser"))) {
                result = rB;
                CM.evaluate_rB();
            }
            if (CM.get_rC() && (osoba.equals("arthur"))) {
                result = rC;
                CM.evaluate_rC();
            }
            if (CM.get_rD() && (osoba.equals("barman"))) {
                result = rD;
                CM.evaluate_rD();
            }
            if (CM.get_rE() && (osoba.equals("arthur"))) {
                result = rE;
                CM.evaluate_rE();
            }
            if (CM.get_rF() && (osoba.equals("barman"))) {
                result = rF;
                CM.evaluate_rF();
            }
        }
        else {
            result = nROZHOVOR_NENÍ;
        }
        return result + status();
    }


//    == SOUKROMÉ A POMOCNÉ METODY TŘÍDY =======================================
//    == SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
//    == INTERNÍ DATOVÉ TYPY ===================================================
//    == TESTOVACÍ METODY A TŘÍDY ==============================================
//
//         /********************************************************************
//          * Testovací metoda.
//          */
//         public static void test()
//         {
//             CommandNastraz instance = new CommandNastraz();
//         }
//         /** @param args Parametry příkazového řádku - nepoužívané. */
//         public static void main(String[] args)  {  test();  }
}


