package xdwang.aequilibrium.castle;

/**
 * @author mwang
 *  ...
 */
public class CastleCompany {
	public static void main (String[] args){
		int [] land = {6,1,4,4,3,-1,7,7};
		System.out.println(listCastles (land));
	}
	
	public static int listCastles (int[] land){		if (land == null || land.length ==0) return 0;
		else if (land.length <=2 ) {
			// always build one on the first spot, as required;
			return 1;
		} 
		
		// ensure always have i + 1;
		int lastIndex = land.length - 2; 
		int i = 0;
		int castleCount = 1;
		String trend = null; // only up and down valid
		while (i <= lastIndex){
			if (land[i]>land[i+1]){
				if ("up".equals(trend))
					castleCount ++;
				trend = "down";
			}else if (land[i] < land [i + 1]){
				if( "down".equals(trend))
					castleCount++;
				trend = "up";	
			}
			i++;
		}
		return castleCount;
	}
}
