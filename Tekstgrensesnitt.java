package no.hvl.dat102;

import no.hvl.dat102.Fi;
import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.FilmarkivADT;
import java.util.Scanner;

public class Tekstgrensesnitt {
	private Scanner sc;

	public Tekstgrensesnitt() {
		sc = new Scanner(System.in);
	}

	public Film lesFilm() {
		System.out.print("Filmnr: ");
		int filmnr = lesInt();
		System.out.print("Produsent: ");
		String produsent = sc.nextLine();
		System.out.print("Tittel: ");
		String tittel = sc.nextLine();
		System.out.print("Aarstall: ");
		int aarstall = lesInt();
		Sjanger sjanger = lesSjanger();
		System.out.print("Filmselskap: ");
		String filmselskap = sc.nextLine();
		System.out.println();
		return lesFilm();

	}

	// Hjelpemetode til lesFilm(), sjekker om innlest sjanger er gyldig
	private Sjanger lesSjanger() {
		Sjanger resultat = null;

		while(resultat == null) {
			System.out.print("Sjanger: ");
			resultat = Sjanger.finnSjanger(sc.nextLine());

			if(resultat == null) {
				System.out.println("Ugyldig sjanger\n");
			}
		}

		return resultat;
	}

	public void slettFilm(FilmArkiv fa) {
		System.out.print("Oppgi filmnr: ");
		int filmnr = lesInt();
		if(fa.slettFilm(filmnr)) {
			System.out.println("\nFilmen ble slettet\n");
		} else {
			System.out.println("\nFant ikke filmen i arkivet\n");
		}
	}

	public void visOverskrift() {
		System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s%n%n", "Filmnr", "Produsent", "Tittel", "Årstall", "Sjanger", "Filmselskap");
	}

	public void visFilm(Film film) {
		System.out.format("%-10d %-20s %-20s %-20d %-20s %-20s%n", film.getFilmnr(), film.getProdusent(), film.getTittel(),
				film.getAarstall(), film.getSjanger(), film.getFilmselskap());
	}

	public void skrivUtFilmDelstrengITittel(FilmArkiv fa, String delstreng) {
		Film[] filmer = fa.soekTittel(delstreng);
		visOverskrift();

		for(Film film : filmer) {
			visFilm(film);
		}

		System.out.println();
	}

	public void skrivUtFilmDelstrengITittel(FilmArkiv fa) {
		System.out.print("Oppgi delstreng i tittel: ");
		String tittel = sc.nextLine();
		System.out.println();
		skrivUtFilmDelstrengITittel(fa, tittel);
	}

	public void skrivUtFilmProdusent(FilmArkiv fa, String delstreng) {
		Film[] filmer = fa.soekProdusent(delstreng);
		visOverskrift();

		for(Film film : filmer) {
			visFilm(film);
		}

		System.out.println();
	}

	public void skrivUtFilmProdusent(FilmArkiv fa) {
		System.out.print("Oppgi delstreng i produsent: ");
		String produsent = sc.nextLine();
		System.out.println();
		skrivUtFilmProdusent(fa, produsent);
	}

	public void skrivUtStatistikk(FilmArkiv fa) {
		System.out.println("Antall filmer totalt: " + fa.antall());

		for(Sjanger sjanger : Sjanger.values()) {
			System.out.format("Antall filmer i sjangeren %s: %d%n", sjanger, fa.antall(sjanger));
		}

		System.out.println();
	}

	public void lagreFilmarkiv(FilmArkiv fa) {
		System.out.print("Oppgi filnavn: ");
		String filnavn = sc.nextLine();
		System.out.println();
		Fi.skrivTilFil(fa, filnavn);
	}

	public FilmArkiv lastFilmarkiv() {
		System.out.print("Oppgi filnavn: ");
		String filnavn = sc.nextLine();
		System.out.println();

		FilmArkiv fa = Fi.lesFraFil(filnavn);
		return fa;
	}

	public int lesInt() {
		int resultat = 0;
		boolean lestOk = false;

		while(!lestOk) {
			String linje = sc.nextLine();

			try {
				resultat = Integer.parseInt(linje);
				lestOk = true;
			} catch(NumberFormatException e) {
				System.out.print("Ugyldig input, oppgi et heltall: ");
			}
		}

		return resultat;
	}


}
