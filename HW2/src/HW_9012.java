
// Valid Parenthesis String using Stack  (백준 9012번)
// 스택을 사용하여 올바른 괄호 검정 '(',')'


import java.util.Scanner;

public class HW_9012 {

	static boolean VPS(String PS) {
		
		char[] Stack = new char[50];
		int top = -1;
		
		for(int i=0; i<PS.length(); i++){
			char ch = PS.charAt(i);
		
			if(ch == '('){
				top++;
				Stack[top] = ch;
			}
			
			else if(ch == ')') {
				if(top==-1) {return false;}
				else if(Stack[top] == '(') top--;		
			}
			
		}
		return (top == -1);
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//System.out.print("Type T > ");
		int T = sc.nextInt();
	
		while(T>0) {
			//System.out.print("Type ch > ");
			String ch = sc.next();
				
			if(VPS(ch)) System.out.println("YES");
			else System.out.println("NO");
			T--;
		}
	}

}
