/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import java.util.Date;



/*******************************************************************************
 * Instance třídy {@code ConditionManager} udržuje a vyhodnocuje podmínky
 * pro vykonávání akcí ve hře.
 * Hra, jakožto knižní adaptace, vyžaduje dodržení striktního postupu, což
 * vyžaduje velké množství podmínek. Pro zvýšení přehlednosti jsou proto
 * odděleny od hlavní herní logiky.
 *
 * @author    Jiří HUDEC
 * @version   0.01.000
 */
public class ConditionManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Jediná instance manažeru. */
    private static final ConditionManager CM = new ConditionManager();



//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /** Délka časovače do zničení země v sekundách  */
    int END_OF_EARTH_TIMER_DURATION = 120;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** Indikátor, zda hráč ještě může zadávat příkazy */
    private boolean canDoNextMove = true;

    /** Indikátor odpočítávání počtu zadaných příkazů do konce světa*/
    private boolean endOfEarthRoundCountdown = false;
    /** Počet tahů do konce světa */
    private int roundsLeft = 15;
    /** Indikátor odpočítávání zbývajícího reálného času do konce světa */
    private boolean endOfEarthTimeCountdown = false;
    /** Počet tahů do konce světa */
    private Date timeOfActivation;

    /** Indikátor, zda Artur následuje Forda */
    private boolean arthurFollows = false;


//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vrátí odkaz na jedináčka - jedinou existující instanci třídy.
     *
     * @return Odkaz na jedináčka
     */
    public static ConditionManager getInstance()
    {
        return CM;
    }


    /***************************************************************************
     * Vytvoří instanci jedináčka.
     */
    private ConditionManager()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
     /***************************************************************************
     * Indikátor, zda se může vykonat další krok hry.
     *
     * @return Pokud se může vykonat další krok vrátí {@code true},
     * jinak {@code false}
     */
    public boolean getCanDoNextMove()
    {
        return canDoNextMove;
    }


     /***************************************************************************
     * Indikátor, zda Artur následuje Forda při pohybu ve hře
     *
     * @return Vrací {@code true} pokud Artur Forda sleduje, jinak {@code false}
     */
    public boolean getArthurFollows()
    {
        return arthurFollows;
    }

    /***************************************************************************
     *
     *
     * @return {@code true}, jinak {@code false}
     */
    public boolean get()
    {
        return true;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Vyhodnocení podmínek po zadání dalšího příkazu.
     * Výsledek lze získat getterem {@code canDoNextMove()}.
     *
     */
    public void triggerNextRound()
    {
        canDoNextMove = !EvaluateEarthDestruction();
    }

    /***************************************************************************
     * Spustí odpočet vykonatelných tahů do konce světa.
     *
     */
    public void triggerEndOfEarthRound()
    {
        endOfEarthRoundCountdown = true;
    }

    /***************************************************************************
     * Spustí odpočet reálného času do konce světa.
     *
     */
    public void triggerEndOfEarthTime()
    {
        endOfEarthTimeCountdown = true;
        timeOfActivation = new Date();
    }

     /***************************************************************************
     * Artur začne následovat Forda při pohybu ve hře.
     *
     */
    public void triggerArthurFollow()
    {
        arthurFollows = true;
    }

     /***************************************************************************
     * Artur zůstane v aktuální prostoru.
     *
     */
    public void triggerArthurStop()
    {
        arthurFollows = false;
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
   /***************************************************************************
     * Vyhodnotí, zda země byla zničena.
     *
     * @return Vrací {@code true} pokud země byla zničena,
     * {@code false} pokud ještě ne.
     */
    private boolean EvaluateEarthDestruction(){
        boolean result = false;
        // konec země počítadlem příkazů
        if (endOfEarthRoundCountdown) {
            if (roundsLeft >= 1) {
                roundsLeft--;
            } else {
                result = true;
            }
            //konec země časovačem
            if (endOfEarthTimeCountdown) {
                if (EarthDestroyedByTimer()) {
                    result = true;
                }
            }
        }
        return result;
    }



    /***************************************************************************
     * Časovač zničení země
     *
     * @return Vrací {@code true} pokud země byla zničena časovačem,
     * {@code false} pokud časovač ještě nebyl spuštěn anebo
     * země ještě nebyla zničena.
     */
    private boolean EarthDestroyedByTimer(){
        boolean result = false;
        if (endOfEarthTimeCountdown) {
            // počet sekund od zapnutí časovače
            int secondsDiff = (int) Math.abs((new Date().getTime()/1000) -
                                  (timeOfActivation.getTime()/1000));
            if (secondsDiff > END_OF_EARTH_TIMER_DURATION) {
                result = true; //země byla zničena
            } else {
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
