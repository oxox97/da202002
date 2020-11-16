import java.util.Scanner;

// 문제 2)

// 백준 10845 풀기 2016110484 통계학과 오병찬 

/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */


public class Q2 {


	static class Queue{
		
		int frontidx;
		int backidx;
		int[] data;
		int num;
		int size;
		
		Queue() {
			frontidx = 0;
			backidx = 0;
			size = 10240;
			data = new int[size];
		}
		
		public void push(int v) {
			data[backidx] = v;
			backidx = (backidx+1)%size;
		}

		public int pop() {
			if(empty()) return -1;
			else return data[frontidx++];
		}

		public int front() {
			if(empty()) return -1;
			else return data[frontidx];
		}
		
		public int back() {
			if(empty()) return -1;
			else return data[backidx-1];
		}

		public boolean empty() {
			return(size()==0);
		}
		
		public int size() {
			return backidx - frontidx;
		}

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("Type a num > ");
		int num = sc.nextInt();
		Queue queue = new Queue();
		for(int i=0; i< num; i++) {
			String flag = sc.next();
			switch(flag) {
			case "push" :
				int v = sc.nextInt();
				queue.push(v);
				break;
			case "pop" : 
				System.out.println(queue.pop());
				break;
			case "empty" : 
				if(queue.empty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front" : 
				System.out.println(queue.front());
				break;
			case "back" : 
				System.out.println(queue.back());
				break;
			case "size" : 
				System.out.println(queue.size());
				break;
			}
		}
		
		sc.close();
	}

}
