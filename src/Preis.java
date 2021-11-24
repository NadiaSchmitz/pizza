import java.text.DecimalFormat;

import Prog1Tools.IOTools;

public class Preis {

	public static void main(String[] args) {
		
		int dmKlein, dmMittel, dmGross;
		
		double kostenFest, kostenGrund, zutatenKosten, preisVerkauf, flaeche;
		
		String pizzaBestellung, pizzaPepperoni, pizzaPilze, pizzaZwiebeln;
		
		dmKlein = 26; // Sm
		dmMittel = 30; // Sm
		dmGross = 40; // Sm
		kostenFest = 2; // Euro pro Pizza
		kostenGrund = 0.01; // Euro pro Quadratzentimeter
		zutatenKosten = 0.0025; // Euro pro Quadratzentimeter
		
		DecimalFormat df = new DecimalFormat("###.##");
		
		pizzaBestellung = IOTools.readString("Welche Pizza würden Sie gerne haben? ");

		Pizza zubacken = new Pizza(pizzaBestellung, true, true, false, false, false);
		
		if (pizzaBestellung.equals("klein")) {
			flaeche = Math.pow(dmKlein, 2) * 3.14 / 4;
		} else if (pizzaBestellung.equals("mittel")) {
			flaeche = Math.pow(dmMittel, 2) * 3.14 / 4;
		} else {
			flaeche = Math.pow(dmGross, 2) * 3.14 / 4;
		}
		
		preisVerkauf = kostenFest + flaeche * kostenGrund;
		
		pizzaPepperoni = IOTools.readString("Würden Sie zusätzlich Pepperoni haben? ");
		
		if (pizzaPepperoni.equals("ja")) {
			zubacken.pepperoni = true;
			preisVerkauf = preisVerkauf + flaeche * 0.0025;
		} else {
			zubacken.pepperoni = false;
		}
		
		pizzaPilze = IOTools.readString("Würden Sie zusätzlich Pilze haben? ");
		
		if (pizzaPilze.equals("ja")) {
			zubacken.pilze = true;
			preisVerkauf = preisVerkauf + flaeche * 0.0025;
		} else {
			zubacken.pilze = false;
		}
		
		pizzaZwiebeln = IOTools.readString("Würden Sie zusätzlich Zwiebeln haben? ");
		
		if (pizzaZwiebeln.equals("ja")) {
			zubacken.zwiebeln = true;
			preisVerkauf = preisVerkauf + flaeche * 0.0025;
		} else {
			zubacken.zwiebeln = false;
		}
		
		preisVerkauf = preisVerkauf * 1.5;
		
		System.out.println();
		System.out.println("Ihre Rechnung bitte");
		System.out.println();
		System.out.println("------------------------");
		System.out.println("R E C H N U N G");
		System.out.println("------------------------");
		zubacken.pizzaBeschreibung();
		System.out.println("------------------------");
		System.out.println(df.format(preisVerkauf) + "€");
	}

}

class Pizza {
	
	String name; // Klein, mittel, gross
	
	boolean sause = true; // Sause
	
	boolean kaese = true; // Käse
	
	boolean pepperoni; // Pepperoni
	
	boolean pilze; // Pilze
	
	boolean zwiebeln; // Zwiebeln
	
	Pizza(String n, boolean s, boolean k, boolean pep, boolean pil, boolean z)
	
	{
		name = n;
		sause = true;
		kaese = true;
		pepperoni = pep;
		pilze = pil;
		zwiebeln = z;
	}
	
	void pizzaBeschreibung() {
		System.out.println("Pizza " + "< " + name + " >");
		System.out.println("------------------------");
		System.out.println("Zutaten");
		System.out.println("------------------------");
		System.out.println("Sause         " + sause);
		System.out.println("Käse          " + kaese);
		System.out.println("Pepperoni     " + pepperoni);
		System.out.println("Pilze         " + pilze);
		System.out.println("Zwiebeln      " + zwiebeln);
	}
	
	void anzahl() {} // Anzahl in einer Bestellung
	
	void preis() {} // Preis in einer Bestellung
	
}
