import java.util.Scanner;

// Lecture 14 
// 히스토그램에서 가장 큰 직사각형 넓이 구하기
// 히스토그램은 도수를 그래프로 그린 것입니다.
// 이 때 만들어지는 히스토그램 그래프에서 가장 넓은 직사각형의 넓이를 구하는 문제로 
// 분할 정복 알고리즘의 대표적 문제입니다.
// 입력은 샘플의 수(N)를 입력받고 각 샘플의 도수를 입력 받습니다.
// {3,1,4,3} 의 도수를 가진 경우라면 입력으로
// 4 3 1 4 3 
// 이 됩니다.
// 결과는 가장 큰 직사각형의 넓이를 출력하면 됩니다.
// 6


public class Lab10 {
	
	static int max(int a, int b){
		if(a>b) {
			return a;
		}else {
			return b;
		}
	}
	
	static int min(int a, int b) {
		if(a>b) {
			return b;
		}else {
			return a;
		}
	}
	
	// 분할정복을 위한 histo 함수
	static int histo(int[] v, int a, int b) {
		if(a>=b) {
			return v[a];
		}
		int c = (a+b)/2;
		int x = max(histo(v,a,c),histo(v,c+1,b));
		
		// 중간부분을 포함하는 직사각형 
		int c1 = c; 
		int c2 = c+1;
		int height = min(v[c1],v[c2]);
		
		x = max(height*(c2-c1+1),x);
		
		while(a < c1 || c2 < b) {
		
			if (c2 < b && (c1 == a || v[c1 - 1] < v[c2 + 1])) {
	            height = min(height, v[++c2]);
	        }
	        else {
	            height = min(height, v[--c1]);
	        }
			x = max(x,height*(c2-c1+1));
		}
		return x;
	}

	
	// 가장 큰 직사각형의 넓이 반환
	// n : 샘플 수
	// v : n개의 샘플의 도수
	// 반환 : 직사각형의 넓이 
	static int histo(int[] v, int n) {
		return histo(v,0,n-1);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스캐너 오브젝트 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Type the N > ");
		// 샘플의 수 입력
		int	n = sc.nextInt();
		
		System.out.print("크기 "+n+" 배열 생성 > ");
		// 도수를 저장할 배열 생성
		int[] v = new int[n];
		// n개의 도수를 입력받아 배열 v에 저장
		for(int i=0; i<n; i++) {
			v[i] = sc.nextInt();
		}
			
		// 가장 큰 직사각형의 넓이 계산
		int r = histo(v,n);
		// 출력
		System.out.println(r);
				
		sc.close();
	}

}

/*
7 2 1 4 5 1 3 3
4 1000 1000 1000 1000
0
*/