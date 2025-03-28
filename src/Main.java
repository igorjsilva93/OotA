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
			menu=Integer.parseInt(JOptionPane.showInputDialog("1 - Travel Plan\n2 - Creature Encounters\n3 - Travel Pace\n0 - Sair"));
			switch (menu) {
			case 1:{
				choice=Integer.parseInt(JOptionPane.showInputDialog(null, "Travel - Choise DarkLake or Underdark", "1 - Underdark - 2 - Darklake"));
				if(choice == 1) {
					days=Integer.parseInt(JOptionPane.showInputDialog(null, "Travel Days - Choose a number of travel days", "N of Days"));
					travelPlan(days, choice, travelPace);
					CreatureEncounter(20);
				}
				if(choice == 2) {
					int roll = 0;
				}
				else {
					System.out.println("Invalid option. Choose 1 or 2.");
					}
				break;
			}
			case 2:{
				CreatureEncounter(20);
				break;
			}
			case 3: {
                travelPace = JOptionPane.showInputDialog("Choose Travel Pace:\nSlow\nNormal\nFast");
                JOptionPane.showMessageDialog(null, "Travel pace set to: " + travelPace + "\n");
                break;
            }
			case 0:{
				menu=0;
			}
			default:
				break;
			}
			
		} while (menu==0);
		{
		}

	}

	
	private static void DarklakeRandomEncounter() {
	    Random random = new Random();
	    
	    // Pergunta ao jogador se os personagens estão ancorados (1) ou se estão em movimento (2)
	    int anchoredChoice = Integer.parseInt(JOptionPane.showInputDialog(
	            "Are the characters anchored or ashore?\n1 - Yes\n2 - No"));

	    int roll = random.nextInt(20) + 1; // d20

	    System.out.print("Darklake Encounter: ");

	    if (roll <= 13) {
	        System.out.println("No encounter.");
	    } else if (roll <= 15) {
	        int terrainRoll = random.nextInt(10) + 1; // d10 para Terrain Encounters
	        System.out.println("Terrain Encounter: " + getDarklakeTerrain(terrainRoll));
	    } else if (roll <= 17 || anchoredChoice == 1) { // Se estiver ancorado (1), sempre criatura
	        int creatureRoll = random.nextInt(12) + 1; // d12 para Creature Encounters
	        System.out.println("Creature Encounter: " + getDarklakeCreature(creatureRoll));
	    } else {
	        int terrainRoll = random.nextInt(10) + 1; // d10 para Terrain Encounters
	        int creatureRoll = random.nextInt(12) + 1; // d12 para Creature Encounters
	        System.out.println("Terrain and Creature Encounter: " + getDarklakeTerrain(terrainRoll) +
	                " featuring " + getDarklakeCreature(creatureRoll));
	    }
	}

	private static String getDarklakeTerrain(int roll) {
	    if (roll == 1) {
	        return "Collision";
	    } else if (roll == 2) {
	        return "Falls or locks";
	    } else if (roll == 3) {
	        return "Island";
	    } else if (roll == 4) {
	        return "Low ceiling";
	    } else if (roll == 5) {
	        return "Rockfall";
	    } else if (roll == 6) {
	        return "Rough current";
	    } else if (roll == 7) {
	        return "Run aground";
	    } else if (roll == 8) {
	        return "Stone teeth";
	    } else if (roll == 9) {
	        return "Tight passage";
	    } else if (roll == 10) {
	        return "Whirlpool";
	    } else {
	        return "Unknown terrain";
	    }
	}

	private static String getDarklakeCreature(int roll) {
	    if (roll == 1) {
	        return "A group of kuo-toa hunters";
	    } else if (roll == 2) {
	        return "A swarm of quippers";
	    } else if (roll == 3) {
	        return "A patrol of duergar slavers";
	    } else if (roll == 4) {
	        return "A hungry water weird";
	    } else if (roll == 5) {
	        return "A cave fisher lurking on a high ledge";
	    } else if (roll == 6) {
	        return "A roper disguised as a stalactite";
	    } else if (roll == 7) {
	        return "An umber hulk digging near the shoreline";
	    } else if (roll == 8) {
	        return "A group of drow scouts in a raft";
	    } else if (roll == 9) {
	        return "A giant octopus hunting for food";
	    } else if (roll == 10) {
	        return "A shipwrecked human survivor";
	    } else if (roll == 11) {
	        return "A group of myconid refugees";
	    } else if (roll == 12) {
	        return "A spectral ghost of a long-dead sailor";
	    } else {
	        return "Unknown creature";
	    }
	}


	private static void CreatureEncounter(int i) {
		Random random = new Random();
		int roll = random.nextInt(i);
		System.out.println("Encounter: ");
		System.out.println();
		if(roll>=1&&roll<=2) {
			System.out.println("Ambushers; reroll this encounter if the characters are resting. Page 28");
			AmbusherEncounter(20);
		}
		if(roll==3) {
			System.out.println("Carrion crawler Page 28");
			System.out.println("The characters encounter a carrion crawler scouring tunnels and caves for food.\r\n"
					+ "\r\n"
					+ "There is a 25 percent chance that the crawler is domesticated and outfitted with a leather saddle and harness, though there's no sign of "
					+ "the rider. A character can approach and mount the carrion crawler without being attacked by succeeding on a DC 13 Wisdom (Animal Handling) "
					+ "check. While in the saddle and harness, a rider can remain mounted on the carrion crawler as it crawls across walls and ceilings.");
			
		}
		if(roll>=4&&roll<=5) {
			System.out.println("Escaped slaves");
			EscapedSlaves();
		}
		if(roll>=6&&roll<=7) {
			System.out.println("Fungi");
			FungiEncounter();
		}
		if(roll>=8&&roll<=9) {
			System.out.println("Giant fire beetles");
			GiantFireBeetles();
		}
		if(roll>=10&&roll<=11) {
			System.out.println("Giant rocktopus");
			GiantRocktopus();
		}
		if(roll==12) {
			System.out.println("Mad creature");
			MadCreature();
		}
		if(roll==13) {
			System.out.println("Ochre jelly");
			OchreJelly();
		}
		if(roll>=14&&roll<=15) {
			System.out.println("Raiders");
			Raiders();
		}
		if(roll==16) {
			System.out.println("Scouts");
			ScoutsEncounter();
		}
		if(roll==17) {
			System.out.println("Society of Brilliance");
			SocietyOfBrilliance();
		}
		if(roll==18) {
			System.out.println("Spore servants");
			SporeServants();
		}
		if(roll>=19&&roll<=20) {
			System.out.println("Traders");
			Traders();
		}
	}
	
	private static void ScoutsEncounter() {
	    Random random = new Random();
	    int roll = random.nextInt(6) + 1; // d6

	    System.out.print("Encounter: ");
	    if (roll <= 2) {
	        System.out.println("1 drow scout searching for escaped slaves.");
	    } else if (roll <= 4) {
	        int myconids = random.nextInt(4) + 1; // 1d4
	        System.out.println(myconids + " myconid adults on a secret mission.");
	    } else {
	        int dwarves = random.nextInt(6) + 1; // 1d6
	        System.out.println(dwarves + " shield dwarf scouts. They are friendly if the party includes surface dwellers.");
	    }
	}

	private static void SocietyOfBrilliance() {
	    Random random = new Random();
	    int roll = random.nextInt(10) + 1; // d10

	    System.out.print("Encounter: ");
	    if (roll <= 2) {
	        System.out.println("Y the derro savant.");
	    } else if (roll <= 4) {
	        System.out.println("Blurg the orog.");
	    } else if (roll <= 6) {
	        System.out.println("Grazilaxx the mind flayer.");
	    } else if (roll <= 8) {
	        System.out.println("Skriss the troglodyte.");
	    } else {
	        System.out.println("Sloopidoop the kuo-toa archpriest.");
	    }

	    System.out.println("This member of the Society of Brilliance is investigating faerzress for possible demonic incursion.");
	}


	private static void OchreJelly() {
		System.out.println("As the characters move through a series of caves, they attract the attention of a ochre jelly. The ooze follows the "
				+ "characters, attacking when they stop to take their next rest. Characters in the back rank of the marching order who have a "
				+ "passive Wisdom (Perception) score of 14 or higher spot the ooze following them.");
	}

	private static void Traders() {
	    Random random = new Random();
	    int roll = random.nextInt(4) + 1; // d4

	    switch (roll) {
	        case 1:
	            System.out.println("Encounter: 2d4 deep gnome traders.");
	            break;
	        case 2:
	            System.out.println("Encounter: 2d4 drow traders.");
	            break;
	        case 3:
	            System.out.println("Encounter: 2d4 duergar traders.");
	            break;
	        case 4:
	            System.out.println("Encounter: 2d4 kuo-toa traders.");
	            break;
	    }

	    System.out.println("The traders carry goods worth 5d4 × 10 gp plus provisions.");
	}

	
	private static void SporeServants() {
	    Random random = new Random();
	    int roll = random.nextInt(10) + 1; // d10

	    if (roll <= 3) {
	        System.out.println("Encounter: 1d4 drow spore servants.");
	    } else if (roll <= 6) {
	        System.out.println("Encounter: 1d6 duergar spore servants.");
	    } else if (roll <= 8) {
	        System.out.println("Encounter: 1d4 hook horror spore servants.");
	    } else {
	        System.out.println("Encounter: 1d8 quaggoth spore servants.");
	    }
	}

	
	private static void Raiders() {
	    Random random = new Random();
	    int roll = random.nextInt(6) + 1; // d6

	    switch (roll) {
	        case 1:
			System.out.println("Encounter: 1d6 human bandits and 1 bandit captain.");
			break;
		case 2:
			System.out.println("Encounter: 1d6 human bandits and 1 bandit captain.");
			break;
		case 3:
			System.out.println("Encounter: 2d4 goblins and 1 goblin boss.");
			break;
		case 4:
			System.out.println("Encounter: 2d4 goblins and 1 goblin boss.");
			break;
		case 5:
			System.out.println("Encounter: 1d6 orcs and 1 Eye of Gruumsh.");
			break;
		case 6:
			System.out.println("Encounter: 1d6 orcs and 1 Eye of Gruumsh.");
			break;
	    }

	    int leaderItem = random.nextInt(20) + 1; // d20 para itens do líder
	    if (leaderItem >= 6 && leaderItem <= 10) {
	        System.out.println("Leader Possession: 2d6 10 gp gemstones.");
	    } else if (leaderItem >= 11 && leaderItem <= 14) {
	        System.out.println("Leader Possession: 2d6 50 gp gemstones.");
	    } else if (leaderItem >= 15 && leaderItem <= 17) {
	        System.out.println("Leader Possession: 1d4 torchstalks.");
	    } else if (leaderItem == 18 || leaderItem == 19) {
	        System.out.println("Leader Possession: 1d4 waterorbs.");
	    } else if (leaderItem == 20) {
	        System.out.println("Leader Possession: A random magic item (Table B).");
	    } else {
	        System.out.println("Leader Possession: None.");
	    }
	}

	
	private static void MadCreature() {
	    Random random = new Random();
	    int roll = random.nextInt(4) + 1; // d4

	    switch (roll) {
	        case 1:
	            System.out.println("Encounter: 1 Deep Gnome driven mad by the demon lords.");
	            break;
	        case 2:
	            System.out.println("Encounter: 1 Drow, insane and aggressive.");
	            break;
	        case 3:
	            System.out.println("Encounter: 1 Duergar, suffering from madness.");
	            break;
	        case 4:
	            System.out.println("Encounter: 1 Stone Giant, mentally unstable.");
	            break;
	    }

	    int itemRoll = random.nextInt(20) + 1; // d20 para itens da criatura insana
	    if (itemRoll >= 11 && itemRoll <= 13) {
	        System.out.println("Possession: A 10 gp gem.");
	    } else if (itemRoll == 14 || itemRoll == 15) {
	        System.out.println("Possession: A gold ring worth 25 gp.");
	    } else if (itemRoll == 16 || itemRoll == 17) {
	        System.out.println("Possession: An obsidian statuette of Lolth worth 100 gp.");
	    } else if (itemRoll == 18 || itemRoll == 19) {
	        System.out.println("Possession: A random magic item (Table A).");
	    } else if (itemRoll == 20) {
	        System.out.println("Possession: A random magic item (Table B).");
	    } else {
	        System.out.println("Possession: None.");
	    }
	}

	private static void GiantRocktopus() {
	    System.out.println("Encounter: A Giant Rocktopus camouflaging as a rock formation, waiting to ambush creatures.");
	}

	private static void GiantFireBeetles() {
	    Random random = new Random();
	    int roll = random.nextInt(6) + 1 + random.nextInt(6) + 1 + random.nextInt(6) + 1; // 3d6

	    System.out.println("Encounter: " + roll + " Giant Fire Beetles scouring tunnels for food.");
	}


	private static void BeholderMemory() {
	    Random random = new Random();
	    int roll = random.nextInt(4) + 1; // d4

	    switch (roll) {
	        case 1:
	            System.out.println("Memory: A tense negotiation with drow, agreeing to allow safe passage in exchange for help ridding its lair of a deep gnome infestation.");
	            break;
	        case 2:
	            System.out.println("Memory: Chasing svirfneblin thieves through tunnels to recover stolen gemstones.");
	            break;
	        case 3:
	            System.out.println("Memory: A fierce battle against a wizened drow archmage, suffering a grievous injury.");
	            break;
	        case 4:
	            System.out.println("Memory: Spying on a drow ranger with two gleaming scimitars and a black, quadrupedal animal companion.");
	            break;
	    }
	}

	private static void EscapedSlaves() {
		    Random random = new Random();
		    int roll = random.nextInt(4) + 1; // Garante um valor entre 1 e 4

		    if (roll == 1) {
		        int count = random.nextInt(2) + 1; // 1d2
		        System.out.println("Encounter: " + count + " Moon Elf Commoner(s).");
		    } 
		    else if (roll == 2) {
		        int count = random.nextInt(3) + 1; // 1d3
		        System.out.println("Encounter: " + count + " Shield Dwarf Commoner(s).");
		    } 
		    else if (roll == 3) {
		        int count = random.nextInt(4) + 1; // 1d4
		        System.out.println("Encounter: " + count + " Human Commoner(s).");
		    } 
		    else if (roll == 4) {
		        int count = random.nextInt(6) + 1; // 1d6
		        System.out.println("Encounter: " + count + " Goblin(s).");
		    }
		}
	private static void FungiEncounter() {
	    Random random = new Random();
	    int roll = random.nextInt(6) + 1; // Garante um valor entre 1 e 6

	    if (roll >= 1 && roll <= 2) {
	        int count = random.nextInt(4) + 1; // 1d4
	        System.out.println("Encounter: " + count + " Gas Spore(s).");
	    } 
	    else if (roll >= 3 && roll <= 4) {
	        int count = random.nextInt(4) + 1; // 1d4
	        System.out.println("Encounter: " + count + " Shrieker(s).");
	    } 
	    else if (roll >= 5 && roll <= 6) {
	        int count = random.nextInt(4) + 1; // 1d4
	        System.out.println("Encounter: " + count + " Violet Fungi.");
	    }
	}


	private static void AmbusherEncounter(int i) {
		Random random = new Random();
		int roll = random.nextInt(20);
		if(roll>=1&&roll<=2) {
			System.out.println("1 chuul lurking in a pool of water");
		}
		else if(roll==3) {
			roll = random.nextInt(6);
			System.out.println("(1d6) or" + roll + " giant spiders clinging to the walls or ceiling");
		}
		else if(roll<=4&&roll>=5) {
			System.out.println("1 grell floating near the high ceiling");
		}
		else if(roll<=6&&roll>=9) {
			roll = random.nextInt(4);
			System.out.println("1d4 or" + roll +" gricks hiding in a crevice or fissure");
		}
		else if(roll>=10&&roll<=15) {
			roll = random.nextInt(4);
			System.out.println("1d4 orogs perching on ledges");
		}
		else if(roll>=16&&roll<=17) {
			roll= random.nextInt(6);
			System.out.println("1d6 or" + roll +" piercers masquerading as stalactites");
		}
		else if(roll>=18&&roll<=20) {
			System.out.println("1 umber hulk bursting out of a nearby wall");
		}
	}
	
	private static void AmbushLair() {
	    Random random = new Random();
	    int roll = random.nextInt(20) + 1; // Garante um valor entre 1 e 20

	    if (roll >= 1 && roll <= 10) {
	        System.out.println("Discovery: None");
	    } 
	    else if (roll >= 11 && roll <= 12) {
	        System.out.println("Discovery: A humanoid skeleton or corpse clutching a salvageable, nonmagical weapon.");
	    } 
	    else if (roll >= 13 && roll <= 14) {
	        System.out.println("Discovery: A humanoid skeleton or corpse wearing a salvageable suit of nonmagical armor.");
	    } 
	    else if (roll >= 15 && roll <= 17) {
	        int gems = random.nextInt(6) + 1; // 1d6
	        System.out.println("Discovery: " + gems + " gems worth 50 gp each.");
	    } 
	    else if (roll >= 18 && roll <= 19) {
	        System.out.println("Discovery: A humanoid skeleton or corpse carrying a random magic item (roll once on Magic Item Table B).");
	    } 
	    else if (roll == 20) {
	        int gems = (random.nextInt(6) + 1) + (random.nextInt(6) + 1); // 2d6
	        int magicItems = random.nextInt(4) + 1; // 1d4
	        System.out.println("Discovery: A monster hoard containing " + gems + " gems worth 50 gp each and " + magicItems + 
	                           " random magic item(s) (roll on Magic Item Table C).");
	    }
	}


	private static void TravelPace(String travelPace) {
		if(travelPace=="Normal") {
			System.out.println("Pace: Normal - Miles per Day: 6 - Effect: N/A");
		}
		if(travelPace=="Fast") {
			System.out.println("Pace: Fast - Miles per Day: 8 - Effect: −5 penalty to passive Wisdom (Perception) scores; no foraging");
		}
		else if(travelPace=="Slow") {
			System.out.println("Pace: Slow - Miles per Day: 4 - Effect: Improved foraging, or able to use Stealth");
		}
		
	}

	private static void travelPlan(int days, int choice, String travelPace) {
		Random random = new Random();
		for (int day = 1; day <= days; day++) {
			System.out.println("\n");
			System.out.println("Day: "+day);
			if(choice==1) {
				//System.out.println("Setup");
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
	        "Boneyard", "Cliff and Ladder", "Crystal clusters", "Fungus cavern", "Gas leak",
	        "Gorge", "High ledge", "Horrid sounds", "Lava swell", "Muck pit",
	        "Rockfall", "Rope bridge", "Ruins", "Shelter", "Sinkhole",
	        "Slime or mold", "Steam vent", "Underground stream", "Warning sign", "Webs"
	    };

	    int roll = random.nextInt(20); // Gera um número entre 0 e 19
	    if (terrainsEn.equals("Boneyard") || terrainsPt.equals("Cemitério de ossos")) {
	        BoneyardEncounter(random);
	    }
	    if(terrainsEn.equals("Cliff and Ladder") || terrainsPt.equals("Cemitério de ossos")) {
	    	System.out.println("A cliff 2d4 × 10 feet high blocks the party's passage, but a rolled-up rope ladder is visible at the top. If someone can climb the "
	    			+ "cliff—requiring a successful DC 15 Strength (Athletics) check—and toss down the ladder, the characters can proceed. Otherwise, they lose a day's "
	    			+ "travel finding another route. "
	    			+ "If the characters remove the ladder once they are at the top, they decrease the drow pursuit level by 1. Page 26");
	    }
	    if(terrainsEn.equals("Crystal clusters") ||terrainsPt.equals("Cristais")) {
	    	System.out.println("The adventurers pass through a faerzress-suffused area containing fist-sized chunks of quartz that shed dim "
	    			+ "light in a 10-foot radius. A sharp blow to one of the crystals, including throwing it so it impacts a hard surface, "
	    			+ "causes it to burst in a 10-foot-radius flash of blinding light. Any creature within the radius must succeed on a "
	    			+ "DC 10 Constitution saving throw or be blinded for 1 minute. A creature blinded by this effect repeats the Constitution "
	    			+ "saving throw at the end of each of its turns. On a successful save, it is no longer blinded.\r\n"
	    			+ "\r\n"+ "The characters can harvest up to twelve of the crystals in total, but taking the time to do so "
	    					+ "increases the drow pursuit level by 1. "
	    					+ "Page 26");
	    }
	    
	    if (terrainsEn.equals("Fungus cavern") || terrainsPt.equals("Caverna de fungos")) {
	        System.out.println("The adventurers stumble upon a cavern filled with fungi and mushrooms of all sizes and types. "
	        		+ "See \"Fungi of the Underdark\" and "
	        		+ "choose some interesting examples."
	        		+ "Page 26");
	    }

	    if (terrainsEn.equals("Gas leak") || terrainsPt.equals("Vazamento de gás")) {
	        System.out.println("The adventurers come upon a cavern with a dangerous natural gas leak. Any member of the party with a passive "
	        		+ "Wisdom (Perception) score of 14 or higher detects signs of the gas. The characters' travel pace for the day is slowed by half as "
	        		+ "they circumvent the area, but there are no ill effects. If the gas goes undetected, each character in the area must make a "
	        		+ "DC 12 Constitution saving throw, taking 5 (1d10) poison damage on a failed save, or half as much damage on a successful one. "
	        		+ "Any open flames brought into the area cause the gas to explode. Each creature in the explosion must make a DC 15 Dexterity saving throw, "
	        		+ "taking 10 (3d6) fire damage on a failed save, or half as much damage on a successful one."
	        		+ "Page 26");
	    }

	    if (terrainsEn.equals("Gorge") || terrainsPt.equals("Desfiladeiro")) {
	        System.out.println("The characters must make a difficult climb down a gorge 2d4 × 100 feet deep and up the other side, or "
	        		+ "find a way around it. Their travel pace for the day is slowed by half unless they come up with a plan to cross the gorge quickly. "
	        		+ "Page 26");
	    }

	    if (terrainsEn.equals("High ledge") || terrainsPt.equals("Ledge alto")) {
	        System.out.println("The characters must walk along an 18-inch-wide ledge that skirts a ravine 2d6 × 10 feet deep. The party's travel pace "
	        		+ "for the day is slowed by half, and each character must succeed on a DC 10 Dexterity saving throw to avoid a fall. Precautions "
	        		+ "such as roping everyone together let each character make the save with advantage. Increase the pursuit level of the drow by 1. "
	        		+ "Page 26");
	    }

	    if (terrainsEn.equals("Horrid sounds") || terrainsPt.equals("Sons horríveis")) {
	        System.out.println("For hours, the party's travel is plagued by terrible shrieks, moans, and incoherent gibbering echoing through "
	        		+ "nearby passages, without any apparent origin. Each character must make a successful DC 11 Wisdom saving throw. On a failed save, "
	        		+ "the character's madness level increases by 1. Page 26");
	    }

	    if (terrainsEn.equals("Lava swell") || terrainsPt.equals("Inchaço de lava")) {
	        System.out.println("As the party traverses a long and winding corridor, a tremor opens up a lava-filled fissure behind them. Each "
	        		+ "character must make a DC 10 Dexterity saving throw to avoid the lava swell, taking 21 (6d6) fire damage on a failed save. "
	        		+ "Decrease the drow pursuit level by 1. Page 26");
	    }

	    if (terrainsEn.equals("Muck pit") || terrainsPt.equals("Poço de lama")) {
	        System.out.println("The adventurers must wade through a broad, 3-foot-deep pit of slimy muck. The muck is difficult terrain and characters "
	        		+ "have disadvantage on Dexterity saving throws while within it, but their travel pace for the day is slowed by half if "
	        		+ "they go around it. Page 26");
	    }

	    if (terrainsEn.equals("Rockfall") || terrainsPt.equals("Desmoronamento de rochas")) {
	        System.out.println("As the adventurers make their way through a long, twisting cavern, a tremor sets off a rockfall. Each party member "
	        		+ "must attempt three DC 12 Dexterity saving throws, taking 10 (3d6) bludgeoning damage on each failed save. Any incapacitated "
	        		+ "creature not moved out of the area is buried under rubble, taking an additional 1d6 bludgeoning damage at the end of each of its "
	        		+ "turns until the creature is dug out or dead. Decrease the drow pursuit level by 1. Page 26");
	    }

	    if (terrainsEn.equals("Rope bridge") || terrainsPt.equals("Ponte de corda")) {
	        System.out.println("A ravine 2d4 × 10 feet wide and 2d4 × 10 feet deep cuts across the party's path, spanned by an old rope bridge. "
	        		+ "If the characters cut the bridge after they pass, the drow pursuit level decreases by 1. Page 26");
	    }

	    if (terrainsEn.equals("Ruins") || terrainsPt.equals("Ruínas")) {
	        System.out.println("The adventurers come across a small ruin hidden in the Underdark. This might be the creation of a subterranean "
	        		+ "race or a surface ruin that collapsed and sank long ago. If the characters search the ruins, there is a 50 percent chance "
	        		+ "of them finding 1d4 trinkets (see chapter 5, \"Equipment,\" of the Player's Handbook). Roll on the Trinkets table or choose "
	        		+ "appropriate ones. Page 27");
	    }

	    if (terrainsEn.equals("Shelter") || terrainsPt.equals("Abrigo")) {
	        System.out.println("The party stumbles upon a cave that is sheltered and easily defended. If the characters camp here, they can finish a long rest without "
	        		+ "any chance of an encounter while they are resting. Page 27");
	    }

	    if (terrainsEn.equals("Sinkhole") || terrainsPt.equals("Sumidouro")) {
	        System.out.println("One random party member steps on and collapses a sinkhole, and must succeed on a DC 12 Dexterity saving throw to "
	        		+ "avoid falling into a 20-foot-deep pit and taking 7 (2d6) bludgeoning damage. Climbing out of the pit requires a successful "
	        		+ "DC 15 Strength (Athletics) check. Page 27");
	    }

	    if (terrainsEn.equals("Slime or mold") || terrainsPt.equals("Lodo ou mofo")) {
	        System.out.println("As the adventurers pass through a small cavern, they encounter a patch of slime or mold. Roll a d6 and consult the "
	        		+ "table to determine what type of slime or mold is present (see \"Dungeon Hazards\" in chapter 5 of the Dungeon Master's "
	        		+ "Guide for details on these threats). Page 27");
	        SlimeEncounter(random);
	    }

	    if (terrainsEn.equals("Steam vent") || terrainsPt.equals("Respiro de vapor")) {
	        System.out.println("A hot steam vent erupts beneath a random party member, who must succeed on a "
	        		+ "DC 12 Dexterity saving throw or take 7 (2d6) fire damage. Page 27");
	    }

	    if (terrainsEn.equals("Underground stream") || terrainsPt.equals("Corrente subterrânea")) {
	        System.out.println("A waterway 2d4 × 5 feet wide cuts across the party's path. The stream is shallow and easily crossed, "
	        		+ "and the characters can drink and refresh their water supplies. Edible fish inhabit the stream, so that the DC of any "
	        		+ "foraging attempts for food in this area is reduced to 10. Crossing the stream reduces the drow pursuit level by 1. Page 27");
	    }

	    if (terrainsEn.equals("Warning sign") || terrainsPt.equals("Sinal de alerta")) {
	        System.out.println("The characters enter a cavern dotted with stalagmites and stalactites. Those with a passive Wisdom (Perception) score of 11 or higher spot the sigil to the right carved into one of the stalagmites.\r\n"
	        		+ "\r\n"
	        		+ "The sigil is a drow warning sign that means \"Demons ahead!\" Any non-drow creature that touches the symbol must make a DC 10 Wisdom saving throw. On a failed save, the creature's madness level increases by 1.\r\n"
	        		+ "\r\n"
	        		+ "If the characters take a long rest within one mile of the warning sign, roll a d20 and consult the table to determine what, if anything, they encounter at the end of their rest. Page 27");
	        WarningEncounter(random);
	    }

	    if (terrainsEn.equals("Webs") || terrainsPt.equals("Teias")) {
	        System.out.println("Sticky webs fills a passage (see \"Dungeon Hazards\" in chapter 5 of the Dungeon Master's Guide). The webs extend for hundreds of feet. Unless the characters come up with a plan for clearing the webs quickly, the party's travel pace for the day is halved as the characters are forced to cut their way through or find an alternate route.\r\n"
	        		+ "\r\n"
	        		+ "Check for an encounter when the party enters the webs. On a roll of 1–2 on a d6, the characters encounter 1d4 giant spiders lurking among the webs. Page 27");
	    }


	    return isPortuguese ? terrainsPt[roll] : terrainsEn[roll];
	}

	private static void WarningEncounter(Random random) {
		int roll = random.nextInt(20);
		if(roll>=1&&roll<=14) {
			System.out.println("No encounter");
		}
		else if(roll>=15&&roll<=16) {
			System.out.println("1 invisible barlgura");
		}
		else if(roll>=17&&roll<=18) {
			roll = random.nextInt(12);
			System.out.println("(3d4) or" + roll +" dretches");
		}
		else if (roll>=19&&roll<=20) {
			roll = random.nextInt(2);
			System.out.println("(1d2) or " + roll +" shadow demons");
		}
		
	}

	private static void SlimeEncounter(Random random) {
		int roll = random.nextInt(6);
		if(roll>=1&&roll<=3) {
			System.out.println("Patch of green slime");
		}
		else if(roll>=4&&roll<=5) {
			System.out.println("Patch of yellow mold");
		}
		else {
			System.out.println("Patch of brown mold");
		}
		
	}

	private static void BoneyardEncounter(Random random) {
		int roll = random.nextInt(20);
		if(roll>=1&&roll<=14) {
			System.out.println("No encounter");
		}
		else if(roll>=15&&roll<=18) {
			roll = random.nextInt(12);
			System.out.println("(3d4) +" + roll+" skeletons");
		}
		else {
			roll = random.nextInt(3);
			System.out.println("(1d3) " + roll +" minotaur skeleton");
		}
		
	}


}
