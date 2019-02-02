package com.veeru.sample.playground.strings;

public class LPS {
	
	private static void findLongestPala(String str) {
		
		int n = str.length();
		int palstartindex = 0;
		int pal_max_len = 1;
		boolean pal[][] = new boolean [n][n];
		
		for(int i=0; i < n; i++) {
			pal[i][i] = true;
		}
		
		for (int i=0; i<n-1; i ++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				pal[i][i+1] = true;
			}
		}
		
		for (int cLen=3; cLen < n; cLen++) {
			for(int i=0; i < n-cLen; i++) {
				int j = i+cLen-1;
				if(str.charAt(i)==str.charAt(j) && pal[i+1][j-1]) {
					pal[i][j] = true;
					palstartindex = i;
					pal_max_len = cLen;
				}
			}
		}
		
		System.out.println(str.substring(palstartindex, pal_max_len+palstartindex));
		
	}

	public static void main(String[] args) {
		findLongestPala("helloabcdefedcbaolleh");

	}

}
