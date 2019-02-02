package com.veeru.sample.playground.datastructures;

public class QueueArray {
	

		int front, rear, size, capacity;
		int[] arr;
		
		QueueArray(int capacity){
			this.capacity = capacity;
			this.front = this.size= 0;
			this.rear = capacity-1;
			arr = new int[this.capacity];
		}
		
		boolean isFull(QueueArray queue) {
			return queue.size == queue.capacity;
		}
		
		boolean isEmpty(QueueArray queue) {
			return queue.size == 0;
		}
		
		void enqueue(int item) {
			if(isFull(this)) {
				return;
			}
			this.rear = (this.rear+1)%this.capacity;
			arr[this.rear]= item;
			size = size+1;
			
		}
		
		int dequeue() {
			
			if(isEmpty(this)) {
				return Integer.MIN_VALUE;
			}
			
			int item = this.arr[this.front];
			this.front = (this.front+1)%capacity;
			this.size = this.size-1;
			return item;
		}
		int front() {
			if(this.isEmpty(this)) {
				return Integer.MIN_VALUE;
			}
			return this.arr[this.front];
		}
		
		int rear() {
			if(this.isEmpty(this)) {
				return Integer.MIN_VALUE;
			}
			return this.arr[this.rear];
		}
	

	public static void main(String[] args) {
		QueueArray queue = new QueueArray(1000);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
       

       
        System.out.println("Front item is " + queue.front());
          
        System.out.println("Rear item is " + queue.rear());
        
        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " + queue.front());
        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " + queue.front());
        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " + queue.front());
        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " + queue.front());
        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " + queue.front());
        System.out.println(queue.dequeue() + " dequeued from queue\n");

	}

}
