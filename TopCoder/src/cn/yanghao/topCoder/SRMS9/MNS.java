package cn.yanghao.topCoder.SRMS9;
/*
 *
Problem Statement
    
9 numbers need to be arranged in a magic number square. A magic number square is a square of numbers that is arranged such that every row and column has the same sum. For example:
1 2 3
3 2 1
2 2 2
Create a class MNS containing a method combos which takes as an argument a int[] numbers and returns the number of distinct ways those numbers can be arranged in a magic number square. Two magic number squares are distinct if they differ in value at one or more positions. For example, there is only one magic number square that can be made of 9 instances of the same number.
Definition
    
Class:
MNS
Method:
combos
Parameters:
int[]
Returns:
int
Method signature:
int combos(int[] numbers)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
Unlike some versions of the magic number square, the numbers do not have to be unique.
Constraints
-
numbers will contain exactly 9 elements.
-
each element of numbers will be between 0 and 9, inclusive.
Examples
0)

    
{1,2,3,3,2,1,2,2,2}
Returns: 18

1)

    
{4,4,4,4,4,4,4,4,4}
Returns: 1

2)

    
{1,5,1,2,5,6,2,3,2}
Returns: 36

3)

    
{1,2,6,6,6,4,2,6,4}
Returns: 0

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved. 
 *
 */
import java.util.HashSet;
import java.util.Set;

public class MNS {
	int result = 0;
	int sumLine = 0;
	int[] square;
	Set<Integer> set;

	public int combos(int[] numbers) {
		result = 0;
		int sum = 0;
		square = numbers;
		for (int element : numbers)
			sum += element;
		if (0 != sum % 3)
			return 0;
		sumLine = sum / 3;
		set=new HashSet();
		search(0);
		return result;
	}

	void search(int index) {
		int i = 0;
		if (8 == index) {
			if (square[0] + square[1] + square[2] == sumLine)
				if (square[3] + square[4] + square[5] == sumLine)
					if (square[0] + square[3] + square[6] == sumLine)
						if (square[1] + square[4] + square[7] == sumLine) {
							int p = 0;
							for (i = 0; i < 9; i++) {
								p *= 10;
								p += square[i];
							}
							if (!set.contains(p)) {
								set.add(p);
								result++;
							}
						}
		} else {
			for (i = index; i < 9; i++) {
				swap(index, i);
				search(index+1);
				swap(index, i);
			}
		}
	}

	void swap(int i, int j) {
		int p=square[i];
		square[i] = square[j];
		square[j] = p;
 	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []numbers={1,2,6,6,6,4,2,6,4};
		System.out.println(new MNS().combos(numbers));
	}

}
