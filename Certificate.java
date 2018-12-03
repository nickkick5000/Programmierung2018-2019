/**
 * repraesentiert ein zertifikat, welches aus einem algorithm, aus schluessel-wert paaren und einem zertifikat besteht
 */
public class Certificate {
	
	private Algorithm algorithm;
	public Pair[] pairs;
	private String signature;

	/**
	 * erstellt ein objekt certificate mit einem algorithm und beliebig vielen schluessel-wert paaren
	 * @param algorithm zugehoeriger algorithm des objekts
	 * @param pairs beliebig viele schluessel-wert paare die als vararg gespeichert werden
	 */
	public Certificate(Algorithm algorithm, Pair... pairs) {
		this.algorithm = algorithm;
		this.pairs = pairs;
	}
	
	/**
	 * gibt zugehoerigen wert des schluessels zurueck falls passender existiert
	 * @param key zu ueberpruefender schluessel
	 * @return gibt den wert des schluessels zurueck ansonsten null
	 */
	public String get(String key) {
		String value = null;
		
		for(Pair p : pairs) {
			if(p.getKey().equals(key)) {
				value = p.getValue();					//wenn es passenden schluessel gibt, dann gebe zugehoerigen wert aus
			}
		}
		
		return value;
	}
	
	/**
	 * setzt die signature des objekts auf die mitgelieferte signature
	 * @param signature signature die dem objekt zugewiesen wird
	 */
	public void setSignature(String signature) {		//setzt die signature des objekts auf die mitgelieferte signature
		this.signature = signature;
	}
	
	/**
	 * erstellt ein objekt des klasse certificate aus einem string
	 * @param eingabe string der inhalt des pair objekts enthaelt
	 * @return gibt ein objekt certificate aus 
	 */
	public static Certificate fromString(String eingabe) {
		String[] a1 = eingabe.split(";");		//trenne erst bei ; um algorithmus zu zu bestimmen
		
		Algorithm algorithm = Algorithm.valueOf(a1[0]);
		
		String[] valuePairs = a1[1].split(",");			//trenne an den , um array mit pairs und signature zu bekommen
		
		Pair[] pairs = new Pair[valuePairs.length];
		
		for(int i = 0; i < pairs.length; i++) {
			pairs[i] = Pair.fromString(valuePairs[i]);
		}
		
		Certificate sc = new Certificate(algorithm, pairs);
		
		sc.setSignature(a1[2]);			//setzte die signature von dem objekt
		
		return sc;												
	}
	
	/**
	 * erstellt string fuer gemaess des nicht-terminals inhalt
	 * @param sc inhalt des objekt welcher zu einem string umgewandelt wird
	 * @return gibt inhalt des objekts als string aus 
	 */
	private String getHeaderBodyString(Certificate sc) {
		String result = "";
		if(sc.algorithm == Algorithm.HMAC_MD5) {
			result = result + "HMAC_MD5" + ";";		//fuege den passenden algorithmus in den string ein
		}
		else if(sc.algorithm == Algorithm.HMAC_SHA1) {
			result = result + "HMAC_SHA1" + ";";
		}
		else if(sc.algorithm == Algorithm.HMAC_SHA256) {
			result = result + "HMAC_SHA256" + ";";
		}
		
		for(int i = 0; i < sc.pairs.length; i++) {				//fuege die paare in den string ein
			result = result + "'" + pairs[i].getKey() + "': ";
			if(i == sc.pairs.length - 1) {						//wenn letzes paar fuege am ende kein komma mehr ein 
				result = result + "'" + pairs[i].getValue() + "'";
			}
			else {
				result = result + "'" + pairs[i].getValue() + "',";
			}
		}
		result = result + ";";
		
		return result;
	}
	
	/**
	 * erstellt signature aus dem string secret und dem passenden algorithm
	 * @param secret bildet zusammen mit dem algorithm die signature
	 * @return gibt vollstaendiges zertifikat als string aus 
	 */
	public String getSignedString(String secret) {
		String sec = "";
		if(this.signature == null) {				//wenn keine signature vorhanden, berechne eine signatur 
			if(this.algorithm == Algorithm.HMAC_MD5) {
				byte[] array = Hasher.md5Hmac(getHeaderBodyString(this), secret);
				sec = Hasher.byteArrayToHex(array);
			}
			else if(this.algorithm == Algorithm.HMAC_SHA1) {
				byte[] array = Hasher.sha1Hmac(getHeaderBodyString(this), secret);
				sec = Hasher.byteArrayToHex(array);
			}
			else if(this.algorithm == Algorithm.HMAC_SHA256) {
				byte[] array = Hasher.sha256Hmac(getHeaderBodyString(this), secret);
				sec = Hasher.byteArrayToHex(array);
			}
			
		}
		String result = "";
		
		if(this.signature != null) {						//wenn signatur vorher nicht leer war dann setzte string aus bereits gegebener signatur zusammen
			result = getHeaderBodyString(this) + this.signature;
		}
		else {							//wenn vorher keine signature bekannt war, setze string aus neuer signature zusammen
			this.signature = sec;
			result = getHeaderBodyString(this) + sec;
		}
		
		return result;
	}
	
	/**
	 * ueberprueft ob erstellte signature mit der signature des objekts certificate uebereinstimmt
	 * @param secret bildet zusammen mit dem algorithm die signature
	 * @return gibt an ob die signature des objekts gleich ist mit der neu erstellten signature
	 */
	public boolean validateSignature(String secret) {
		boolean equal = false;
		
		String sec = "";
		if(this.algorithm == Algorithm.HMAC_MD5) {
			byte[] array = Hasher.md5Hmac(getHeaderBodyString(this), secret);
			sec = Hasher.byteArrayToHex(array);
		}
		else if(this.algorithm == Algorithm.HMAC_SHA1) {
			byte[] array = Hasher.sha1Hmac(getHeaderBodyString(this), secret);
			sec = Hasher.byteArrayToHex(array);
		}
		else if(this.algorithm == Algorithm.HMAC_SHA256) {
			byte[] array = Hasher.sha256Hmac(getHeaderBodyString(this), secret);
			sec = Hasher.byteArrayToHex(array);
		}
		
		if(this.signature.equals(sec)) {			//wenn signature von certificate objekt gleich der neuen signature ist gebe true aus
			equal = true;
		}
		
		return equal;
	}
}
