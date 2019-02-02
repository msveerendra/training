package com.veeru.sample.playground;

public class AddTwoNumber {
	
	
	
	public static void main(String args[]) {
		ListNode l1_1 = new ListNode(2);
		ListNode l1_2 = new ListNode(4);
		ListNode l1_3 = new ListNode(3);
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		
		
		
		ListNode l2_1 = new ListNode(5);
		ListNode l2_2 = new ListNode(6);
		ListNode l2_3 = new ListNode(4);
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		
		ListNode result = addTwoNumbers(l1_1, l2_1);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
		
		
	}

	private static ListNode addTwoNumbers(ListNode l1_1, ListNode l2_1) {
		ListNode ptr1 = l1_1;
		ListNode ptr2 = l2_1;
		ListNode result= new ListNode(0);
		ListNode resultPtr = result;
		
		int sum =0;
		int carryOver = 0;
		
		while(ptr1 !=null || ptr2 != null || carryOver !=0) {
			sum=0;
			resultPtr.next= new ListNode(0);
			resultPtr = resultPtr.next;
			
			if(ptr1 != null) {
				sum = sum + ptr1.val;
				ptr1 = ptr1.next;
				
			}
			
			if(ptr2 != null) {
				sum = sum + ptr2.val;
				ptr2 = ptr2.next;
				
			}
			
			sum = sum + carryOver;
			resultPtr.val = sum % 10;
			carryOver = sum/10;
			
		}
		
		
		return result.next;
	}

}
