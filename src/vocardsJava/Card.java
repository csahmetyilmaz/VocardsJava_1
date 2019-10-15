package vocardsJava;

public class Card {

	private int id;
	private String mot;
	private String tMot;
	private String type;
	private String tType;
	private String syno;
	private String tSyno;
	private String phrase;
	private String tPhrase;
	private int auteurId;

	// constructeur minimum fields
	public Card(int id, String mot, String tmot, String type, String ttype, String phrase, String tphrase) {
		this.id = id;
		this.mot = mot;
		this.tMot = tmot;
		this.type = type;
		this.tType = ttype;
		this.phrase = phrase;
		this.tPhrase = tphrase;
		this.tSyno = null;
		this.syno = null;
	}

	// All fields
	public Card(int id, String mot, String tMot, String type, String tType, String syno, String tSyno, String phrase,
			String tPhrase, int auteurId) {
		
		this.id = id;
		this.mot = mot;
		this.tMot = tMot;
		this.type = type;
		this.tType = tType;
		this.syno = syno;
		this.tSyno = tSyno;
		this.phrase = phrase;
		this.tPhrase = tPhrase;
		this.auteurId=auteurId;
	}

	public Card(String mot2, String tMot2, String type2, String tType2, String syno2, String tSyno2, String phrase2,
			String tPhrase2) {
		this.mot = mot2;
		this.tMot = tMot2;
		this.type = type2;
		this.tType = tType2;
		this.syno = syno2;
		this.tSyno = tSyno2;
		this.phrase = phrase2;
		this.tPhrase = tPhrase2;
	}

	// Getter and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public String gettMot() {
		return tMot;
	}

	public void settMot(String tMot) {
		this.tMot = tMot;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public String getSyno() {
		return syno;
	}

	public void setSyno(String syno) {
		this.syno = syno;
	}

	public String gettSyno() {
		return tSyno;
	}

	public void settSyno(String tSyno) {
		this.tSyno = tSyno;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public String gettPhrase() {
		return tPhrase;
	}

	public void settPhrase(String tPhrase) {
		this.tPhrase = tPhrase;
	}

	public int getAuteurId() {
		return auteurId;
	}

	public void setAuteurId(int auteurId) {
		this.auteurId = auteurId;
	}

	// Tostring
	@Override
	public String toString() {
		return "Card [id=" + id + ", mot=" + mot + ", tMot=" + tMot + ", type=" + type + ", tType=" + tType + ", syno="
				+ syno + ", tSyno=" + tSyno + ", phrase=" + phrase + ", tPhrase=" + tPhrase + "]";
	}

}
