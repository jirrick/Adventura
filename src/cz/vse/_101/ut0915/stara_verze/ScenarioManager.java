/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._101.ut0915.stara_verze;

import static cz.vse._101.ut0915.stara_verze.Texts.*;
import cz.vse.adv_framework.game_txt.IGame;
import cz.vse.adv_framework.scenario.AScenarioManager;
import cz.vse.adv_framework.scenario.ScenarioStep;
import cz.vse.adv_framework.scenario.TypeOfScenario;
import cz.vse.adv_framework.scenario.TypeOfStep;
import static cz.vse.adv_framework.scenario.TypeOfStep.*;
import cz.vse.adv_framework.test_util._Test_101;



/*******************************************************************************
 * Instance třídy {@code EmptyScenarioManager} slouží jako správce scénářů,
 * které mají prověřit a/nebo demonstrovat správnou funkci plánované hry.
 * Jednotlivé scénáře jsou iterovatelné posloupností kroků specifikovaných
 * instancemi třídy <code>ScenarioStep</code> z rámce, do nějž se hra začleňuje.
 * <p>
 * Správce scénářů je jedináček, který má na starosti všechny scénáře
 * týkající se s ním sdružené hry.
 *
 * @author  Jiří HUDEC
 * @version 0.01
 */
public class ScenarioManager extends AScenarioManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Třída, jejíž instance jsou zde spravovány. */
    private final static Class<? extends IGame> CLASS = null;

    /** Jméno autora dané třídy. */
    private static final String AUTHOR = "HUDEC Jiří";

    /** Xname autora/autorky dané třídy. */
    private static final String XNAME = "XHUDJ19";


    /*==========================================================================
     * Konstruktor plnohodnotné instance třídy {@link ScenarioStep}
     * vyžaduje následující parametry:
     *   String   command;   //Příkaz realizující tento krok scénáře
     *   String   message;   //Zpráva vypsaná po zadání příkazu
     *   String   place;     //Prostor, v němž skončí hráč po zadání příkazu
     *   String[] neighbors; //Sousedé aktuálního prostoru (= východy)
     *   String[] objects;   //Objekty vyskytující se v daném prostoru
     *   String[] bag;       //Aktuální obsah batohu
     *   TypeOfStep typeOfStep; //Typ daného kroku scénáře
     =========================================================================*/


    /***************************************************************************
     * Počáteční krok hry, který je pro všechny scénáře shodný.
     */
     private static final ScenarioStep START_STEP =
        new ScenarioStep( "", //Název prvního příkazu musí být prázdný řetězec
            zCELÉ_UVÍTÁNÍ,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            TypeOfStep.tsSTART );

    /***************************************************************************
     * Kroky základního úspěšného scénáře
     * popisující očekávatelný úspěšný průběh hry.
     * Z těchto kroků sestavený scénář nemusí být nutně nejkratším možným
     * (takže to vlastně ani nemusí být základní úspěšný scénář),
     * ale musí vyhovovat všem okrajovým podmínkám zadání,
     * tj. musí obsahovat minimální počet kroků,
     * projít požadovaný.minimální počet prostorů
     * a demonstrovat použití všech požadovaných příkazů.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS =
    {
        START_STEP,

         new ScenarioStep( pPOUŽIJ + " " + oPRŮVODCE,
            nPRŮVODCE_START,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsNON_STANDARD ),

         new ScenarioStep( oRUČNÍK,
            nPRŮVODCE_RUČNÍK,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsDIALOG ),

        new ScenarioStep( ".",
            nPRŮVODCE_STOP,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsDIALOG ),

        new ScenarioStep( pJDI + " " + mULICE,
            zPŘESUN + mULICE +
            String.format(dFORMÁT_INFORMACE,
                                    mULICE,
                                    cat(mZAHRADA, mHOSPODA, mLOUKA),
                                    "",
                                    cat(oZNAČKA, oAUTO, oPATNÍK),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA)
                         ),
            mULICE,
            new String[] { mZAHRADA, mHOSPODA, mLOUKA },
            new String[] { oZNAČKA, oAUTO, oPATNÍK },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsMOVE ),

         new ScenarioStep( pJDI + " " + mZAHRADA,
            zPŘESUN + mZAHRADA +
            String.format(dFORMÁT_INFORMACE,
                                    mZAHRADA,
                                    cat(mDŮM, mULICE),
                                    cat(jARTHUR, jPROSSER),
                                    cat(oBULDOZER, oBLÁTO, oKVĚTINA),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA)
                         ),
            mZAHRADA,
            new String[] { mDŮM, mULICE },
            new String[] { oBULDOZER, oBLÁTO, oKVĚTINA, jARTHUR, jPROSSER },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsMOVE ),

         new ScenarioStep( pPROMLUV + " " + jARTHUR,
            nROZHOVOR_START + jARTHUR +
            String.format(rFORMÁT, jFORD, rA_1) +
            String.format(rFORMÁT, jARTHUR, rPOSITIVE),
            mZAHRADA,
            new String[] { mDŮM, mULICE },
            new String[] { oBULDOZER, oBLÁTO, oKVĚTINA, jARTHUR, jPROSSER },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsNON_STANDARD),

         new ScenarioStep( pPROMLUV + " " + jPROSSER,
            nROZHOVOR_START + jPROSSER +
            String.format(rFORMÁT, jFORD, rB_1) +
            String.format(rFORMÁT, jPROSSER, rPOSITIVE),
            mZAHRADA,
            new String[] { mDŮM, mULICE },
            new String[] { oBULDOZER, oBLÁTO, oKVĚTINA, jARTHUR, jPROSSER },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsNON_STANDARD),

         new ScenarioStep( pPROMLUV + " " + jARTHUR,
            nROZHOVOR_START + jARTHUR +
            String.format(rFORMÁT, jFORD, rC_1) +
            String.format(rFORMÁT, jARTHUR, rPOSITIVE),
            mZAHRADA,
            new String[] { mDŮM, mULICE },
            new String[] { oBULDOZER, oBLÁTO, oKVĚTINA, jARTHUR, jPROSSER },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsNON_STANDARD),

         new ScenarioStep( pJDI + " " + mULICE,
            zPŘESUN + mULICE +
            String.format(dFORMÁT_INFORMACE,
                                    mULICE,
                                    cat(mZAHRADA, mHOSPODA, mLOUKA),
                                    cat(jARTHUR),
                                    cat(oZNAČKA, oAUTO, oPATNÍK),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA)
                         ),
            mULICE,
            new String[] { mZAHRADA, mHOSPODA, mLOUKA },
            new String[] { oZNAČKA, oAUTO, oPATNÍK, jARTHUR },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsMOVE ),

         new ScenarioStep( pJDI + " " + mHOSPODA,
            zPŘESUN + mHOSPODA +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsMOVE ),

         new ScenarioStep( pPROMLUV + " " + jBARMAN,
            nROZHOVOR_START + jBARMAN +
            String.format(rFORMÁT, jFORD, rD_1) +
            String.format(rFORMÁT, jBARMAN, rPOSITIVE),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA },
            tsNON_STANDARD ),

         new ScenarioStep( pPŘEDEJ + " " + oPĚTILIBROVKA + " " + jBARMAN,
            String.format(nPŘEDAT_FORMÁT, jBARMAN, oPĚTILIBROVKA) +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA },
            tsNON_STANDARD ),

          new ScenarioStep( pVEZMI + " " + oPIVO + " " + jBARMAN,
            String.format(nVZÍT_FORMÁT, jBARMAN, oPIVO) +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPIVO)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPIVO },
            tsNON_STANDARD ),

          new ScenarioStep( pPŘEDEJ + " " + oPIVO + " " + jARTHUR,
            String.format(nPŘEDAT_FORMÁT, jARTHUR, oPIVO) +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA },
            tsNON_STANDARD ),

          new ScenarioStep( pVEZMI + " " + oPIVO + " " + jBARMAN,
            String.format(nVZÍT_FORMÁT, jBARMAN, oPIVO) +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPIVO)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPIVO },
            tsNON_STANDARD ),

          new ScenarioStep( pPOZŘI + " " + oPIVO,
            nPOZŘÍT + oPIVO +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA },
            tsNON_STANDARD ),

          new ScenarioStep( pPROMLUV + " " + jARTHUR,
            nROZHOVOR_START + jARTHUR +
            String.format(rFORMÁT, jFORD, rE_1) +
            String.format(rFORMÁT, jARTHUR, rPOSITIVE),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA },
            tsNON_STANDARD ),

          new ScenarioStep( pPROMLUV + " " + jBARMAN,
            nROZHOVOR_START + jBARMAN +
            String.format(rFORMÁT, jFORD, rF_1) +
            String.format(rFORMÁT, jBARMAN, rPOSITIVE),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA },
            tsNON_STANDARD ),

         new ScenarioStep( pPŘEDEJ + " " + oPĚTILIBROVKA + " " + jBARMAN,
            String.format(nPŘEDAT_FORMÁT, jBARMAN, oPĚTILIBROVKA) +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK},
            tsNON_STANDARD ),

          new ScenarioStep( pVEZMI + " " + oBURÁKY + " " + jBARMAN,
            String.format(nVZÍT_FORMÁT, jBARMAN, oBURÁKY) +
            String.format(dFORMÁT_INFORMACE,
                                    mHOSPODA,
                                    cat(mULICE),
                                    cat(jARTHUR, jBARMAN),
                                    cat(oŽIDLE, oSKLENICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oBURÁKY)
                         ),
            mHOSPODA,
            new String[] { mULICE },
            new String[] { oŽIDLE, oSKLENICE, jARTHUR, jBARMAN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oBURÁKY },
            tsNON_STANDARD ),

           new ScenarioStep( pJDI + " " + mULICE,
            zPŘESUN + mULICE +
            String.format(dFORMÁT_INFORMACE,
                                    mULICE,
                                    cat(mZAHRADA, mHOSPODA, mLOUKA),
                                    cat(jARTHUR),
                                    cat(oZNAČKA, oAUTO, oPATNÍK),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oBURÁKY)
                         ),
            mULICE,
            new String[] { mZAHRADA, mHOSPODA, mLOUKA },
            new String[] { oZNAČKA, oAUTO, oPATNÍK, jARTHUR },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oBURÁKY },
            tsMOVE ),

           new ScenarioStep( pPOLOŽ + " " + oSCÉNÁŘ,
            zPOLOŽENO + oSCÉNÁŘ +
            String.format(dFORMÁT_INFORMACE,
                                    mULICE,
                                    cat(mZAHRADA, mHOSPODA, mLOUKA),
                                    cat(jARTHUR),
                                    cat(oZNAČKA, oAUTO, oPATNÍK, oSCÉNÁŘ),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)
                         ),
            mULICE,
            new String[] { mZAHRADA, mHOSPODA, mLOUKA },
            new String[] { oZNAČKA, oAUTO, oPATNÍK, jARTHUR, oSCÉNÁŘ },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY },
            tsPUT_DOWN ),

           new ScenarioStep( pJDI + " " + mZAHRADA,
            zPŘESUN + mZAHRADA +
            String.format(dFORMÁT_INFORMACE,
                                    mZAHRADA,
                                    cat(mDŮM, mULICE),
                                    cat(jARTHUR, jPROSSER),
                                    cat(oBULDOZER, oBLÁTO, oKVĚTINA),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)
                         ),
            mZAHRADA,
            new String[] { mDŮM, mULICE },
            new String[] { oBULDOZER, oBLÁTO, oKVĚTINA, jARTHUR, jPROSSER },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY },
            tsMOVE ),

           new ScenarioStep( pJDI + " " + mDŮM,
            zPŘESUN + mDŮM +
            String.format(dFORMÁT_INFORMACE,
                                    mDŮM,
                                    cat(mZAHRADA),
                                    cat(jARTHUR),
                                    cat(oRUČNÍK, oPANTOFLE, oKARTÁČEK, oKONVICE, oHRNEK, oPĚTILIBROVKA, oTALÍŘ, oSKLENICE, oLEDNICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)
                         ),
            mDŮM,
            new String[] { mZAHRADA },
            new String[] { jARTHUR, oRUČNÍK, oPANTOFLE, oKARTÁČEK, oKONVICE, oHRNEK, oPĚTILIBROVKA, oTALÍŘ, oSKLENICE, oLEDNICE },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY },
            tsMOVE ),

           new ScenarioStep( pZVEDNI + " " + oRUČNÍK,
            zZVEDNUTO + oRUČNÍK +
            String.format(dFORMÁT_INFORMACE,
                                    mDŮM,
                                    cat(mZAHRADA),
                                    cat(jARTHUR),
                                    cat(oPANTOFLE, oKARTÁČEK, oKONVICE, oHRNEK, oPĚTILIBROVKA, oTALÍŘ, oSKLENICE, oLEDNICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY, oRUČNÍK)
                         ),
            mDŮM,
            new String[] { mZAHRADA },
            new String[] { jARTHUR, oPANTOFLE, oKARTÁČEK, oKONVICE, oHRNEK, oPĚTILIBROVKA, oTALÍŘ, oSKLENICE, oLEDNICE },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY, oRUČNÍK },
            tsPICK_UP ),

           new ScenarioStep( pPŘEDEJ + " " + oRUČNÍK + " " + jARTHUR,
            String.format(nPŘEDAT_FORMÁT, jARTHUR, oRUČNÍK) +
            String.format(dFORMÁT_INFORMACE,
                                    mDŮM,
                                    cat(mZAHRADA),
                                    cat(jARTHUR),
                                    cat(oPANTOFLE, oKARTÁČEK, oKONVICE, oHRNEK, oPĚTILIBROVKA, oTALÍŘ, oSKLENICE, oLEDNICE),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)
                         ),
            mDŮM,
            new String[] { mZAHRADA },
            new String[] { jARTHUR, oPANTOFLE, oKARTÁČEK, oKONVICE, oHRNEK, oPĚTILIBROVKA, oTALÍŘ, oSKLENICE, oLEDNICE },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY },
            tsNON_STANDARD ),

           new ScenarioStep( pJDI + " " + mZAHRADA,
            zPŘESUN + mZAHRADA +
            String.format(dFORMÁT_INFORMACE,
                                    mZAHRADA,
                                    cat(mDŮM, mULICE),
                                    cat(jARTHUR, jPROSSER),
                                    cat(oBULDOZER, oBLÁTO, oKVĚTINA),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)
                         ),
            mZAHRADA,
            new String[] { mDŮM, mULICE },
            new String[] { oBULDOZER, oBLÁTO, oKVĚTINA, jARTHUR, jPROSSER },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY },
            tsMOVE ),

           new ScenarioStep( pJDI + " " + mULICE,
            zPŘESUN + mULICE +
            String.format(dFORMÁT_INFORMACE,
                                    mULICE,
                                    cat(mZAHRADA, mHOSPODA, mLOUKA),
                                    cat(jARTHUR),
                                    cat(oZNAČKA, oAUTO, oPATNÍK),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)
                         ),
            mULICE,
            new String[] { mZAHRADA, mHOSPODA, mLOUKA },
            new String[] { oZNAČKA, oAUTO, oPATNÍK, jARTHUR },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY },
            tsMOVE ),

           new ScenarioStep( pJDI + " " + mLOUKA,
            zPŘESUN + mZAHRADA +
            String.format(dFORMÁT_INFORMACE,
                                    mLOUKA,
                                    cat(mULICE),
                                    cat(jARTHUR),
                                    cat(oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)),
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN, jARTHUR },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY},
            tsMOVE ),

           new ScenarioStep( pPOUŽIJ + " " + oPALEC,
            nPRSTEN +
            String.format(dFORMÁT_INFORMACE,
                                    mLOUKA,
                                    cat(mULICE, mVOGONI),
                                    cat(jARTHUR),
                                    cat(oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)),
            mLOUKA,
            new String[] { mULICE, mVOGONI },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN, jARTHUR },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY},
            tsNON_STANDARD ),

           new ScenarioStep( pJDI + " " + mVOGONI,
            zPŘESUN + mVOGONI + nVÝHRA +
            String.format(dFORMÁT_INFORMACE,
                                    mVOGONI,
                                    cat(),
                                    cat(jARTHUR),
                                    cat(),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY)),
            mVOGONI,
            new String[] {  },
            new String[] { jARTHUR },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oRUČNÍK, oBURÁKY},
            tsMOVE ),
//        UKONČENÍ
    };


    static { ScenarioStep.setIndex(2); }


    /***************************************************************************
     * Základní chybový scénář definující reakce
     * na povinnou sadu chybových stavů.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        START_STEP,

        new ScenarioStep( "Jmelí",
            zNEZNÁMÝ_PŘÍKAZ,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsUNKNOWN ),

        new ScenarioStep( "",
            zPRÁZDNÝ_PŘÍKAZ,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsEMPTY ),

        new ScenarioStep( pJDI + " " + mVOGONI,
            zNENÍ_CIL,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsBAD_NEIGHBOR ),

        new ScenarioStep( pZVEDNI + " " + oRUČNÍK,
            zNENÍ_PŘEDMĚT + oRUČNÍK,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsBAD_OBJECT ),

        new ScenarioStep( pJDI,
            zCÍL_NEZADAN,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsMOVE_WA ),

        new ScenarioStep( pZVEDNI + " " + oSTROM,
            zTĚŽKÝ_PŘEDMĚT + oSTROM,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsUNMOVABLE ),

        new ScenarioStep( pPOLOŽ + " " + oPIVO,
            zNENÍ_V_BATOHU + oPIVO,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsNOT_IN_BAG ),

        new ScenarioStep( pHELP,
            zNÁPOVĚDA,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsHELP ),

        new ScenarioStep( pZVEDNI,
            zPŘEDMĚT_NEZADAN,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsPICK_UP_WA ),

        new ScenarioStep( pPOLOŽ,
            zPŘEDMĚT_NEZADAN,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsPUT_DOWN_WA ),

        new ScenarioStep( pZVEDNI + " " + oKÁMEN,
            zBATOH_PLNÝ,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsBAG_FULL ),

        new ScenarioStep( pKONEC,
            zKONEC,
            mLOUKA,
            new String[] { mULICE },
            new String[] { oSTROM, oNÁKLAĎÁK, oBULDOZER, oKVĚTINA, oKÁMEN },
            new String[] { oPALEC, oPRŮVODCE, oPŘÍJMAČ, oSCÉNÁŘ, oRUČNÍK, oPĚTILIBROVKA, oPĚTILIBROVKA},
            tsEND ),


//        UKONČENÍ
    };


    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
    private static final ScenarioManager MANAGER =
                                          new ScenarioManager();



//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vrátí správce scénářů - jedinou instanci této třídy.
     *
     * @return Správce scénářů
     */
    public static ScenarioManager getInstance()
    {
        return MANAGER;
    }


    /***************************************************************************
     * Vytvoří instanci představující správce scénářů hry.
     */
    private ScenarioManager()
    {
        super(AUTHOR, XNAME, CLASS);

        addScenario("Úspěšný",
                    TypeOfScenario.scHAPPY,    HAPPY_SCENARIO_STEPS);
        addScenario("Chybový",
                    TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        seal();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTOVACÍ METODY A TŘÍDY ==================================================

    /***************************************************************************
     * Základní test ověřující,
     * jestli správce scénářů vyhovuje zadaným okrajovým podmínkám, tj. jestli:
     * <ul>
     *   <li>Umí vrátit správně naformátované jméno autora/autorky hry
     *       a jeho/její xname.</li>
     *   <li>Definuje základní úspěšný a základní chybový scénář.</li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Minimální požadovaný počet kroků</li>
     *       <li>Minimální počet navštívených místností</li>
     *       <li>Minimální počet "zahlédnutých" místností</li>
     *       <li>Použití příkazů pro přechod z prostoru do prostoru
     *         zvednutí nějakého objektu a položení nějakého objektu</li>
     *     </ul>
     *   </li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Použití všech povinných chybových typů kroku
     *         definovaných ve třídě
     *         {@link cz.vse.adv_framework.scenario.TypeOfStep}</li>
     *       <li>Vyvolání nápovědy</li>
     *       <li>Ukončení příkazem pro nestandardní ukončení hry</li>
     *     </ul>
     *   </li>
     * </ul>
     */
    public static void testMyScenarioManager()
    {
        _Test_101 test = _Test_101.getInstance(MANAGER);
        test.testScenarioManager();
    }


    /***************************************************************************
     * Simuluje hraní hry podle základního úspěšného
     * a základního chybového scénáře.
     */
    public static void simulateBasicScenarios()
    {
        _Test_101 test = _Test_101.getInstance(MANAGER);
        test.simulateScenario(MANAGER.getScenario(0), false);
        test.simulateScenario(MANAGER.getScenario(1), false);
    }


    /***************************************************************************
     * Testování funkce hry prováděné postupně
     * prostřednictvím všech scénářů daného správce
     */
    public static void testMyGame()
    {
//          IGame     hra  = Game.getInstance();
        IGame     hra  = MANAGER.getGame();
        _Test_101 test = _Test_101.getInstance(hra);
        test.testGame();
    }


    /** @param args Parametry příkazového řádku - nepoužívané. */
    public static void main( String[] args )
    {
//        testMyScenarioManager();
//        simulateBasicScenarios();
        testMyGame();
    }
}
