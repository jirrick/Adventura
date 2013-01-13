/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;



/**
 * *****************************************************************************
 * Instances of class {@code CommandPouzij} represent ...
 *
 * @author Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandPoužij extends ACommand
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
    public CommandPoužij()
    {
        super("Použij", "Příkaz, který použije vybranou věc");

    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    @Override
    public String execute(String... arguments)
    {
        ConditionManager conditionManager = ConditionManager.getInstance();
        if (arguments.length < 2) {
            return zPŘEDMĚT_NEZADAN + status();
        }

        String objectName = arguments[1];
        Bag bag = Bag.getInstance();
        Place currentPlace = Place.getCurrentPlace();
        Thing thing = bag.getObject(objectName);
        String result;

        if (thing == null) {
            result = zNENÍ_V_BATOHU;
        }
        else {
            switch (objectName) {
                case "průvodce":
                    conditionManager.setGuideOn();
                    result = nPRŮVODCE_START;
                    break;
                case "pivo":
                    result = nPOUŽIJ_PIVO;
                    bag.remove(thing);
                    break;
                case "palec":
                    result = nPALEC;
                    currentPlace.getNeighbors().add(Place.Vogonská_loď);
                    break;
                default:
                    result = nNELZE_POUŽÍT;
                    break;
            }
        }
        return result + status();
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
//        CommandPouzij inst = new CommandPouzij();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


