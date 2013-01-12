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

        String result = "";
        ConditionManager CM = ConditionManager.getInstance();
        Place currentPlace = Place.getCurrentPlace();
        String osoba = arguments[1];
        boolean success = false;

        if (currentPlace.getObject(osoba) != null) {
            result = nROZHOVOR_START;
            if (osoba.equals("arthur")) {
                result += jARTHUR;
                if (CM.get_rA()) {
                    success = true;
                    result += rA;
                    CM.evaluate_rA();
                }
                if (CM.get_rC()) {
                    success = true;
                    result += rC;
                    CM.evaluate_rC();
                }
                if (CM.get_rE()) {
                    success = true;
                    result += rE;
                    CM.evaluate_rE();
                }
            }
            if (osoba.equals("prosser")) {
                result += jPROSSER;
                if (CM.get_rB()) {
                    success = true;
                    result += rB;
                    CM.evaluate_rB();
                }
            }
            if (osoba.equals("barman")) {
                result += jBARMAN;
                if (CM.get_rD()) {
                    success = true;
                    result += rD;
                    CM.evaluate_rD();
                }

                if (CM.get_rF()) {
                    success = true;
                    result += rF;
                    CM.evaluate_rF();
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


