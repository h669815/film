package no.hvl.dat102;

import no.hvl.dat102.FilmarkivADT;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fi {
	final static String SKILLE = "#";

	public static void skrivTilFil(FilmArkiv fa, String filnavn) {

		Film[] filmer = fa.hentFilmTabell();
		PrintWriter p = null;

		try {
			p = new PrintWriter(filnavn);
			p.println(filmer.length);

			for(int i = 0; i < filmer.length; i++) {
				String filmLinje =
						filmer[i].getFilmnr() + SKILLE +
						filmer[i].getProdusent() + SKILLE +
						filmer[i].getTittel() + SKILLE +
						filmer[i].getAarstall() + SKILLE +
						filmer[i].getSjanger() + SKILLE +
						filmer[i].getFilmselskap();

				p.println(filmLinje);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Feil ved skriving til fil: " + e + "\n");
		} finally {
			if(p != null) {
				p.close();
			}
		}
	}

	public static FilmArkiv lesFraFil(String filnavn) {
		FilmArkiv fa = null;
		Scanner sc = null;

		try {
			sc = new Scanner(new File(filnavn));
			int antall = Integer.parseInt(sc.nextLine());
			fa = new FilmArkiv(antall);

			for(int i = 0; i < antall; i++) {
				String filmLinje = sc.nextLine();
				String[] komponenter = filmLinje.split(SKILLE);

				int filmnr = Integer.parseInt(komponenter[0]);
				String produsent = komponenter[1];
				String tittel = komponenter[2];
				int aarstall = Integer.parseInt(komponenter[3]);
				Sjanger sjanger = Sjanger.valueOf(komponenter[4]);
				String filmselskap = komponenter[5];

				Film film = new Film(filmnr, produsent, tittel, aarstall, sjanger, filmselskap);
				fa.leggTilFilm(film);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Feil lesing fra fil: " + e);
			System.exit(1);
		} finally {
			if(sc != null) {
				sc.close();
			}
		}

		return fa;
	}


}
