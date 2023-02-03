package no.hvl.dat102;

import no.hvl.dat102.FilmarkivADT;


public class KlientFilmarkiv {

	public static void main(String[] args) {
		FilmArkiv fa = new FilmArkiv();
		Meny meny = new Meny(fa);
		meny.start();
	}
}
