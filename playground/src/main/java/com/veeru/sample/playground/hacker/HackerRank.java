package com.veeru.sample.playground.hacker;

public class HackerRank {

	private static String findTreasure(String[] in) {
		
		
	
		int x;
		int y;
		try {
			if (in == null || in.length == 0) {
				return "";
			}

			x = 0;
			y = 0;
			String prev = "";

			for (int i = 0; i < in.length - 1;) {

				if (i == 0) {
					y += Integer.parseInt(in[i]);
					i++;
				} else {
					String curr = in[i];
					
					int next = Integer.parseInt(in[i + 1]);

					if (curr.equals("r") || curr.equals("l")) {

						if (prev.isEmpty()) {
							if (curr.equalsIgnoreCase("r")) {
								x += next;
							} else if (curr.equalsIgnoreCase("l")) {
								x -= next;
							}

						} else {

							String prCurr = curr + prev;

							if (prCurr.equalsIgnoreCase("rr")) {
								y -= next;
							} else if (prCurr.equalsIgnoreCase("lr")) {
								y += next;
							} else if (prCurr.equalsIgnoreCase("ll")) {
								y -= next;
							} else if (prCurr.equalsIgnoreCase("rl")) {
								y += next;
							}

						}
						
						prev = curr;
					}
					i += 2;
				
			}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return  "0, 0" ;
		}
		return x+", "+y;
	}

	public static void main(String[] args) {
		String[] tokens = {"4", "r","3","r","2"};
		String[] tokens1 = {"5", "r","r", "5"};
		String[] tokens2 = {"r", "3","1","2"};
		
		String[] tokens3 = {"4", "r","3","r","2","l","2","l","2","r","2"};
		String[] tokens4 = {"4", "l","3","l","3"};

		
		System.out.println(findTreasure(tokens));
		System.out.println(findTreasure(tokens1));
		System.out.println(findTreasure(tokens2));
		System.out.println(findTreasure(tokens3));
		System.out.println(findTreasure(tokens4));

		
	}

}
