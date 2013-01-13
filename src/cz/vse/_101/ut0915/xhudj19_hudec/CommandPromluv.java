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
     * Vytvoří příkaz pro vykonávání rozhovorů.
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
     * Vykonává rozhovory
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return nROZHOVOR_NIKDO + status();
        }

        String result;
        ConditionManager conditionManager = ConditionManager.getInstance();
        Place currentPlace = Place.getCurrentPlace();
        String osoba = arguments[1];
        boolean success = false;

        if (currentPlace.getPerson(osoba) != null) {
            result = nROZHOVOR_START;
            if (osoba.equals("arthur")) {
                result += jARTHUR;
                if (conditionManager.canStartA()) {
                    success = true;
                    result += rozhovorA;
                    conditionManager.after_rA();
                }
                if (conditionManager.canStartC()) {
                    success = true;
                    result += rozhovorC;
                    conditionManager.after_rC();
                }
                if (conditionManager.canStartE()) {
                    success = true;
                    result += rozhovorE;
                    conditionManager.after_rE();
                }
            }
            if (osoba.equals("prosser")) {
                result += jPROSSER;
                if (conditionManager.canStartB()) {
                    success = true;
                    result += rozhovorB;
                    conditionManager.after_rB();
                }
            }
            if (osoba.equals("barman")) {
                result += jBARMAN;
                if (conditionManager.canStartD()) {
                    success = true;
                    result += rozhovorD;
                    conditionManager.after_rD();
                }

                if (conditionManager.canStartF()) {
                    success = true;
                    result += rozhovorF;
                    conditionManager.after_rF();
                }
            }
            if (!success) {
                result += nROZHOVOR_NEJDE;
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


