package cn.yanghao.topCoder.SRMS15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * 
Problem Statement
    
MergeSort is a classical sorting algorithm following the divide-and-conquer paradigm. Sorting n elements, it has a worst-case complexity of O(n*log(n)), which is optimal for sorting algorithms based on comparisons.  Basically, it sorts a list with more than one element the following way (a list containing only one element is always sorted):
1. divide the list into two sublists of about equal size (divide)
2. sort each of the two sublists (conquer)
3. merge the two sorted sublists into one sorted list (combine)
 A pro of MergeSort is that it is stable, i.e. elements with the same key value keep their relative order during sorting. A con is that it is not in-place since it needs additional space for temporarily storing elements.  Given a int[] numbers, return the number of comparisons the MergeSort algorithm (as described in pseudocode below) makes in order to sort that list. In this context, a single comparison takes two numbers x, y (from the list to be sorted) and determines which of x < y, x = y and x > y holds.  
List mergeSort(List a)
1. if size(a) <= 1, return a
2. split a into two sublists b and c
   if size(a) = 2*k, b contains the first k elements of a, c the last k elements
   if size(a) = 2*k+1, b contains the first k elements of a, c the last k+1 elements
3. List sb = mergeSort(b)
   List sc = mergeSort(c)
4. return merge(sb, sc)
 
List merge(List b, List c)
1. create an empty list a
2. while both b and c are not empty, compare the first elements of b and c
   first(b) < first(c): remove the first element of b and append it to the end of a
   first(b) > first(c): remove the first element of c and append it to the end of a
   first(b) = first(c): remove the first elements of b and c and append them to the end of a
3. if either b or c is not empty, append that non-empty list to the end of a
4. return a
Definition
    
Class:
MergeSort
Method:
howManyComparisons
Parameters:
int[]
Returns:
int
Method signature:
int howManyComparisons(int[] numbers)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
Be sure to exactly follow the algorithm as described, as a different implementation of MergeSort might lead to a different number of comparisons.
Constraints
-
numbers contains between 0 and 50 elements, inclusive.
-
Each element of numbers is an int in its 'natural' (signed 32-bit) range from -(2^31) to (2^31)-1.
Examples
0)

    
{1, 2, 3, 4}
Returns: 4
{1, 2, 3, 4} is first split to {1, 2} and {3, 4}. {1, 2} is split to {1} and {2} and merging to {1, 2} takes one comparison. {3, 4} is split to {3} and {4} and merging to {3, 4} also takes one comparison. Merging {1, 2} and {3, 4} to {1, 2, 3, 4} takes two comparisons (first 1 is compared to 3 and then 2 is compared to 3). This makes a total of four comparisons.
1)

    
{2, 3, 2}
Returns: 2
{2, 3, 2} is split to {2} and {3, 2}. {3, 2} is split and then merged to {2, 3} making one comparison. {2} and {2, 3} are merged to {2, 2, 3} also making one comparison, which totals to two comparisons made.
2)

    
{-17}
Returns: 0

3)

    
{}
Returns: 0

4)

    
{-2000000000,2000000000,0,0,0,-2000000000,2000000000,0,0,0}
Returns: 19

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class MergeSort {

	int num;
	List<Integer> mergeSort(List<Integer> numbers){
		if(1>=numbers.size())
			return numbers;
		int sizeA=numbers.size()/2;
		int sizeB=numbers.size()-sizeA;
 
	
		List<Integer> listA=mergeSort( numbers.subList(0, sizeA));
		List<Integer> listB=mergeSort(numbers.subList(sizeA,numbers.size()));
		List<Integer> listC=new ArrayList<Integer>(numbers.size());
		int indexA=0,indexB=0;
		while(indexA<sizeA&&indexB<sizeB){
			int a=listA.get(indexA);
			int b=listB.get(indexB);
			num++;
			if(a<=b){
				//num++;
				listC.add(a);
				indexA++;
			}
			if(a>=b){ 
				listC.add(b);
				indexB++;
			}
			 
		}
		if(indexA>=sizeA){
			listC.addAll(listB.subList(indexB, sizeB));
		}
		else
			listC.addAll(listA.subList(indexA, sizeA));
		return listC;
	}
	public int howManyComparisons(int[] numbers){
		num=0;
		List<Integer>list=new ArrayList(numbers.length);
		for(int i:numbers)
			list.add(i);
		mergeSort(list);
		return num;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []numbers={ };
		MergeSort sort=new MergeSort();
		System.out.println(sort.howManyComparisons(numbers));

	}

}
