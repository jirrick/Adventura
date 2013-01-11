package cz.vse._101.po0000.xpavj012b_doplneny;

/**
 *  Třída implementující toto rozhraní bude ve hře zpracovávat jeden konkrétní příkaz.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *
 *@author     Jarmila Pavlickova
 *@version    pro školní rok 2012/2013
 *
 */
interface IPrikaz {

	/**
     *  Metoda pro provedení příkazu ve hře.
     *  Počet parametrů je závislý na konkrétním příkazu,
     *  např. příkazy konec a napoveda nemají parametry
     *  příkazy jdi, seber, polož mají jeden parametr
     *  příkaz pouzij může mít dva parametry.
     *
     *  @param parametry počet parametrů závisí na konkrétním příkazu.
     *  @return Zpráva vrácená hrou po zadání příkazu
     *
     */
    public String proved(String... parametry);

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return nazev prikazu
     */
	public String getNazev();

}
