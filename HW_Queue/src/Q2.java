import java.util.Scanner;

// ���� 2)

// ���� 10845 Ǯ�� 2016110484 ����а� ������ 

/*
push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
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
