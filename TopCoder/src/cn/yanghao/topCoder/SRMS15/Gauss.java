package cn.yanghao.topCoder.SRMS15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 
Problem Statement
    
Carl Friedrich Gauss (1777-1855) is considered to be one of the greatest mathematicians ever. There is a nice story about him being at elementary school: The teacher wanted to keep the class busy and assigned to them the task of adding all whole numbers from 1 to 100. While the other kids were just about to start their additions, Gauss already presented the result, 5050. He noticed that the numbers can be grouped into 50 pairs of value 101 (1+100, 2+99, ...), and from this he deduced that the sum of all natural numbers from 1 to n equals n(n+1)/2.  Now let's consider adding consecutive numbers not only starting at 1 but at any natural number. E.g. if you start at 13 and add three consecutive numbers, you get 13+14+15 = 42. Now can 42 also be achieved by adding two or more consecutive numbers starting at a different number? Yes, it can: 3+4+5+6+7+8+9 = 9+10+11+12 = 42.  Given a number target, return all intervals representing a sequence of two or more consecutive natural numbers (positive integers) that add up to target. The intervals have to be sorted by ascending lower interval limits. The interval representing the sequence a + (a+1) + ... + (b-1) + b is the String "[a, b]" (quotes for clarity; there is a single space between the comma and b).
Definition
    
Class:
Gauss
Method:
whichSums
Parameters:
String
Returns:
String[]
Method signature:
String[] whichSums(String target)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
The value of target fits into a long.
Constraints
-
target represents a natural number between 1 and 10^11, inclusive, without leading zeros.
Examples
0)

    
"42"
Returns: { "[3, 9]",  "[9, 12]",  "[13, 15]" }
This is the example from the problem statement.
1)

    
"4"
Returns: { }
There are no 2 or more consecutive natural numbers that add up to 4.
2)

    
"17"
Returns: { "[8, 9]" }

3)

    
"55"
Returns: { "[1, 10]",  "[9, 13]",  "[27, 28]" }

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Gauss {

	public String[] whichSums(String target){
		long sum=Long.parseLong(target)*2;
		 
		List<String> result=new LinkedList();
		for(long num=Math.round(Math.sqrt(sum))+1;num>1;num--){
			if(0==sum%num){
				long t=sum/num+1-num;
				if(t>0&&0==(t&1)){
					long a1=t/2;
					long an=a1+num-1;
					result.add("["+a1+", "+an+"]");
				}
			}
		}
		
		return  result.toArray(new String[result.size()]);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] result=new Gauss().whichSums("99999999997");
		for(String p:result){
			System.out.println(p);
		}
	}

}
