/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;
import java.util.Date;
import java.util.EnumMap;



/**
 * *****************************************************************************
 * Instance třídy {@code ConditionManager} udržuje a vyhodnocuje podmínky
 * pro vykonávání akcí ve hře.
 * Hra, jakožto knižní adaptace, vyžaduje dodržení striktního postupu, což
 * vyžaduje velké množství podmínek. Pro zvýšení přehlednosti jsou proto
 * odděleny od hlavní herní logiky.
 *
 * @author Jiří HUDEC
 * @version 0.01.000
 */
public final class ConditionManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================
    /**
     * Jediná instance manažeru.
     */
    private static final ConditionManager condMan =
                                          new ConditionManager();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /**
     * Délka časovače do zničení země v sekundách
     */
    final static int END_OF_EARTH_TIMER = 120;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
    private EnumMap<Condition, Boolean> conditions = new EnumMap<>(
            Condition.class);

    /**
     * Indikátor, zda hráč ještě může zadávat příkazy
     */
    private boolean canDoNextMove = true;

    /**
     * Počet tahů do konce světa
     */
    private int roundsLeft = 15;

    /**
     * Reálný čas, kdy byl spuštěn odpočet konce světa
     */
    private Date timeOfActivation;


    //== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /**
     * *************************************************************************
     * Vrátí odkaz na jedináčka - jedinou existující instanci třídy.
     *
     * @return Odkaz na jedináčka
     */
    public static ConditionManager getInstance()
    {
        return condMan;
    }


    /**
     * *************************************************************************
     * Vytvoří instanci jedináčka.
     */
    private ConditionManager()
    {
        initialize();
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
    /**
     * *************************************************************************
     * Indikátor, zda se může vykonat další krok hry.
     *
     * @return Pokud se může vykonat další krok vrátí {@code true},
     *         jinak {@code false}
     */
    public boolean getCanDoNextMove()
    {
        return canDoNextMove;
    }


    /**
     * *************************************************************************
     * Vrátí hodnotu požadováné podmínky
     *
     * @return pravdivost požadované podmínky
     */
    public boolean get(Condition condition)
    {
        return conditions.get(condition);
    }


    /**
     * *************************************************************************
     * Nastaví hodnotu požadováné podmínky
     *
     * @param condition název nastavované podmínky
     * @param value     hodnota nastavované podmínky
     */
    public void set(Condition condition, boolean value)
    {
        conditions.put(condition, value);
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * *************************************************************************
     * Vyhodnocení podmínek po zadání dalšího příkazu.
     * Výsledek lze získat getterem {@code canDoNextMove()}.
     *
     */
    public void evaluateNextRound()
    {
        canDoNextMove = !evaluateEarthDestruction();
    }


    /**
     * *************************************************************************
     * Spustí odpočet reálného času do konce světa.
     *
     */
    public void startEndOfEarthTime()
    {
        set(Condition.TIMER_RUNNING, Boolean.TRUE);
        timeOfActivation = new Date();
    }


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
    /**
     * *************************************************************************
     * Vyhodnotí, zda země byla zničena.
     *
     * @return Vrací {@code true} pokud země byla zničena,
     *         {@code false} pokud ještě ne.
     */
    private boolean evaluateEarthDestruction()
    {
        // konec země počítadlem příkazů
        if (get(Condition.TURN_COUNTDOWN_RUNNING)) {
            if (roundsLeft >= 1) {
                roundsLeft--;
            }
            else {
                return true;
            }
        }
        //konec země časovačem
        if (earthDestroyedByTimer()) {
            return true;
        }

        return false;
    }


    private void initialize()
    {
        for (Condition condition : Condition.values()) {
            conditions.put(condition, Boolean.FALSE);
        }
        conditions.put(Condition.DIALOG_A_POSSIBLE, Boolean.TRUE);
    }


    /**
     * *************************************************************************
     * Časovač zničení země
     *
     * @return Vrací {@code true} pokud země byla zničena časovačem,
     *         {@code false} pokud časovač ještě nebyl spuštěn anebo
     *         země ještě nebyla zničena.
     */
    private boolean earthDestroyedByTimer()
    {
        boolean result = false;
        if (get(Condition.TIMER_RUNNING)) {
            // počet sekund od zapnutí časovače
            int secondsDiff = (int) Math.
                    abs((new Date().getTime() / 1000) -
                        (timeOfActivation.getTime() / 1000));
            if (secondsDiff > END_OF_EARTH_TIMER) {
                result = true; //země byla zničena
            }
            else {
                result = false; //země ještě nebyla zničena
            }
        }
        return result;
    }

//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        GameRUP inst = new GameRUP();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}


