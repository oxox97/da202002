//Push Pop (���� 1874��)
//���� ����
//LIFO

import java.util.Scanner;

public class HW_1874 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("Insert n > ");
		int n = sc.nextInt();
		
		int[] arr = new int[1000000];
		
		int[] stack = new int[1000000];
		
		char[] result = new char[1000000];
		
		// 1. �Է¹��� �� �迭�� ����
		
		for(int i=0; i<n; i++) {
			//System.out.print("Insert input > ");
			int input = sc.nextInt();
			arr[i] = input;
		}
		
		// 2. 1���� n���� push (+)
		
		int top = -1;
		int idx = 0;
		int pr_idx = 0;
		
		for(int j=1; j<=n; j++) {
			stack[++top] = j;
			result[pr_idx++] = '+';
			//System.out.print("+ ");
			
			// 3. push �� stack[top]�� arr[idx] ���ڰ� ��ġ�ϸ� pop (-)
			
			if(stack[top]==arr[idx]) {
				while(stack[top]==arr[idx]) {
					arr[idx++] = 0;
					top--;
					result[pr_idx++] = '-';
					//System.out.print("- ");
					if(top==-1) {
						break;
					}
				}
			}
			
		}

		// 4. ���
		
		if(top==-1 && arr[n-1]==0) {
			for(int k=0; k<pr_idx; k++) {
				System.out.println(result[k]);
			}
		}else {
			System.out.print("NO");
		}
				
		sc.close();
	}

}
