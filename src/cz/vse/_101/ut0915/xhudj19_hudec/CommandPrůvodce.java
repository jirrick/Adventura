/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;



/**
 * *****************************************************************************
 * Instances of class {@code CommandPrůvodce} represent ...
 *
 * @author Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandPrůvodce extends ACommand
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
     *
     */
    public CommandPrůvodce()
    {
        super("Pomocný příkaz, který by neměl jít přímo spustit",
              "Pomocný příkaz, který by neměl jít přímo spustit");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    public String execute(String... arguments)
    {
        ConditionManager CM = ConditionManager.getInstance();
        String result = "";
        if (arguments.length > 0) {
            String objectName = arguments[0];
            switch (objectName) {
                case "ručník":
                    result = nPRŮVODCE_RUČNÍK;
                    break;
                case ".":
                    CM.setGuideOff();
                    result = nPRŮVODCE_STOP;
                    break;
                default:
                    result = nPRŮVODCE_UNKNOWN;
                    break;
            }
        } 
        return result;
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
//        HelpCommandAno inst = new HelpCommandAno();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


