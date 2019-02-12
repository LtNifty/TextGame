package gameData;

import java.util.ArrayList;
import java.util.Scanner;

import gameData.Items.Potions.Potion;
import gameData.NPCs.*;
import gameData.Quests.*;
import gameData.Skills.Skill;

public class PlayerRun {
	public static void main(String[] args) {
		// declare && initialize all variables
		Player gamer = new Player("Sebastian", "Human", "Blacksmith", "Priest");

		//Things that need to be stored somewhere
		int skSortCh = 1;
		int qSort1 = 2, qSort2 = 1, qSort3 = 3;

		Scanner scan = new Scanner(System.in);
		// Character Creation Variables
		String name, race, minCareer, majCareer;


		PlayerRun.debugMenu(gamer);
	}

	public static void debugMenu(Player player) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Player gamer = player;

		boolean game = true, hold;
		int num;
		String str;

		while(game) {
			hold = true;
			System.out.println("<=-= DEBUG MENU =-=>"
					+ "\nWhat would you like to do?"
					+ "\n1. See Stats"
					+ "\n2. See Quests"
					+ "\n3. Exit Menu");
			num = scan.nextInt();

			switch(num) {
			default:
				System.out.println("\n" + num + " is not a valid response!\n");
				break;
			case 1:
				while(hold) {
					hold = true;
					System.out.println("What would you like to do?"
							+ "\n0. Return"
							+ "\n1. Print Skill List"
							+ "\n2. Print Skill Info");
					num = scan.nextInt();

					switch(num) {
					default:
						System.out.println("\n" + num + " is not a valid response!\n");
						break;
					case 0:
						hold = false;
						break;
					case 1:
						while(hold) {
							System.out.println("How would you like to sort?"
									+ "\n0. Return"
									+ "\n1. By Default"
									+ "\n2. By Increasing XP"
									+ "\n3. By Decreasing XP"
									+ "\n4. By Alphabet"
									+ "\n5. By Backwards Alphabet"
									+ "\n6. By Buffs First & Increasing XP"
									+ "\n7. By Buffs First & Decreasing XP"
									+ "\n8. By Buffs First & Alphabet"
									+ "\n9. By Buffs First & Backwards Alphabet"
									+ "\n10. By Buffs Last & Increasing XP"
									+ "\n11. By Buffs Last & Decreasing XP"
									+ "\n12. By Buffs Last & Alphabet"
									+ "\n13. By Buffs Last & Backwards Alphabet");
							num = scan.nextInt();

							if (num > 0 && num < 7) {
								System.out.println(gamer.printSkills(num));
								break;
							}
							else if (num != 0)
								System.out.println("\n" + num + " is not a valid response!\n");
							else
								break;
						}
						break;
					case 2:
						System.out.println("What skill would you like to print?");
						str = scan.next();

						if (Player.findSkill(str) == null)
							System.out.println("\n" + str + " could not be found!\n");
						else
							System.out.println(Player.findSkill(str).toString());
						break;
					}
				}
				break;
			case 2:
				while(hold) {
					System.out.println("What would you like to do?"
							+ "\n0. Return"
							+ "\n1. Print Quest List"
							+ "\n2. Print Quest Info");
					num = scan.nextInt();

					switch(num) {
					default:
						System.out.println("\n" + num + " is not a valid response!\n");
						break;
					case 0:
						hold = false;
						break;
					case 1:
						while(hold) {
							System.out.println("How would you like to sort?"
									+ "\n0. Return"
									+ "\n1. Ongoing/Incomplete/Complete"
									+ "\n2. Ongoing/Complete/Incomplete"
									+ "\n3. Complete/Ongoing/Incomplete"
									+ "\n4. Complete/Incomplete/Ongoing"
									+ "\n5. Incomplete/Ongoing/Completed"
									+ "\n6. Incomplete/Completed/Ongoing");
							num = scan.nextInt();

							if (num > 0 && num < 7) {
								System.out.println(gamer.printQuests(num));
								break;
							}
							else if (num != 0)
								System.out.println("\n" + num + " is not a valid response!\n");
							else
								break;
						}
						break;
					case 2:
						System.out.println("What quest would you like to print?");
						str = scan.next();

						if (Quest.quests.contains(str) == false)
							System.out.println("\n" + str + " could not be found!\n");
						else
							System.out.println(gamer.printQuest(str));
						break;
					}
				}
				break;
			case 3:
				game = false;
				break;
			}
		}
	}
}
