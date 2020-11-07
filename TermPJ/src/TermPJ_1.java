
// 자료구조 및 알고리즘1 텀프로젝트 1차 과제 
// 2016110484 통계학과 오병찬

import java.util.Random;
import java.util.Scanner;

public class TermPJ_1 {
	
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
		
		// 배열의 크기 N 입력 
		System.out.print("Type N > ");
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		// 크기 N 배열에 Random Number 부여 
		for(int i=0; i<N; i++) {
			arr[i] = rd.nextInt();
		}
		
		// 구간 (a,b) 입력 
		System.out.print("Type a (start) > ");
		int a = sc.nextInt();
		
		System.out.print("Type b (end) > ");
		int b = sc.nextInt();
		
		// 배열 출력 
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
