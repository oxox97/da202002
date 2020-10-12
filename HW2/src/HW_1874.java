//Push Pop (백준 1874번)
//스택 수열
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
		
		// 1. 입력받은 수 배열에 저장
		
		for(int i=0; i<n; i++) {
			//System.out.print("Insert input > ");
			int input = sc.nextInt();
			arr[i] = input;
		}
		
		// 2. 1부터 n까지 push (+)
		
		int top = -1;
		int idx = 0;
		int pr_idx = 0;
		
		for(int j=1; j<=n; j++) {
			stack[++top] = j;
			result[pr_idx++] = '+';
			//System.out.print("+ ");
			
			// 3. push 중 stack[top]과 arr[idx] 숫자가 일치하면 pop (-)
			
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

		// 4. 출력
		
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
