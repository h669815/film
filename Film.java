package no.hvl.dat102;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int aarstall;
	private Sjanger sjanger;
	private String filmselskap;

	public Film() {

	}

	public Film(int filmnr, String produsent, String tittel, int aarstall, Sjanger sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.aarstall = aarstall;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	
	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getAarstall() {
		return aarstall;
	}

	public void setAarstall(int aarstall) {
		this.aarstall = aarstall;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}


}
