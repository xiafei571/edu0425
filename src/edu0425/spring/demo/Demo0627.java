package edu0425.spring.demo;

import java.util.Stack;

public class Demo0627 {

	/*
	 * 1. 给定⼀个数组，将数组向右移动k步，其中k为⾮负数 Example 样例 1: 输⼊: [1,2,3,4,5,6,7], k = 3 • 输出:
	 * [5,6,7,1,2,3,4]
	 */
	private static void moveArray(int[] nums, int k) {
		int[] arry = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			arry[(i + k) % nums.length] = nums[i];
		}

		// 打印结果
		for (int i : arry) {
			System.out.print(i);
		}
		System.out.println();
	}

	/*
	 * 给定⼀个整数数组，其中1 ≤ a[i] ≤ n (n =数组的⼤⼩)，⼀些元素出现两次，其 他元素出现⼀次。 找到
	 * [1,n]中所有没有出现在此数组中的元素。 你可以在没有额外空间和O(n)运⾏时的情况下完成吗？ 您可以认为返回的列表 不计为额外空间。 Example
	 * 输⼊: [-,-3,-2,-7,8,2,-3,-1] [-,-,-,-,+,+,-,-] true/false 0/1 +/- 输出: [5,6]
	 */
	private static void findNums(int[] nums) {
		// O(n^2) -> O(n)
		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i]) - 1] >= 0) {// -
				nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
			}
		}

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] > 0) {// +
				System.out.println(j + 1);
			}
		}
	}

	/*
	 * Given an array of integers, return indices of the two numbers such that they
	 * add up to a specific target. (You may assume that each input would have
	 * exactly one solution. ) Example: Given nums = [2, 7, 11, 15], target = 9
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 */
	private static void getTwoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		System.out.println(result[0] + ", " + result[1]);
	}
	
	private static final char PLUS = '+';
	private static final char REDU = '-';
	private static final char MULI = '*';
	private static final char DIV = '/';
	
	private static int rpn(String equ) {
		//13+52-*6/
		Stack<Integer> s = new Stack<Integer>();
		char[] charArray = equ.toCharArray();
		for(char c : charArray) {
			if(isNum(c)) {//如果是数字
				//入栈 不能直接(int)c，这样强转的结果是asii码值
				s.push(Character.getNumericValue(c));
			}else {//运算符
				int x = 0;
				int y = 0;
				switch (c) {
				case PLUS:
					s.push(s.pop()+s.pop());
					break;
				case REDU:
					 x = s.pop();
					 y = s.pop();
					s.push(y - x);
					break;
				case MULI:
					s.push(s.pop()*s.pop());
					break;
				case DIV:
					 x = s.pop();
					 y = s.pop();
					s.push(y / x);
					break;
				default:
					break;
				}
			}
		}
		
		return (int)s.pop();
	}
	
	private static boolean isNum(char c) {
		if(c < 48 || c>57) 
			return false;
		return true;
	}
	
	private static final int[] C = {1, 2, 4, 7};
	// n in [0,1,2,3]
	private static int calcT(int n, int m) {//n=2 (C[2]=4), m=5 
		if(n < 0 || m <= 0) {//结束递归条件
			return 0;
		}
		int count = 0;
		
		if(m >= C[n]) {
			count = m / C[n];
			if(m % C[n] != 0) {
				count += calcT(n-1, m % C[n]);
			}
		}else {
			return calcT(n - 1, m);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(calcT(1,5));
//		System.out.println(calcT(2,5));
//		System.out.println(calcT(3,5));
//		System.out.println(calcT(3,6));
//		
//		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
//		moveArray(a, 3);
//		moveArray(a, 4);
//
//		int[] b = { 4, 3, 2, 7, 8, 2, 3, 1 };
//		findNums(b);
//		
//		int[] c = {2, 7, 11, 15};
//		getTwoSum(c, 26);
//		
//		String edu = "13+52-*6/";
//		System.out.println(edu+"的結果是："+rpn(edu));
		
//		QueueDemo qd = new QueueDemo(10);
//		qd.enqueue(3);
//		qd.enqueue(9);
//		qd.enqueue(21);
//		qd.enqueue(33);
//		qd.enqueue(5);
//		qd.print();
//		System.out.println("出队："+qd.dequeue());
//		qd.print();
//		System.out.println("出队："+qd.dequeue());
//		qd.print();
		
		//5 10 15 11 12 3 8
		NodeDemo node = new NodeDemo(5);
		node.insert(10);
		node.insert(15);
		node.insert(11);
		node.insert(12);
		node.insert(3);
		node.insert(8);
		//中序遍历
		node.inorder();
	}
}
