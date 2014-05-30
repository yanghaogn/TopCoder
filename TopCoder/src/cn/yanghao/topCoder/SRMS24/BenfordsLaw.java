package cn.yanghao.topCoder.SRMS24;
/*
 * 
 * 
Problem Statement
    
Pick a random financial transaction from the ledger of a typical business and there is about a 30% chance that the first non-zero digit of the amount of money involved is a 1. This counter-intuitive fact is a result of Benford's Law, discovered by astronomer Simon Newcomb in the late 1800's and rediscovered by physicist Frank Benford in the early 1900's. They found that real world data are not evenly distributed. Instead, given a random number related to some natural or social phenomenon satisfying certain conditions, the probability that the first non-zero digit of the number is D is log10(1 + 1/D).
Increasingly, financial auditors are using Benford's Law to detect possible fraud. Given a record of the financial transactions of a company, if some leading digit appears with a frequency that significantly differs from that predicted by Benford's Law, it is a signal that those transactions deserve a closer look.
Create a class BenfordsLaw with a method questionableDigit that takes a int[] transactions and an int threshold and returns the smallest digit that appears as the first non-zero digit of numbers in transactions with a frequency that is at least threshold times more or less than its expected frequency (e.g., more than three times the expected frequency or less than one-third the expected frequency when threshold=3). If no such digit exists, return -1.
For example, consider the data
    5236    7290     200    1907    3336
    9182      17    4209    8746    7932
    6375     909    2189    3977    2389
    2500    1239    3448    6380    4812
The following chart gives the actual frequency of each leading digit, and its expected frequency according to Benford's law.
    digit    | 1    2    3    4    5    6    7    8    9
    ---------|---------------------------------------------
    actual   | 3    4    3    2    1    2    2    1    2
    expected | 6.02 3.52 2.50 1.94 1.58 1.34 1.16 1.02 0.92
Assuming a threshold of 2, there are two digits that are questionable: the leading digit 1 appears less than half as often as expected and the leading digit 9 appears more than twice as often as expected. Since 1 is smaller than 9, the answer is 1.
Note that, although the expected frequencies have been rounded to two decimal places in the above table for the purposes of presentation, you should perform all such calculations without rounding. Errors of up to 0.000001 in the expected frequencies will not affect the final answer.
Definition
    
Class:
BenfordsLaw
Method:
questionableDigit
Parameters:
int[], int
Returns:
int
Method signature:
int questionableDigit(int[] transactions, int threshold)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
In the formula for Benford's Law, log10 means the base-10 logarithm.
Constraints
-
transactions contains between 1 and 50 elements, inclusive.
-
Each element of transactions is between 1 and 999999999, inclusive.
-
threshold is between 2 and 10, inclusive.
-
Errors of up to 0.000001 in calculating the expected frequencies will not affect the final answer.
Examples
0)

    
{ 5236,7290,200,1907,3336,9182,17,4209,8746,7932,
  6375,909,2189,3977,2389,2500,1239,3448,6380,4812 }
2
Returns: 1
The example above.
1)

    
{ 1,10,100,2,20,200,2000,3,30,300 }
2
Returns: 2
2 and 3 appear more than twice as often as expected, and 4 through 9 appear less than half as often as expected. 2 is the smallest of these digits.
2)

    
{ 9,87,765,6543,54321,43219,321987,21987,1987,345,234,123 }
2
Returns: -1

3)

    
{ 1,2,3,4,5,6,7,8,7,6,5,4,3,2,1 }
8
Returns: 9

4)

    
{ 987,234,1234,234873487,876,234562,17,
  7575734,5555,4210,678234,3999,8123 }
3
Returns: 8

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
import javax.lang.model.element.Element;

public class BenfordsLaw {

	public int questionableDigit(int[] transactions, int threshold){
		int result =-1;
		double []expect=new double[10];
		double []actual=new double[10];
		final int N=transactions.length;
		final double ERROR=0.000001;
		for(int i=1;i<10;i++){
			expect[i]=Math.log10(1+1.0/i)*N;
			actual[i]=0;
		}
		for(int element:transactions){
			while(element>=10)
				element/=10;
			actual[element]++;
		}
		for(int i=1;i<10;i++){
			if(actual[i]>=expect[i]*threshold-ERROR)
				return i;
			if(actual[i]<=expect[i]/threshold+ERROR)
				return i;
			System.out.println(i+":"+actual[i]+"\t"+expect[i]);
		}	 
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []transactions={ 987,234,1234,234873487,876,234562,17,
				  7575734,5555,4210,678234,3999,8123 };
		int threshold=3;
		System.out.println(new BenfordsLaw().questionableDigit(transactions, threshold));
	}

}
