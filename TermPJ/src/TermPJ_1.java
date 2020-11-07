
// �ڷᱸ�� �� �˰���1 ��������Ʈ 1�� ���� 
// 2016110484 ����а� ������

import java.util.Random;
import java.util.Scanner;

public class TermPJ_1 {
	
	// �־��� ������ �迭���� �ִ밪 ��ȯ �Լ� 
	static int max(int[] arr) {
		int max = arr[0];
		for(int l=1; l<arr.length; l++) {
			if(max < arr[l]) {
				max = arr[l];
			}
		}
		return max;
	}

	// �־��� ������ �迭���� �ּ� ��ȯ �Լ� 
	static int min(int[] arr) {
		int min = arr[0];
		for(int l=1; l<arr.length; l++) {
			if(min > arr[l]) {
				min = arr[l];
			}
		}
		return min;
	}
	
	// �־��� ������ �迭���� �հ� ��ȯ �Լ� 
	static long sum(int[] arr) {
		long sum = 0;
		for(int l=0; l<arr.length; l++) {
			sum+=arr[l];
		}
		return sum;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Random rd = new Random(100);
		
		// �迭�� ũ�� N �Է� 
		System.out.print("Type N > ");
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		// ũ�� N �迭�� Random Number �ο� 
		for(int i=0; i<N; i++) {
			arr[i] = rd.nextInt();
		}
		
		// ���� (a,b) �Է� 
		System.out.print("Type a (start) > ");
		int a = sc.nextInt();
		
		System.out.print("Type b (end) > ");
		int b = sc.nextInt();
		
		// �迭 ��� 
		System.out.println("\n\nShow the array");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int[] tmp = new int[b-a+1];
		for(int k=0; k<tmp.length; k++){
			tmp[k] = arr[(a++)-1];
		}
		System.out.println("\nmin "+min(tmp));
		System.out.println("max "+max(tmp));
		System.out.println("sum "+sum(tmp));
		
		
		sc.close();
	}

}
