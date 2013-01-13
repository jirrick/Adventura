/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import java.util.Date;



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
    private static final ConditionManager conditionManager = new ConditionManager();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /**
     * Délka časovače do zničení země v sekundách
     */
    final static int END_OF_EARTH_TIMER = 120;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
    /**
     * Indikátor, zda hráč ještě může zadávat příkazy
     */
    private boolean canDoNextMove = true;

    /**
     * Indikátor odpočítávání počtu zadaných příkazů do konce světa
     */
    private boolean endOfEarthRound = false;

    /**
     * Počet tahů do konce světa
     */
    private int roundsLeft = 15;

    /**
     * Indikátor odpočítávání zbývajícího reálného času do konce světa
     */
    private boolean endOfEarthTime = false;

    /**
     * Reálný čas, kdy byl spuštěn odpočet konce světa
     */
    private Date timeOfActivation;

    /**
     * Indikátor, zda Artur následuje Forda
     */
    private boolean arthurFollows = false;

    /**
     * Indikátor, zda je aktivní režim průvodce
     */
    private boolean guideActive = false;

    /**
     * Indikátor, zda se může spustit rozhovor A
     */
    private boolean rA = true;

    /**
     * Indikátor, zda se může spustit rozhovor B
     */
    private boolean rB = false;

    /**
     * Indikátor, zda se může spustit rozhovor C
     */
    private boolean rC = false;

    /**
     * Indikátor, zda se může spustit rozhovor D
     */
    private boolean rD = false;

    /**
     * Indikátor, zda se může spustit rozhovor E
     */
    private boolean rE = false;

    /**
     * Indikátor, zda se může spustit rozhovor E
     */
    private boolean rF = false;

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
        return conditionManager;
    }


    /**
     * *************************************************************************
     * Vytvoří instanci jedináčka.
     */
    private ConditionManager()
    {
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
     * Indikátor, zda Artur následuje Forda při pohybu ve hře
     *
     * @return Vrací {@code true} pokud Artur Forda sleduje, jinak {@code false}
     */
    public boolean getArthurFollows()
    {
        return arthurFollows;
    }


    /**
     * *************************************************************************
     * Indikátor, zda je hra v režimu Průvodce galaxií
     *
     * @return Vrací {@code true} pokud je v režimu průvodce, jinak
     *         {@code false}
     */
    public boolean getGuideActive()
    {
        return guideActive;
    }


    /**
     * *************************************************************************
     * Může se spustit rozhovor A?
     *
     * @return Vrátí {@code true} pokud se může rozhovor spustit, jinak
     *         {@code false}
     */
    public boolean canStartA()
    {
        return rA;
    }


    /**
     * *************************************************************************
     * Může se spustit rozhovor B?
     *
     * @return Vrátí {@code true} pokud se může rozhovor spustit, jinak
     *         {@code false}
     */
    public boolean canStartB()
    {
        return rB;
    }


    /**
     * *************************************************************************
     * Může se spustit rozhovor C?
     *
     * @return Vrátí {@code true} pokud se může rozhovor spustit, jinak
     *         {@code false}
     */
    public boolean canStartC()
    {
        return rC;
    }


    /**
     * *************************************************************************
     * Může se spustit rozhovor D?
     *
     * @return Vrátí {@code true} pokud se může rozhovor spustit, jinak
     *         {@code false}
     */
    public boolean canStartD()
    {
        return rD;
    }


    /**
     * *************************************************************************
     * Může se spustit rozhovor E?
     *
     * @return Vrátí {@code true} pokud se může rozhovor spustit, jinak
     *         {@code false}
     */
    public boolean canStartE()
    {
        return rE;
    }


    /**
     * *************************************************************************
     * Může se spustit rozhovor F?
     *
     * @return Vrátí {@code true} pokud se může rozhovor spustit, jinak
     *         {@code false}
     */
    public boolean canStartF()
    {
        return rF;
    }


    /**
     * *************************************************************************
     *
     *
     * @return {@code true}, jinak {@code false}
     */
    public boolean get()
    {
        return true;
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
     * Spustí odpočet vykonatelných tahů do konce světa.
     *
     */
    public void startEndOfEarthRound()
    {
        endOfEarthRound = true;
    }


    /**
     * *************************************************************************
     * Spustí odpočet reálného času do konce světa.
     *
     */
    public void startEndOfEarthTime()
    {
        endOfEarthTime = true;
        timeOfActivation = new Date();
    }


    /**
     * *************************************************************************
     * Artur začne následovat Forda při pohybu ve hře.
     *
     */
    public void setArthurFollow()
    {
        arthurFollows = true;
    }


    /**
     * *************************************************************************
     * Artur zůstane v aktuální prostoru.
     *
     */
    public void setArthurStop()
    {
        arthurFollows = false;
    }


    /**
     * *************************************************************************
     * Hra se přepne do režimu procházení průvodce.
     *
     */
    public void setGuideOn()
    {
        guideActive = true;
    }


    /**
     * *************************************************************************
     * hra se přepne do normálního režimu.
     *
     */
    public void setGuideOff()
    {
        guideActive = false;
    }


    /**
     * *************************************************************************
     * Vyhodnocení podmínek po rozhovoru A.
     *
     */
    public void after_rA()
    {
        if (rA) {
            rA = false;
            rB = true;
        }
    }


    /**
     * *************************************************************************
     * Vyhodnocení podmínek po rozhovoru B.
     *
     */
    public void after_rB()
    {
        if (rB) {
            rB = false;
            rC = true;
        }
    }


    /**
     * *************************************************************************
     * Vyhodnocení podmínek po rozhovoru C.
     *
     */
    public void after_rC()
    {
        if (rC) {
            rC = false;
            rD = true;
            setArthurFollow();
        }
    }


    /**
     * *************************************************************************
     * Vyhodnocení podmínek po rozhovoru D.
     *
     */
    public void after_rD()
    {
        if (rD) {
            rD = false;
            rE = true;
            Place.getCurrentPlace().getPerson("barman").add(new Thing("Pivo"));
            Place.getCurrentPlace().getPerson("barman").add(new Thing("Pivo"));
        }
    }


    /**
     * *************************************************************************
     * Vyhodnocení podmínek po rozhovoru E.
     *
     */
    public void after_rE()
    {
        if (rE) {
            rE = false;
            rF = true;
            Place.getCurrentPlace().getPerson("barman").
                    add(new Thing("Buráky"));
            Place.getCurrentPlace().getPerson("arthur").remove(
                    Place.getCurrentPlace().getPerson("arthur").
                    getObject("Pivo"));
        }
    }


    /**
     * *************************************************************************
     * Vyhodnocení podmínek po rozhovoru F.
     *
     */
    public void after_rF()
    {
        if (rF) {
            rF = false;
        }
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
        boolean result = false;
        // konec země počítadlem příkazů
        if (endOfEarthRound) {
            if (roundsLeft >= 1) {
                roundsLeft--;
            }
            else {
                result = true;
            }
            //konec země časovačem
            if (endOfEarthTime && earthDestroyedByTimer()) {
                result = true;
            }
        }
        return result;
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
        if (endOfEarthTime) {
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


