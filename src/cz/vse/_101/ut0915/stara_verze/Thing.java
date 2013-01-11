package cz.vse._101.ut0915.stara_verze;
/* Kodovani UTF-8: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import cz.vse.adv_framework.empty_classes.*;
import cz.vse.adv_framework.game_txt.IObject;



/*******************************************************************************
 * Instance třídy {@code Something} přestavují objekty v místnostech.
 * Objekty mohou být jak věci, tak i osoby či jiné skutečnosti (vůně,
 * světlo, fluidum, ...).
 * <p>
 * Některé z objektů mohou charakterizovat stav prostoru (např. je rozsvíceno),
 * jiné mohou být určeny k tomu, aby je hráč "zvednul" a získal tím nějakou
 * schopnost či možnost projít nějakým kritickým místem hry
 * (např. klíč k odemknutí dveří).
 * <p>
 * Rozhodnete-li se použít ve hře objekty, které budou obsahovat jiné objekty,
 * (truhla, stůl, ...), můžete je definovat paralelně jako zvláštní druh
 * prostoru, do kterého se "vstupuje" např. příkazem "prozkoumej truhlu"
 * a který se opouští např. příkazem "zavři truhlu".
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
public class Thing implements IObject
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Prefix určující, že předmět nepůjde zvednout. */
    public static final char HEAVY = '#';

    /** Prefix určující, že se jedná o osobu. */
    public static final char PERSON = '$';

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Název objektu. */
    private final String name;

    /** Váha objektu. U nezvednutelných objektů
     *  musí být větší než kapacita batohu. */
    private final int weight;

    /** Indikátor lisdtví. */
    private final boolean person;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

      /***************************************************************************
     * Vytvoří nový objekt se zadaným názvem
     * a vahou odvozenou od prvního znaku názvu.
     *
     * @param name   Název vytvářeného objektu
     */
    public Thing(String name)
    {
        boolean foo = false;
        switch (name.charAt(0)) {
            case PERSON:
                this.person = true;
                this.name   = name.substring(1);
                this.weight = Integer.MAX_VALUE;
                break;

            case HEAVY:
                this.person = false;
                this.name   = name.substring(1);
                this.weight = Integer.MAX_VALUE;
                break;

            default:
                this.person = false;
                this.name   = name;
                this.weight = 1;
                break;
        }
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Je objekt osobou?.
     *
     * @return Název instance
     */
    public boolean isPerson()
    {
        return person;
    }


    /***************************************************************************
     * Vrátí název dané instance.
     *
     * @return Název instance
     */
    @Override
    public String getName()
    {
        return name;
    }


    /***************************************************************************
     * Vrátí váhu objektu, resp. charakteristiku jí odpovídající.
     * Objekty, které není možno zvednout, vrací -1.
     *
     * @return Váha objektu nebo hodnota -1 charakterizující,
     *         že daný objekt není možno zvednou a umístit do batohu.
     */
    @Override
    public int getWeight()
    {
        return weight;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        Something inst = new Something();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main( String[] args )  {  test();  }
}
