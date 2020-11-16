import java.util.Scanner;

// 형수의 큐와 스택 문제 2016110484 통계학과 오병찬 

/*
문제 1)

형수는 스택과 큐를 이용해서 숫자들을 정렬하는 것을 만들어보려고 합니다.

다음과 같은 알고리즘으로 숫자들 정렬하는 것을 수행합니다.
a) 큐와 스택을 생성합니다.
b) 숫자 n을 입력받습니다.
c) 큐에 n개의 랜덤한 숫자들을 넣습니다.  랜덤한 숫자는 0~10000 범위로 합니다.
d) 큐에서 숫자 하나를 꺼냅니다.
e) 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 작은 경우, 스택에서 숫자를 꺼내 큐에 넣습니다.
f) 스택이 비어있거나 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 클때까지 e)를 반복합니다.
g) 스택에 큐에서 꺼낸 숫자를 넣습니다.
h) 큐가 비어있지 않다면 d)로 가서 수행을 계속합니다.
i) 스택에 있는데이터를 하나씩 꺼내면서 데이터를 출력합니다.
*/

public class Q1 {

	static class Stack{
		int[] data;
		int top;
		Stack(){
			data = new int[1024];
			top = -1;
		}
		
		public void push(int v) {
			top++;
			data[top] = v;
		}
		
		public void pop() {
			//data[top] = -1;
			top--;
		}
		
		public int top() {
			return data[top];
		}
		
		public boolean empty() {
			return(top==(-1));
		}
	}
	
	static class Queue{
		
		int front;
		int rear;
		int[] data;
		int size;
		
		Queue() {
			front = 0;
			rear = 0;
			size = 1024;
			data = new int[size];
		}
		
		public void add(int v) {
			data[rear] = v;
			rear = (rear+1)%size;
		}

		public void remove() {
			data[front] = -1;
			front = (front+1)%size;
		}

		public int peek() {
			return data[front];
		}

		public boolean empty() {
			return front==rear;
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack1 = new Stack();
		Queue queue1 = new Queue();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Type N > ");
		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			queue1.add((int)(Math.random()*10000)+1);
		}
		
		// Stack Sorting
		while(!queue1.empty()) {
			//System.out.println("front : "+queue1.front+" / rear : "+queue1.rear);
			if(stack1.empty()) {
				stack1.push(queue1.peek());
				queue1.remove();
			}else if(stack1.top() >= queue1.peek()) {
				stack1.push(queue1.peek());
				queue1.remove();
			}else if(stack1.top() < queue1.peek()){
				queue1.add(stack1.top());
				stack1.pop();
			}
		}
		
		// Show Sorted Stack
		while(!stack1.empty()) {
			System.out.println(stack1.top());
			stack1.pop();
		}
		
		sc.close();
	}
}
