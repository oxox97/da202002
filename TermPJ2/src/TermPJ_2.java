// 자료구조 및 알고리즘1 텀프로젝트 2차 과제 
// 2016110484 통계학과 오병찬

// 1127 제출

import java.util.Random;
import java.util.Scanner;

public class TermPJ_2 {
	
	// 주어진 정수형 배열에서 최대값 반환 함수 
	static int max(int[] arr) {
		int max = arr[0];
		for(int l=1; l<arr.length; l++) {
			if(max < arr[l]) {
				max = arr[l];
			}
		}
		return max;
	}

	// 주어진 정수형 배열에서 최소 반환 함수 
	static int min(int[] arr) {
		int min = arr[0];
		for(int l=1; l<arr.length; l++) {
			if(min > arr[l]) {
				min = arr[l];
			}
		}
		return min;
	}
	
	// 주어진 정수형 배열에서 합계 반환 함수 
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
		
		// 배열의 크기 N 입력 
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		// 크기 N 배열에 Random Number 부여 
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