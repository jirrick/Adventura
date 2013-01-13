/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;



/**
 * *****************************************************************************
 * Instance třídy {@code CommandJdi} představují příkazy
 * realizující standardní přesun.
 * Instance by mohla být definována jako jedináček,
 * ale v dané aplikaci svěřuje tuto starost do ruhou správce příkazů.
 *
 * @author Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandJdi extends ACommand
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /**
     * *************************************************************************
     * Vytvoří příkaz přesouvající hráče z aktuálního prostoru
     * do prostoru zadaného, přičemž zadaný prostor musí být
     * v danou chvíli sousedem prostoru aktuálního.
     */
    public CommandJdi()
    {
        super("Jdi", "Přesune hráče z aktuální prostoru " +
                     "do zadaného sousedního prostoru,");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * *************************************************************************
     * Metoda realizující standardní přesun do sousedního prostoru.
     * V parametru by měly být dvě položky: název příkazu
     * a název cílového prostoru.
     *
     * @param arguments Parametry příkazu - název příkazu a cílového prostoru
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        ConditionManager CM = ConditionManager.getInstance();
        if (arguments.length < 2) {
            return zCÍL_NEZADÁN + status();
        }
        String destName = arguments[1];
        Place currentPlace = Place.getCurrentPlace();

        Place neighbor = currentPlace.getNeighbor(destName);
        if (neighbor != null) {
           if (CM.getArthurFollows()) {
                Person arthur = currentPlace.getPerson("arthur");
                if (arthur != null) {
                    currentPlace.remove(arthur);
                    neighbor.add(arthur);
                }
            }
            Place.setCurrentPlace(neighbor);
            if (destName.equalsIgnoreCase(mVOGONI)){
                Game.getInstance().stop();
                return zPŘESUN +
                   neighbor.getName() + nVÝHRA;
            }
            return zPŘESUN +
                   neighbor.getName() + status();

        }
        return zNENÍ_CIL + destName + status();
    }


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        CommandJdi inst = new CommandJdi();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


