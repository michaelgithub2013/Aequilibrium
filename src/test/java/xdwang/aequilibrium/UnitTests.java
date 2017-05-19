package xdwang.aequilibrium;

import org.junit.Test;

import xdwang.aequilibrium.transformer.Transformer;

public class UnitTests {
	@Test
	public void testBuilder(){
		Transformer t0 = new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Optumus Prime").build();
		Transformer t1 =  new Transformer.Builder(Transformer.TEAM_DECEPTION, "Megatron").strength(5).endurance(3).build();
		assert (Transformer.TEAM_AUTOBOT.equals(t0.getTeamName()));
		assert  (t1.getStrength()==5 && t1.getEndurance() == 3);		
	}
	
	@Test (expected = Exception.class)
	public void testBuilderTypeException(){
		Transformer t0 = new Transformer.Builder("abc","Optumus Prime").build();
		
	}
	@Test (expected = Exception.class)
	public void testBuilderRangeException(){
		Transformer t0 = new Transformer.Builder(Transformer.TEAM_AUTOBOT,"Optumus Prime").strength(5).endurance(30).build();
	}
}
