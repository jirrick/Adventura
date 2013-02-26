/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse.adv_framework.test_util;

import cz.vse.adv_framework.game_txt.IGame;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;





/*******************************************************************************
 * Instances of class {@code TestUtilitiy} represent ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class TestUtilitiy
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Zjistí, jestli třída zadaná svým class-objektem definuje statickou
     * tovární metodu {@code getInstance} nebo {@code getGame} nebo
     * {@code getHra} požádá nalezenou metodu o instanci dané třídy.
     *
     * @param <T> Typ, jehož instanci má tovární metoda vracet
     * @param cls Class-objekt třídy, jejíž instanci chceme získat
     * @return    Jediná instance zadané třídy
     *
     * @throws IllegalArgumentException
     *         Třída nevyhovuje požadavkům na třídu definující jedináčka
     *         nebo se nepodaří získat požadovanou instanci
     *         anebo na druhý dotaz vrátí jinou instanci
     * @throws SecurityException
     *         Nemáme právo přehrabovat se v zadaném class-objektu
     */
    public static <T> T verifyFactoryMethod(Class<? extends T> cls)
           throws SecurityException, IllegalArgumentException
    {
        Method[] mtds = cls.getMethods();
        for (Method mtd : mtds) {
            String name = mtd.getName();
            Class<?> retType = mtd.getReturnType();
            if ("getInstance".equals(name)  &&
                cls.equals(retType))
            {
                try {
                    T o1 = (T)mtd.invoke(null);
                    T o2 = (T)mtd.invoke(null);
                    if (o1 != o2) {
                        throw new IllegalArgumentException(
                            "\nTovární metoda " + mtd + " třídy " + cls +
                            "\nnevrací při každém zavolání stejnou instanci");

                    }
                    return o1;                             //==========>
                } catch (IllegalAccessException | IllegalArgumentException |
                         InvocationTargetException ex)
                {
                    throw new IllegalArgumentException(
                        "\nNepodařilo se získat instanci třídy\n" + cls +
                        "\nvoláním tovární metody getInstance()");
                }
            }
        }
        throw new IllegalArgumentException(
            "\nTřída " + cls + "\nnemá tovární metodu getInstance()");
    }


    /***************************************************************************
     * Otestuje, že zadaná třída má jediný konstruktor, a ten je soukromý.
     *
     * @param cls Class-objekt testované třídy
     */
    public static void verifyPrivateConstructor(Class<?> cls)
    {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        if ((constructors.length > 1)  ||
            ((constructors[0].getModifiers() & Modifier.PRIVATE) == 0))
        {
            throw new IllegalArgumentException(
               "\nZadaná třída hry nemůže definovat jedináčka, " +
               "\nprotože nemá pouze soukromý konstruktor:\n" + cls);
        }
    }



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private TestUtilitiy() {}



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
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
//        TestUtilitiy inst = new TestUtilitiy();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
