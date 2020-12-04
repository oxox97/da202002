import java.util.Scanner;

// Lecture 14 
// ������׷����� ���� ū ���簢�� ���� ���ϱ�
// ������׷��� ������ �׷����� �׸� ���Դϴ�.
// �� �� ��������� ������׷� �׷������� ���� ���� ���簢���� ���̸� ���ϴ� ������ 
// ���� ���� �˰����� ��ǥ�� �����Դϴ�.
// �Է��� ������ ��(N)�� �Է¹ް� �� ������ ������ �Է� �޽��ϴ�.
// {3,1,4,3} �� ������ ���� ����� �Է�����
// 4 3 1 4 3 
// �� �˴ϴ�.
// ����� ���� ū ���簢���� ���̸� ����ϸ� �˴ϴ�.
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
	
	// ���������� ���� histo �Լ�
	static int histo(int[] v, int a, int b) {
		if(a>=b) {
			return v[a];
		}
		int c = (a+b)/2;
		int x = max(histo(v,a,c),histo(v,c+1,b));
		
		// �߰��κ��� �����ϴ� ���簢�� 
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

	
	// ���� ū ���簢���� ���� ��ȯ
	// n : ���� ��
	// v : n���� ������ ����
	// ��ȯ : ���簢���� ���� 
	static int histo(int[] v, int n) {
		return histo(v,0,n-1);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ĳ�� ������Ʈ ����
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Type the N > ");
		// ������ �� �Է�
		int	n = sc.nextInt();
		
		System.out.print("ũ�� "+n+" �迭 ���� > ");
		// ������ ������ �迭 ����
		int[] v = new int[n];
		// n���� ������ �Է¹޾� �迭 v�� ����
		for(int i=0; i<n; i++) {
			v[i] = sc.nextInt();
		}
			
		// ���� ū ���簢���� ���� ���
		int r = histo(v,n);
		// ���
		System.out.println(r);
				
		sc.close();
	}

}

/*
7 2 1 4 5 1 3 3
4 1000 1000 1000 1000
0
*/