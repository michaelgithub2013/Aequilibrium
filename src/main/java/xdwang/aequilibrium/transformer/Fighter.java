package xdwang.aequilibrium.transformer;

/**
 * @author mwang ...Any Transformer named Optimus Prime or Predaking wins his
 *         fight automatically regardless of any other criteria. In the event
 *         either of the above face each other (or a duplicate of each other),
 *         the game immediately ends with all competitors destroyed
 */
public interface Fighter {
	public boolean isSuper();

	public int fight(Fighter fighter);

	public String getName();

	public String getTeamName();
}
