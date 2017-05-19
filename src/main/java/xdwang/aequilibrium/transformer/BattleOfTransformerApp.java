package xdwang.aequilibrium.transformer;

import java.util.Scanner;

/**
 * @author mwang
 * Main entry
 */
public class BattleOfTransformerApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		BattleField battleField = new BattleField();
		
		while (true) {
			System.out.print("Choose an option ('A' = Add a transformer; 'F' = Fight; 'E' = Exit): ");
			String option = scanner.next();
			if ("A".equals(option.trim())){
				String teamName = null;
				while (teamName == null) {
					System.out.print("Enter team name ('A' = Autobots or 'D' = Decepticons ): ");
					String input = scanner.next();
					if ("A".equals(input.trim()))
						teamName = Transformer.TEAM_AUTOBOT;
					else if ("D".equals(input.trim()))
						teamName = Transformer.TEAM_DECEPTION;
				}

				String name = null;
				while (name == null) {
					System.out.print("Enter transformer name (not empty): ");
					String input = scanner.next();
					if (input.trim().length() > 0)
						name = input.trim();
				}

				int strength = -1;
				while (strength < 0) {
					System.out.print("Enter Strength (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							strength = in;
					} catch (Exception e) {
					}
				}

				int intelligence = -1;
				while (intelligence < 0) {
					System.out.print("Enter Intelligence (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							intelligence = in;
					} catch (Exception e) {
					}
				}

				int speed = -1;
				while (speed < 0) {
					System.out.print("Enter Speed (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							speed = in;
					} catch (Exception e) {
					}
				}

				int endurance = -1;
				while (endurance < 0) {
					System.out.print("Enter Endurance (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							endurance = in;
					} catch (Exception e) {
					}
				}

				int rank = -1;
				while (rank < 0) {
					System.out.print("Enter Rank (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							rank = in;
					} catch (Exception e) {
					}
				}

				int courage = -1;
				while (courage < 0) {
					System.out.print("Enter Courage (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							courage = in;
					} catch (Exception e) {
					}
				}

				int firepower = -1;
				while (firepower < 0) {
					System.out.print("Enter Firepower (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							firepower = in;
					} catch (Exception e) {
					}
				}

				int skill = -1;
				while (skill < 0) {
					System.out.print("Enter Skill (1 - 10): ");
					try {
						String input = scanner.next();
						int in = Integer.parseInt(input.trim());
						if (in >= 1 && in <= 10)
							skill = in;
					} catch (Exception e) {
					}
				}
				
				Transformer transformer = new Transformer.Builder(teamName, name).strength(strength).intelligence(intelligence)
						.speed(speed).endurance(endurance).rank(rank).courage(courage).firepower(firepower)
						.skill(skill).build();
				
				
				System.out.println(String.format("%s, your age is %d", teamName, strength));
				System.out.println(transformer);
				battleField.registerFighter(transformer);			
			}

			else if ("F".equals(option.trim())){
				scanner.close();
				battleField.fight(Transformer.TEAM_AUTOBOT, Transformer.TEAM_DECEPTION);
				return;				
			}

			else if ("E".equals(option.trim())){
				scanner.close();
				System.out.println("-- Thank you for playing, bye --");
				return;				
			}

		}

	}

}
