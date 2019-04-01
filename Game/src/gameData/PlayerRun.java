package gameData;

import java.util.Scanner;

import gameData.Quests.*;
import gameData.Skills.Skill;

public class PlayerRun {
	public static void main(String[] args) {
		// declare && initialize all variables
		Player gamer = new Player("Sebastian", "Human", "Blacksmith", "Priest");
		Quest q1 = new TestQuest();
		Scanner scan = new Scanner(System.in);

		// Character Creation Variables
		String name, race, minCareer, majCareer;

		Scanner sc = new Scanner(System.in);
		int number;
		do {
			System.out.println("< DEBUG MENU >"
					+ "\n1. Stats"
					+ "\n2. Quests"
					+ "\n3. Exit");
			sc.next(); // this is important!
		} while (!sc.hasNextInt());
		number = sc.nextInt();

		PlayerRun.debugMenu(gamer);
	}

	public static void debugMenu(Player p) {
		Scanner scan = new Scanner(System.in);
		boolean inMenu = true;
		Quest q;
		Skill s;

		do {
			do {
				System.out.println("< DEBUG MENU >"
						+ "\n1. Stats"
						+ "\n2. Quests"
						+ "\n3. Exit");
				scan.next();
			} while(!scan.hasNextInt());
			switch(scan.nextInt()) {
			default:
				System.out.println("Invalid response!");
				break;
			case 1:
				break;
			case 2:
				while (inMenu) {
					do {
						System.out.println("< QUESTS >"
								+ "\n1. Print Quest List"
								+ "\n2. Select Quest"
								+ "\n3. Return");
						scan.next();
					} while(!scan.hasNextInt());
					switch(scan.nextInt()) {
					default:
						System.out.println("Invalid response!`	");
						break;
					case 1:
						System.out.println("< PRINT QUEST LIST >"
								+ "\n1. Decreasing Progress"
								+ "\n2. Increasing Progress"
								+ "\n3. Alphabetically"
								+ "\n4. Reverse-Alphabetically"
								+ "\n5. Return");
						try {
							System.out.println("< QUEST LIST >\n" + p.printQuests(scan.nextInt()) + "\n");
						} catch (Exception e) {
							System.out.println("ERROR: Invalid input (expected int)!");
						}
						break;
					case 2:
						System.out.println("< SELECT QUEST >"
								+ "\n" + p.printQuests(3)
								+ "\nType in name of quest...");
						try {
							q = Player.findQuest(scan.next());
						}
						catch (Exception e) {
							System.out.println("ERROR: Invalid input (expected String)!");
							break;
						}
						if (q.equals(null))
							System.out.println("Unable to find quest!");
						else
							while (inMenu) {
								System.out.println("< " + q.getName().toUpperCase() + " (" + q.progress() + "%) " + ">"
										+ "\n1. Quest Info"
										+ "\n2. Get Progress"
										+ "\n3. Advance Quest"
										+ "\n4. Can I Start Quest?"
										+ "\n5. Add Rewards"
										+ "\n6. Return");
								switch(scan.nextInt()) {
								default:
									System.out.println("Invalid response!");
									break;
								case 1:
									System.out.println(q.toString() + "\n");
									break;
								case 2:
									System.out.println("Phase: " + q.getPhase() + "/" + q.getMaxPhase() +"\n");
									break;
								case 3:
									q.nextPhase();
									break;
								case 4:
									System.out.println(p.isReady(q) + "\n");
									break;
								case 5:
									p.addQuestStats(q);
									break;
								case 6:
									inMenu = false;
									break;
								}
							}
						inMenu = true;
						break;
					case 3:
						inMenu = false;
						break;
					}
				}
				inMenu = true;
				break;
			case 3:
				inMenu = false;
				break;
			}
		} while(inMenu);
	}

	public static void debugMenu1(Player player) {
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
									+ "\n2. By Lowest XP First"
									+ "\n3. By Highest XP First"
									+ "\n4. By Alphabet"
									+ "\n5. By Backwards Alphabet");
							num = scan.nextInt();

							if (num > 0 && num < 6) {
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
					hold = true;
					System.out.println("What would you like to do?"
							+ "\n0. Return"
							+ "\n1. Print Quest List"
							+ "\n2. Select Quest");
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
									+ "\n1. Decreasing Progress"
									+ "\n2. Increasing Progress"
									+ "\n3. Alphabetically"
									+ "\n4. Reverse-Alphabetically");
							num = scan.nextInt();

							if (num > 0 && num < 5) {
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
						System.out.println("What quest would you like to select?");
						str = scan.next();

						Quest quest = Player.findQuest(str);

						if (quest.equals(null))
							System.out.println("\n" + str + " could not be found!\n");
						else
							while(hold) {
								System.out.println("<=-= " + quest.getName() + " =-=>"
										+ "\n0. Return"
										+ "\n1. Advance Phase"
										+ "\n2. Print Description"
										+ "\n3. Print Requirements"
										+ "\n4. Print Rewards"
										+ "\n5. Print it All");
								num = scan.nextInt();

								switch(num) {
								default:
									System.out.println(num + " is not a valid response!\n");
									break;
								case 0:
									break;
								case 1:
									quest.nextPhase();
									break;
								case 2:
									String reqs = "";

									for (Skill skill : quest.getReqs()) {
										reqs += "- Level " + skill.getLvl() + " " + skill.getName() + "\n";
									}

									System.out.println("Requirements to Start " + quest.getName()
									+ "\n" + reqs);
									break;
								case 3:
									String rewards = "";

									for (Skill skill : quest.getRewards()) {
										rewards += "- " + skill.getXp() + " " + skill.getName() + " XP\n";
									}

									System.out.println("Rewareds Upon Completion of " + quest.getName()
									+ "\n" + rewards);
									break;
								case 4:
									System.out.println(quest.toString());
									break;
								}
							}
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
