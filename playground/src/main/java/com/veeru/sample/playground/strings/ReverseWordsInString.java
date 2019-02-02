package com.veeru.sample.playground.strings;

public class ReverseWordsInString {
	
	private static String reverseStr(char[] arr) {
		int n = arr.length;
		int start = 0;
		
		for(int i=0 ; i <n; i++) {
			if(arr[i] == ' ' && i > 0) {
				reverse(arr, start,i-1);
				start = i+1;
			} else if(i == n-1) {
				reverse(arr, start, i);
			}
		}
		reverse(arr, 0, n-1);
		return String.valueOf(arr);
	}
	
	private static void reverse(char[] str, int start, int end) {
		
		while(start <  end) {
			swap(str, start,end);
			start++;
			end--;
		}
		
	}

	private static void swap(char[] str, int start, int end) {
		char temp = str[start];
		str[start] = str[end];
		str[end] = temp;
		
	}

	public static void main(String[] args) {
		String str = "Hello how are you";
		char[] cArr = str.toCharArray();
		
		System.out.println(reverseStr(cArr));

	}

}
