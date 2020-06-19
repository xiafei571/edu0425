package edu0425.spring.demo;

public class Demo66 {

	public static void main(String[] args) {

		System.out.println(fact(1));
		System.out.println(fact(5));
		System.out.println(fib(10));
		System.out.println(gcd(888, 54));

		int[][] a = { { 1, 2, 3 }, { 10, 20, 30 } };
		int[][] ext_a = extend_sum(extend_sum(a));
		print_2D(ext_a);

	}

	private static int fact(int n) {
		// fact(n) = 1 * 2 * 3 ... * n-1 * n = fact(n-1) * n = fact(n-2) * (n-1) * n =
		// fact(1) * ...
		// fact(1) = 1
		if (n == 1) {
			return 1;
		} else {
			// fact(n)= fact(n-1) * n
			return fact(n - 1) * n;
		}
	}

	private static int fib(int n) {
		// 0 1 1 2 3 5 8 ...
		// 递归结束条件 n == 0 和 n == 1
		// 等式 fib(n) = fib(n-2) + fib(n-1)
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n - 2) + fib(n - 1);
		}
	}

	private static int gcd(int a, int b) {// a>=b 取最大公约数
		// 余数为0时结束递归，返回结果b
		// 递归等式 gcb(a, b) = gcd(b, a%b)
		// gcd(888, 54) = 6
		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}

	private static int[][] extend_sum(int[][] a) {
		// int[][] a = {{1,2,3},{10, 20, 30}}
		int[][] rs = new int[a.length + 1][a[0].length + 1];

		for (int i = 0; i < a.length; i++) {
			for(int j =0; j<a[i].length;j++) {
				//1.rs
				rs[i][j] = a[i][j];
				//2.每一行的最后一个
				rs[i][rs[i].length-1] +=  a[i][j];
				//3.每一列的最后一个
				rs[rs.length-1][j] += a[i][j];
				//4.右下角落的
				rs[rs.length-1][rs[i].length-1] += a[i][j];
			}
		}

		return rs;
	}

	private static void print_2D(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
