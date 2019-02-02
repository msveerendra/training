package com.veeru.sample.playground.strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
 
public class AnagramGroup 
{
    public static Map<String, ArrayList<String>> sortChars(String[] s) 
    {
    	Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

    	for(int i=0; i<s.length; i++) {
    		char[] content = (s[i]).toCharArray();
    		Arrays.sort(content);
    		String key = new String(content);
    		if (map.containsKey(key)) {
    			map.get(key).add(s[i]);
    		}else {
    			ArrayList<String> list= new ArrayList<String>();
    			list.add(s[i]);
    			map.put(key, list);
    		}
    	
    	}
    		
        
        return map;
    }
 
 
     
    public static void main(String[] args) 
    {
        String[] strArray = {"tea","eat","atn", "ate","nat", "bat"};
         
        Map<String, ArrayList<String>> map = sortChars(strArray);
         
        for(String key : map.keySet()) {
        	System.out.println(String.valueOf(map.get(key)));
        }
    }
}
     