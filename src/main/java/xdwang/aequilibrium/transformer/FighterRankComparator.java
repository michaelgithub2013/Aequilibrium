package xdwang.aequilibrium.transformer;

import java.util.Comparator;

/**
 * @author mwang
 * this is used to sort fighters in their team.
 */
public class FighterRankComparator implements Comparator<Fighter> {
	public int compare(Fighter f1, Fighter f2) {
		if (f1 instanceof Transformer && f2 instanceof Transformer)
			return (((Transformer) f1).getRank() - ((Transformer) f2).getRank());
		else
			return 0;
	}
}
