import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String travelPace="Normal";
		boolean idioma=false;
		int days=0, choice, menu=1;
		
		//idioma = (String) JOptionPane.showInputDialog(null, "Choose a Language:", "Seleção de Idioma", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Português", "Inglês"}, idioma);
		do {
			choice=Integer.parseInt(JOptionPane.showInputDialog(null, "Travel - Choise DarkLake or Underdark", "1 - Underdark - 2 - Darklake"));
			if(choice == 1) {
				days=Integer.parseInt(JOptionPane.showInputDialog(null, "Travel Days - Choose a number of travel days", "N of Days"));
				travelPlan(days, choice, travelPace);
			}
			if(choice == 2) {
				
			}
			else {
				System.out.println("Invalid option. Choose 1 or 2.");
				}
		} while (menu==0);
		{
		}

	}

	private static void TravelPace(String travelPace) {
		if(travelPace=="Normal") {
			System.out.println("Pace: Normal - Miles per Day: 6 - Effect: N/A");
		}
		if(travelPace=="Fast") {
			System.out.println("Pace: Fast - Miles per Day: 8 - Effect: −5 penalty to passive Wisdom (Perception) scores; no foraging");
		}
		else {
			System.out.println("Pace: Slow - Miles per Day: 4 - Effect: Improved foraging, or able to use Stealth");
		}
		
	}

	private static void travelPlan(int days, int choice, String travelPace) {
		Random random = new Random();
		for (int day = 1; day <= days; day++) {
			System.out.println("Day: "+day);
			if(choice==1) {
				System.out.println("Encounter Setup:\n");
				MarchingOrder(6);
				Illumination(6);
				TravelPace(travelPace);
				RollUnderdarkEncounters(20);
			}
		}
		
	}

	private static void Illumination(int i) {
		System.out.println("Illumination: ");
		if(i <=1 && i>=3) {
			System.out.println("The area is dimly lit by the phosphorescent moss and lichen common in the Underdark, or by faerzress (see \"Faerzress\") Page 21");
		}
		else {
			System.out.println("The area is dark except for whatever light sources the characters might have.");
		}
	}

	private static void MarchingOrder(int i) {
		System.out.println("Marching Order: ");
		if(i <=1 && i >= 2) {
			System.out.println("The party is traveling through a narrow passageway, so position the adventurers in the single-file marching order");
		}
		else if (i >= 3 && i <=4) {
			System.out.println("The characters are traveling through a standard passageway and can use the two-abreast marching order.");
		}
		else {
			System.out.println("The encounter occurs in a large open area, so allow the players to position the characters wherever they like.");
		}
	}

	private static void RollUnderdarkEncounters(int i) {
		Random random = new Random();
		if (i <= 13) { 
		    System.out.println("No Encounter");
		} 
		else if (i == 14 || i == 15) { 
		    System.out.println("Terrain: " + GetTerrainEncounter(random, false));
		}
	}

	private static String GetTerrainEncounter(Random random, boolean isPortuguese ) {
	    String[] terrainsPt = {
	        "Cemitério de ossos", "Escada de penhasco", "Cristais", "Caverna de fungos", "Vazamento de gás",
	        "Desfiladeiro", "Ledge alto", "Sons horríveis", "Inchaço de lava", "Poço de lama",
	        "Desmoronamento de rochas", "Ponte de corda", "Ruínas", "Abrigo", "Sumidouro",
	        "Lodo ou mofo", "Respiro de vapor", "Corrente subterrânea", "Sinal de alerta", "Teias"
	    };

	    String[] terrainsEn = {
	        "Boneyard", "Cliff and ladder", "Crystal clusters", "Fungus cavern", "Gas leak",
	        "Gorge", "High ledge", "Horrid sounds", "Lava swell", "Muck pit",
	        "Rockfall", "Rope bridge", "Ruins", "Shelter", "Sinkhole",
	        "Slime or mold", "Steam vent", "Underground stream", "Warning sign", "Webs"
	    };

	    int roll = random.nextInt(20); // Gera um número entre 0 e 19
	    return isPortuguese ? terrainsPt[roll] : terrainsEn[roll];
	}


}
