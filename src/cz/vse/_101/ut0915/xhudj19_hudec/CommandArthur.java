/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;

/*******************************************************************************
 * Instances of class {@code CommandArthur} represent ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandArthur extends ACommand
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

    /***************************************************************************
     *
     */
    public CommandArthur()
    {
        super("Arthur", "Příkaz pro jednoduché ovládání Arthura");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
      @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return nARTH_NENÍ_PŘÍIKAZ + status();
        }

        ConditionManager conditionManager = ConditionManager.getInstance();
        String command = arguments[1];
        String result;
        Person arthur = Place.getCurrentPlace().getPerson(jARTHUR);

        if (arthur == null){
            result = nARTHUR_NELZE;
        } else {
            switch (command) {
                case "inventář":
                    result = nARTH_INVENT +
                             toCommaSeparatedString(arthur.getObjects());
                    break;
                case "následuj":
                    result = nARTHUR_SLEDUJE;
                    conditionManager.setArthurFollow();
                    break;
                case "stůj":
                    result = nARTHUR_STŮJ;
                    conditionManager.setArthurStop();
                    break;
                default:
                    result = nART_NEZNÁM_PŘÍIKAZ;
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
//        CommandArthur inst = new CommandArthur();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
