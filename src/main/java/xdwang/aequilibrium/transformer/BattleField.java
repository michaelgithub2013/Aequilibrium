package xdwang.aequilibrium.transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author mwang
 * Battle place for any teams of fighters
 */
public class BattleField {
	private HashMap<String, LinkedList<Fighter>> teams = new HashMap<>();

	// valid team must have a name and at least one fighter.
	public void registerFighter(Fighter fighter) {
		if (fighter == null || fighter.getTeamName() == null || fighter.getTeamName().trim().length() == 0)
			throw new IllegalArgumentException("Can not register null as fighter");
		LinkedList<Fighter> team = teams.get(fighter.getTeamName());
		if (team == null) {
			team = new LinkedList<Fighter>();
			teams.put(fighter.getTeamName(), team);
		}
		team.add(fighter);

	}

	public String validateTeam(String teamName) {
		if (teams.containsKey(teamName))
			return null;
		return "The team does not exist: " + teamName + ".";
	}

	public void fight(String teamName1, String teamName2) {
		// validation...
		String errMsg = validateTeam(teamName1);
		if (errMsg != null) {
			System.out.println(errMsg);
			return;
		}

		errMsg = validateTeam(teamName2);
		if (errMsg != null) {
			System.out.println(errMsg);
			return;
		}

		// ...start fighting...
		Collections.sort(teams.get(teamName1), new FighterRankComparator());
		Collections.sort(teams.get(teamName2), new FighterRankComparator());

		Map<String, Integer> originalTeamSizes = new HashMap<>();
		originalTeamSizes.put(teamName1, teams.get(teamName1).size());
		originalTeamSizes.put(teamName2, teams.get(teamName2).size());
		int totalBattle = (originalTeamSizes.get(teamName1) > originalTeamSizes.get(teamName2)
				? originalTeamSizes.get(teamName2) : originalTeamSizes.get(teamName1));
		int index = totalBattle - 1;
		// use this flag to mark super VS super
		boolean hasSuperVsSuper = false;
		while (index >=0 ) {
			Fighter fighter1 = teams.get(teamName1).get(index);
			Fighter fighter2 = teams.get(teamName2).get(index);
			// once super VS super. all competitors will be destroyed
			if (fighter1.isSuper() && fighter2.isSuper()) {
				hasSuperVsSuper = true;
				break;
			}

			// in a regular fight, keep winner, destroy loser and tied ones
			int result = fighter1.fight(fighter2);
			if (result > 0)
				teams.get(teamName2).remove(fighter2);
			else if (result < 0)
				teams.get(teamName1).remove(fighter1);
			else {
				teams.get(teamName1).remove(fighter1);
				teams.get(teamName2).remove(fighter2);
			}
			index--;
		}

		// if Super VS Super happened, destroy all competitors
		if (hasSuperVsSuper) {
			// survivors should only be the ones who did not attend the fighting
			for (int i = 0; i < teams.get(teamName1).size() - (originalTeamSizes.get(teamName1) - totalBattle); i++)
				teams.get(teamName1).remove(i);

			for (int i = 0; i < teams.get(teamName2).size() - (originalTeamSizes.get(teamName2) - totalBattle); i++)
				teams.get(teamName2).remove(i);
		}

		// ... end of fighting ...

		// ... start calculating result ...

		// check super VS suer first

		String winnerTeam = null;
		String loserTeam = null;
		boolean isTied = false;
		List<String> winnerNames = new ArrayList<>();
		List<String> remainedLoserNames = new ArrayList<>();

		if (!hasSuperVsSuper) {
			// which team wins
			int destroyedCount1 = originalTeamSizes.get(teamName1) - teams.get(teamName1).size();
			int destroyedCount2 = originalTeamSizes.get(teamName2) - teams.get(teamName2).size();

			if (destroyedCount1 > destroyedCount2) {
				winnerTeam = teamName2;
				loserTeam = teamName1;
			} else if (destroyedCount1 < destroyedCount2) {
				winnerTeam = teamName1;
				loserTeam = teamName2;
			} else
				isTied = true;

			if (!isTied) {
				// winners names
				// - winners = battles - destroyed ones
				for (int m = 0; m < totalBattle
						- (originalTeamSizes.get(winnerTeam) - teams.get(winnerTeam).size()); m++)
					winnerNames.add(teams.get(winnerTeam).get(m).getName());
				// remained losers names
				for (int m = 0; m < teams.get(loserTeam).size(); m++)
					remainedLoserNames.add(teams.get(loserTeam).get(m).getName());
			}
		}

		// ... end of calculating result ...

		// ... output ...

		System.out.println("--- fighting result ---");
		// super VS super
		if (hasSuperVsSuper) {
			System.out.println("Super figher VS Super fighter, the two teams are tired");
			return;
		}
		// battle count:
		System.out.printf("%d battle \n", totalBattle);

		if (isTied) {
			System.out.println("The two teams are tired");
			return;
		}

		System.out.printf("Winning team(%s):", winnerTeam);
		for (int m = 0; m < winnerNames.size() - 1; m++)
			System.out.print(" " + winnerNames.get(m) + ",");
		System.out.print(" " + winnerNames.get(winnerNames.size() - 1) + ".");

		System.out.println();
		System.out.printf("Survivors from the losing team (%s):", loserTeam);
		if (remainedLoserNames.size() > 0) {
			if (remainedLoserNames.size() > 1) {
				for (int m = 0; m < remainedLoserNames.size() - 1; m++)
					System.out.print(" " + remainedLoserNames.get(m) + ",");
			}
			System.out.println(" " + remainedLoserNames.get(remainedLoserNames.size() - 1) + ".");
		} else {
			System.out.println(" no survivors");
		}

	}
}
