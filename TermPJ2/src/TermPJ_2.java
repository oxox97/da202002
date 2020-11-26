// �ڷᱸ�� �� �˰���1 ��������Ʈ 2�� ���� 
// 2016110484 ����а� ������

// 1127 ����

import java.util.Random;
import java.util.Scanner;

public class TermPJ_2 {
	
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
		
		System.out.print("Type N > ");
		
		// �迭�� ũ�� N �Է� 
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		// ũ�� N �迭�� Random Number �ο� 
		for(int i=0; i<N; i++) {
			arr[i] = rd.nextInt();	 
		}
		
		/*
		System.out.println("\n[Show the array]");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
		
		System.out.print("\nType K > ");
		
		int K = sc.nextInt();
			
		long t = System.currentTimeMillis();
		
		for(int j=0; j<K; j++) {
			int start = rd.nextInt(N)+1;
			int end = rd.nextInt(N)+1;
			
			// start <= end
			if(start>end) {
				int tmp = start;
				start = end;
				end = tmp;
			}
				
			System.out.println("");
			System.out.println("start : "+start);
			System.out.println("end : "+end);
			
			int[] tmp = new int[end-start+1];
			for(int k=0; k<tmp.length; k++){
				tmp[k] = arr[start-1];
				start++;
			}
			
			System.out.println("");
			System.out.println("min : "+min(tmp));
			System.out.println("max : "+max(tmp));
			System.out.println("sum : "+sum(tmp));
		}
			
		t = System.currentTimeMillis() - t;
		System.out.println("\n###################");
		System.out.println("Running Time : "+t+"ms");
		
		sc.close();
	}
}