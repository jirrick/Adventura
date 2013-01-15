/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xhudj19_hudec;

import static cz.vse._101.ut0915.xhudj19_hudec.Texts.PERSON;
import cz.vse.adv_framework.game_txt.INamed;
import java.util.ArrayList;
import java.util.Collection;



/**
 * *****************************************************************************
 * Instances of class {@code Person} represent ...
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class Person implements INamed
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES ================================================
    private static Person arthur = null;

    private static Person barman = null;

//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    private ArrayList<Integer> dialogues = new ArrayList<>();

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

    public static Person getArthur()
    {
        return arthur;
    }


    public static Person getBarman()
    {
        return barman;
    }

//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    public static void findArthurBarman()
    {
        for (Place place : Place.values()) {
            Person temp;
            temp = place.getPerson("Arthur");
            if (temp != null) {
                arthur = temp;
            }

            temp = place.getPerson("Barman");
            if (temp != null) {
                barman = temp;
            }
        }
    }

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
        String[] input = name.split((String.valueOf(PERSON)));
        if (input.length > 2) {
            // input[0] by mělo být prázdné
            this.name = input[1];
            char[] dialog = input[2].toCharArray();
            for (char d : dialog) {
                if ((d >= '0') && (d <= '9')) {
                    dialogues.add(Character.getNumericValue(d));
                }
            }
        }
        else {
            this.name = name.substring(1);
        }
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
     * Vrátí kolekci možných rozhovorů.
     *
     * @return Kolekce možných rozhovorů
     */
    public Collection<Integer> getDialogues()
    {
        return dialogues;
    }


    /**
     * *************************************************************************
     * Vrátí kolekci objektů nacházejících se v inventáři postavy.
     *
     * @return Kolekce objektů nacházejících se v inventáři postavy
     */
    public Collection<Thing> getObjects()
    {
        return objects;
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


    /**
     * *************************************************************************
     * Vybere oředmět z inventáře dané osoby
     *
     * @param requestedObject vybraný předmět
     * @return instance vybraného předmětu
     */
    Thing getObject(String requestedObject)
    {
        Thing result = null;
        for (Thing thingFromBag : objects) {
            if (thingFromBag.getName().equalsIgnoreCase(
                    requestedObject.toLowerCase())) {
                result = thingFromBag;
            }
        }
        return result;
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


