package cz.vse._101.ut0915.xhudj19_hudec;
/* Kodovani UTF-8: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import static cz.vse._101.ut0915.stara_verze.Texts.*;
import cz.vse.adv_framework.game_txt.IBag;
import cz.vse.adv_framework.game_txt.IObject;
import java.util.ArrayList;
import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code Bag} představují úložiště, do nichž si hráči
 * odkládají objekty sebrané v jednotlivých prostorech.
 *
 * @author  Jiří HUDEC
 * @version 0.1
 */
public class Bag implements IBag
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Kapacita tašky. */
    private static final int CAPACITY = 7;

    /** Odkaz na jedináčka. */
    private static final Bag BAG = new Bag();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Kolekce objektů nacházejících se právě v "batohu". */
    private final Collection<Thing> objects = new ArrayList<>();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    private Bag()
    {
    }

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedináčka.
     *
     * @return Odkaz na jedinou existující instanci tašky.
     */
    public static Bag getInstance()
    {
        return BAG;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
     * které se do něj umístí.
     *
     * @return Kapacita batohu
     */
    @Override
    public int getCapacity()
    {
        return CAPACITY;
    }


    /***************************************************************************
     * Vrátí kolekci objektů uložených v batohu.
     *
     * @return Kolekce objektů v batohu
     */
    @Override
    public Collection<? extends IObject> getObjects()
    {
        return objects;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Pokusí se přidat zadaný objekt do batohu.
     * Vrátí informaci o tom, zda se operace zdařila.
     *
     * @param thing Přidávaný objekt
     * @return By-li objekt přidán, vrátí {@code true}, nebyl-li přidán
     *
     */
    boolean add(Thing thing)
    {
        if (objects.size() + thing.getWeight() > CAPACITY) {
            return false;
        }
        objects.add(thing);
        return true;
    }

    /***************************************************************************
     * Uvede batoh do počátečního stavu pro start hry..
     */
    public void initialize()
    {
        objects.clear();
        objects.add(new Thing(oPALEC));
        objects.add(new Thing(oPRŮVODCE));
        objects.add(new Thing(oPŘÍJMAČ));
        objects.add(new Thing(oSCÉNÁŘ));
        objects.add(new Thing(oRUČNÍK));
        objects.add(new Thing(oPĚTILIBROVKA));
        objects.add(new Thing(oPĚTILIBROVKA));
    }

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
//        Bag inst = new Bag();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main( String[] args )  {  test();  }
}
