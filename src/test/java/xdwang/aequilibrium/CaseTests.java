package xdwang.aequilibrium;

import org.junit.Test;

import xdwang.aequilibrium.transformer.BattleField;
import xdwang.aequilibrium.transformer.Transformer;



public class CaseTests {
	@Test
	public void testNothing(){
		assert (true);
	}
	
	
	//@Test
	public void testRegularFight(){
		BattleField battleField = new BattleField();
		
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_DECEPTION,"Soundwave")
				.strength(8).intelligence(9).speed(2).endurance(6).rank(7)
				.courage(5).firepower(6).skill(10).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Bluestreak")
				.strength(6).intelligence(6).speed(7).endurance(9).rank(5)
				.courage(2).firepower(9).skill(7).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Hubcap")
				.strength(4).intelligence(4).speed(4).endurance(4).rank(4)
				.courage(4).firepower(4).skill(4).build());		
		battleField.fight(Transformer.TEAM_AUTOBOT,Transformer.TEAM_DECEPTION);
	}
	
	//@Test
	public void testRegularFightWithMultiWinnerAndSurvivors(){
		BattleField battleField = new BattleField();
		
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_DECEPTION,"Soundwave")
				.strength(8).intelligence(9).speed(2).endurance(6).rank(7)
				.courage(5).firepower(6).skill(10).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_DECEPTION,"Soundwave 02")
				.strength(8).intelligence(9).speed(2).endurance(6).rank(7)
				.courage(5).firepower(6).skill(10).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Bluestreak")
				.strength(6).intelligence(6).speed(7).endurance(9).rank(5)
				.courage(2).firepower(9).skill(7).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Bluestreak 02")
				.strength(6).intelligence(6).speed(7).endurance(9).rank(5)
				.courage(2).firepower(9).skill(7).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Hubcap")
				.strength(4).intelligence(4).speed(4).endurance(4).rank(4)
				.courage(4).firepower(4).skill(4).build());		
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Hubcap 02")
				.strength(4).intelligence(4).speed(4).endurance(4).rank(4)
				.courage(4).firepower(4).skill(4).build());		
		battleField.fight(Transformer.TEAM_AUTOBOT,Transformer.TEAM_DECEPTION);
	}
	
	//@Test
	public void testRegularFightTied(){
		BattleField battleField = new BattleField();
		
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_DECEPTION,"Soundwave")
				.strength(8).intelligence(9).speed(2).endurance(6).rank(7)
				.courage(5).firepower(6).skill(10).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Bluestreak")
				.strength(6).intelligence(6).speed(7).endurance(9).rank(5)
				.courage(2).firepower(9).skill(7).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Hubcap")
				.strength(4).intelligence(4).speed(4).endurance(4).rank(4)
				.courage(4).firepower(4).skill(4).build());	
		// reverse teams
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Soundwave")
				.strength(8).intelligence(9).speed(2).endurance(6).rank(7)
				.courage(5).firepower(6).skill(10).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_DECEPTION,"Bluestreak")
				.strength(6).intelligence(6).speed(7).endurance(9).rank(5)
				.courage(2).firepower(9).skill(7).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_DECEPTION,"Hubcap")
				.strength(4).intelligence(4).speed(4).endurance(4).rank(4)
				.courage(4).firepower(4).skill(4).build());	
		
		battleField.fight(Transformer.TEAM_AUTOBOT,Transformer.TEAM_DECEPTION);
	}	
	
	//@Test
	public void testSuperVsSuperFight(){
		BattleField battleField = new BattleField();
		
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_DECEPTION,Transformer.SUPER_OPTIMUS_PRIME)
				.strength(8).intelligence(9).speed(2).endurance(6).rank(7)
				.courage(5).firepower(6).skill(10).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Bluestreak")
				.strength(6).intelligence(6).speed(7).endurance(9).rank(5)
				.courage(2).firepower(9).skill(7).build());
		battleField.registerFighter(new Transformer.Builder(Transformer.TEAM_AUTOBOT,Transformer.SUPER_PREDAKING)
				.strength(4).intelligence(4).speed(4).endurance(4).rank(4)
				.courage(4).firepower(4).skill(4).build());		
		battleField.fight(Transformer.TEAM_AUTOBOT,Transformer.TEAM_DECEPTION);
	}
}
