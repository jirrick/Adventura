/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._101.ut0915.xhudj19_hudec;




/*******************************************************************************
 * Knihovní třída {@code Texts} slouží jako schránka na textové konstanty,
 * které se používají na různých místech programu.
 * Centralizací definic těchto textových řetězců lze nejsnadněji dosáhnout toho,
 * že texty, které mají být shodné na různých místech programu,
 * budou doopravdy shodné.
 *
 * @author    Jiří HUDEC
 * @version   0.01.000
 */
public class Texts
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Jméno autora programu. */
    public static final String AUTOR = "HUDEC Jiří";

    /** Xname autora programu. */
    private static final String XNAME = "XHUDJ19";

    /** Názvy používaných prostorů - místností.
     *  Prefix "m" - místo
     */
    public static final String
            mDŮM = "Dům",
            mZAHRADA = "Zahrada",
            mULICE  = "Ulice",
            mHOSPODA= "Hospoda",
            mLOUKA= "Louka",
            mVOGONI  = "Vogonská_loď";

    /** Jména používaných osob.
     *  Prefix "j" - jména
     */
    public static final String
            jARTHUR = "Arthur",
            jBARMAN = "Barman",
            jFORD = "Ford",
            jPROSSER = "Prosser";


    /** Názvy používaných objektů.
     *  Prefix "o" - objekt
     */
    public static final String
            oRUČNÍK = "Ručník",
            oPANTOFLE = "Pantofle",
            oKARTÁČEK = "Kartáček",
            oKONVICE = "Konvice",
            oHRNEK = "Hrnek",
            oTALÍŘ = "Talíř",
            oSKLENICE = "Sklenice",
            oLEDNICE = "Lednice",
            oBULDOZER = "Buldozer",
            oBLÁTO = "Bláto",
            oZNAČKA = "Značka",
            oAUTO = "Auto",
            oPATNÍK = "Patník",
            oPIVO = "Pivo",
            oBURÁKY = "Buráky",
            oŽIDLE = "Židle",
            oSTROM = "Strom",
            oNÁKLAĎÁK = "Náklaďák",
            oKVĚTINA = "Květina",
            oKÁMEN = "Kámen",
            oPALEC = "Palec",
            oPRŮVODCE = "Průvodce",
            oPŘÍJMAČ = "Příjmač",
            oSCÉNÁŘ = "Scénář",
            oPĚTILIBROVKA = "Pětilibrovka";


    /** Názvy používaných příkazů.
     *  Prefix "p" - příkaz
     */
    public static final String
            pHELP = "?",
            pJDI = "Jdi",
            pPOLOŽ = "Polož",
            pZVEDNI = "Zvedni",
            pVEZMI = "Vezmi",
            pPROMLUV = "Promluv",
            pPŘEDEJ = "Předej",
            pPOUŽIJ = "Použij",
            pPOZŘI = "Pozři",
            pKONEC = "Konec";


    /** Formát dodatku zprávy informujícího o aktuálním stavu hráče.
     *  Prefix "d" - dodatek
     */
    public static final String
            dSOUSEDÉ  = "Sousedé:  ",
            dOSOBY    = "Osoby:    ",
            dPŘEDMĚTY = "Předměty: ",
            dTAŠKA    = "Taška:    ",
            dFORMÁT_INFORMACE = "\n\nNacházíte se v prostoru: %s" +
                               "\n" + dSOUSEDÉ  + "[%s]" +
                               "\n" + dOSOBY    + "[%s]" +
                               "\n" + dPŘEDMĚTY + "[%s]" +
                               "\n" + dTAŠKA    + "[%s]";


    /** Texty zpráv vypisovaných v reakci na povinné příkazy.
     *  Prefix "z" - zpráva
     */
    public  static final String
    zANP            = "\nZadaná akce nebyla provedena",
    zPORADÍM        = "\nChcete-li poradit, zadejte příkaz ?",
    zPRÁZDNÝ_PŘÍKAZ = "\nZadal(a) jste prázdný příkaz" + zPORADÍM,
    zNEZNÁMÝ_PŘÍKAZ = "\nTento příkaz neznám" + zPORADÍM,

    zPŘESUN         = "\nPřesunul(a) jste se do prostoru: ",
    zCÍL_NEZADAN    = zANP + "\nNebyla zadán prostor, do kterého se má přejít",
    zNENÍ_CIL       = zANP + "\nDo zadaného prostoru se odsud nedá přejít",

    zZVEDNUTO       = "\nVzal(a) jste předmět: ",
    zPOLOŽENO       = "\nPoložil(a) jste předmět: ",
    zPŘEDMĚT_NEZADAN= zANP + "\nNebyl zadán předmět, s nímž mám manipulovat",
    zTĚŽKÝ_PŘEDMĚT  = zANP + "\nZadaný předmět nejde zvednout: ",
    zNENÍ_PŘEDMĚT   = zANP + "\nZadaný předmět v místnosti není: ",
    zNENÍ_V_BATOHU  = zANP + "\nPředmět není v batohu: ",
    zBATOH_PLNÝ     = zANP + "\nZadaný předmět nemůžete vzít," +
                             "\ndo tašky se toho už víc nevejde.",

    zNÁPOVĚDA       = "\nPříkazy, které je možno v průběhu hry zadat:" +
                      "\n============================================" +
                      "\nJdi [kam] - Přesun do určeného prostoru" +
                      "\nPolož [co] - Položí určený předmět do prostor" +
                      "\nPoužij [co] - Použije určený předmět z tašky" +
                      "\nPozři [co] - Sní/vypije určený předmět" +
                      "\nPromluv [kdo] - Zahají rozhovor s danou osobou" +
                      "\nPředej [co] [kdo] - Předá předmět osobě" +
                      "\nVezmi [co] [kdo] - Vezme předmět od osoby" +
                      "\nZvedni [co] - Zvedne předmět z prostoru",

    zUVÍTÁNÍ        =
        "\nJmenuješ se Ford Prefect." +
        "\nJsi vesmírný stopař a terénní průzkuzmník pro" +
        "\nvesmírnou encyklopedii \"Stopařův průvodce Galaxií\"" +
        "\nuvízlý 15 let na planetě Zemi." +
        "\nDnes ráno tě vzbudilo pípání tvého senzomatického" +
        "\nsubéterového příjmače oznamující ti, že k Zemi" +
        "\nse právě blíží flotila Vogonských stavebních lodí" +
        "\ns cílem ji zničit, aby na jejím místě postavili" +
        "\nhypergalaktickou dálnici." +
        "\nJeště předtím, než použiješ svůj elektronický palec," +
        "\naby jsi stopoval některou z Vogonských lodí je čas," +
        "\naby jsi zachránil život tvému kamarádovi Arthurovi Dentovi." +
        "\nNezapomeń, že každý správný stopař musí vědět," +
        "\nkde má ručník!",

    zCELÉ_UVÍTÁNÍ   = zUVÍTÁNÍ +
                      String.format(dFORMÁT_INFORMACE,
                                    mLOUKA,
                                    cat(mULICE),
                                    "",
                                    cat(oSTROM, oNÁKLAĎÁK, oBULDOZER,
                                                           oKVĚTINA, oKÁMEN),
                                    cat(oPALEC, oPRŮVODCE, oPŘÍJMAČ,
                                                           oSCÉNÁŘ, oRUČNÍK,
                                                           oPĚTILIBROVKA,
                                                           oPĚTILIBROVKA)
                      ),

    zKONEC         = "Konec hry. \nDěkujeme, že jste zkusil(a) naši hru.";


    /** Texty zpráv vypisované v reakci na nepovinné příkazy.
     *  Prefix "n" - nepovinná zpráva
     */
    public static final String

    nPRŮVODCE_START = "\nOtevřel jsi vesmírnou encykolopedii " +
            "\"Stopařův průvodce\ngalaxií\", ptej se na to, co tě zajímá." +
            "\nPro návrat do hry napiš tečku.",
    nPRŮVODCE_STOP = "\nNashledanou příště.\nA hlavně: NEPROPADEJTE PANICE!.",
    nPRŮVODCE_UNKNOWN = "\nAčkoliv je to vysoce nepravděpodobné, " +
            "tak \"Stopařův průvodce galaxií\" toto heslo nezná.",
    nPRŮVODCE_RUČNÍK = "\nRučník je skutečně kolosálně užitečná " +
            "součást výbavy hvězdného stopaře." +
            "\nPředevším má značnou praktickou cenu -" +
            " můžete se například do něj zabalit," +
            "\naby vám nebylo zima, když poskakujete " +
            "napříč chladnými měsíci planety Jaglan" +
            "\nBeta.  Můžete na něm ležet na zářivých," +
            " mramorovým pískem vystlaných plážích" +
            "\nSantraginu V a vdechovat opojné výpary " +
            "z jeho moří. Můžete na něm spát pod" +
            "\nhvězdami, jež tak rudě září na planetě " +
            "pouští, Kakrafúnu. Můžete ho použít" +
            "\njako plachtu, až poplujete na maličkém " +
            "voru po proudu drsné řeky Moth," +
            "\nmůžete ho namočit pro boj zblízka, " +
            "nebo si jím zahalit hlavu, abyste necítili" +
            "\njedovaté pachy žravé obludy Blátotlačky " +
            "z Traalu a nestřetli se s jejím pohledem" +
            "\n(je to nepředstavitelně tupé zvíře, myslí " +
            "si, že když ji nevidíte, nevidí ani" +
            "\nona vás - blbá jak tágo, ale značně žravá)." +
            " Když jste v úzkých, můžete jím" +
            "\nsignalizovat o pomoc. No, a samozřejmě se " +
            "jím také můžete utřít, pokud vám" +
            "\npo tom všem ještě připadá dost čistý.",

    nPRSTEN = "\nPoužil jsi elektronický palec pro stopování vesmírných lodí." +
            "\nNěkterá by vás měla být ochotná přijmout.",

    nNELZE_POUŽÍT = "\nTento předmět nelze použít",

    nROZHOVOR_START =   "\nZačal(a) jsi se bavit s postavou: ",

    nPOZŘÍT =   "\nPozřel(a) jsi: ",

    nPŘEDAT_FORMÁT =   "\nPostavě %s jsi předal(a) předmět: %s",
    nVZÍT_FORMÁT =   "\nOd postavy %s jsi převzal(a) předmět: %s",

    nVÝHRA =   "\nGratuluji! Úspěšně jsi zachránil Arthura Denta!",
    nPROHRA =   "\nTo ses moc nepředvedl, Forde." +
            " Obzvlášť tohle jsi pěkně zvoral: ";



    /** Texty rozhovorů.
     *  Prefix "r" - rozhovory
     */
    public static final String

    rFORMÁT = "\n\n%s: „%s“",

    rNEGATIVE = "Promiňte, teď se s vámi nebudu bavit.",
    rPOSITIVE = "Dobře.",

    rA_1 =   "Ahoj Arthure. ",

    rB_1 =   "Haló, promiňte, že ruším. ",

    rC_1 =   "Tak dělej, vstávej. ",

    rD_1 =   "Dva kousky hořkého, ale rychle, bude konec světa.",

    rE_1 =   "Dělej, pij, máš tu pivo.",

    rF_1 =   "Poprosil bych o balíček buráků.";



//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Vrátí řetězec obsahující zadané názvy oddělené čárkami.
     *
     * @param názvy Názvy, které je třeba sloučit
     * @return Výsledný řetězec ze sloučených zadaných názvů
     */
    public static String cat(String... názvy)
    {
        if (názvy.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(názvy[0]);
        for (int i=1;   i < názvy.length;   i++) {
            sb.append(", ").append(názvy[i]);
        }
        return sb.toString();
    }



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private Texts() {}



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        Texts inst = new Texts();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main( String[] args )  {  test();  }
}
