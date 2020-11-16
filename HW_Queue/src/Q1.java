import java.util.Scanner;

// ������ ť�� ���� ���� 2016110484 ����а� ������ 

/*
���� 1)

������ ���ð� ť�� �̿��ؼ� ���ڵ��� �����ϴ� ���� �������� �մϴ�.

������ ���� �˰������� ���ڵ� �����ϴ� ���� �����մϴ�.
a) ť�� ������ �����մϴ�.
b) ���� n�� �Է¹޽��ϴ�.
c) ť�� n���� ������ ���ڵ��� �ֽ��ϴ�.  ������ ���ڴ� 0~10000 ������ �մϴ�.
d) ť���� ���� �ϳ��� �����ϴ�.
e) ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� ���� ���, ���ÿ��� ���ڸ� ���� ť�� �ֽ��ϴ�.
f) ������ ����ְų� ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� Ŭ������ e)�� �ݺ��մϴ�.
g) ���ÿ� ť���� ���� ���ڸ� �ֽ��ϴ�.
h) ť�� ������� �ʴٸ� d)�� ���� ������ ����մϴ�.
i) ���ÿ� �ִµ����͸� �ϳ��� �����鼭 �����͸� ����մϴ�.
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
