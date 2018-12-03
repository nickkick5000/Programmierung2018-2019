/**
 *bildet schluessel-wert paare
 */
public class Pair {

	private final String key;
	private final String value;
	
	/**
	 * setzt key von Pair Objekt auf key und value Objekt auf value, fuer den fall, dass value ein string ist
	 * @param key schluessel des Objektes Pair
	 * @param value wert des Objektes Pair
	 */
	public Pair(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * setzt key von Pair Objekt auf key und value Objekt auf value, fuer den fall, dass value ein int ist
	 * @param key schluessel des Objektes Pair
	 * @param value wert des Objektes Pair
	 */
	public Pair(String key, int value) {
		String value1 = Integer.toString(value); 
		
		this.key = key;
		this.value = value1;
	}
	
	/**
	 * gibt den schluessel des aktuellen pair objektes zurueck
	 * @return schluessel des pair objektes
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * gibt den wert des aktuellen pair objektes zurueck
	 * @return wert des pair objektes
	 */
	public String getValue() {
		return this.value;
	}
	
	
	/**
	 * erstellt aus dem schluessel und dem wert des objektes einen string
	 * @return String aus schluessel und wert
	 */
	public String toString() {
		
		String result = "'" + this.key + "': '" + this.value + "'";
		
		return result;
	}
	
	/**
	 * erstellt aus einem string ein paar mit schluessel und wert
	 * @param eingabe string der schluessel und wert enthaelt
	 * @return Pair Objekt mit schluessel und wert
	 */
	public static Pair fromString(String eingabe) {
		String array[] = eingabe.split("'");		//alle ' werden entfernt
		String result = "";
		for(int i = 0; i < array.length; i++) {
			result = result + array[i];
		}
		String array1[] = result.split(":");		//alle : werden entfernt
		String result1 = "";
		for(int i = 0; i < array1.length; i++) {
			result1 = result1 + array1[i];
		}
		String array2[] = result1.split(" ");		//alle leeren felder werden enfernt
		
		return new Pair(array2[0], array2[1]);
		
	}
	
}
