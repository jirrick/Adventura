/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.*;
import cz.vse.adv_framework.game_txt.INamed;
import java.util.ArrayList;
import java.util.Collection;



/**
 * *****************************************************************************
 * Instances of class {@code Person} represent ...
 *
 * @author Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class Person implements INamed
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES ================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /**
     * Název osoby.
     */
    private final String name;

    /**
     * Předměty vlastněné danou osobou.
     */
    private final Collection<Thing> objects = new ArrayList<>();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /**
     * *************************************************************************
     * Vytvoří novou osobu se zadaným názvem
     * a vahou odvozenou od prvního znaku názvu.
     *
     * @param name Název vytvářené osoby
     */
    public Person(String name)
    {
        this.name = name.substring(1);
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================


    /**
     * *************************************************************************
     * Vrátí název dané instance.
     *
     * @return Název instance
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     * *************************************************************************
     * Vloží osobě předmět do inventáře
     *
     * @param thing vkládaný předmět
     */
    public void add(Thing thing)
    {
        objects.add(thing);
    }

    /**
     * *************************************************************************
     * Odebere osobě předmět z inventáře
     *
     * @param thing odebíraný předmět
     */
    public void remove(Thing thing)
    {
        objects.remove(thing);
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
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
//        Person inst = new Person();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


