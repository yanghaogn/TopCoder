package cn.yanghao.topCoder.SRMS24;
/*
 * 
Problem Statement
    
DNA testing is one of the most popular methods of establishing paternity. In such a test, you compare samples of DNA from the man, the child, and the child's mother. For the purposes of this problem, assume that each sample is represented as a String of uppercase letters ('A'-'Z'). If half of the characters in the child's sample match the characters in the corresponding positions in the man's sample, and the remaining characters in the child's sample match the characters in the corresponding positions in the mother's sample, then the man is most likely the father. On the other hand, if it is impossible to partition the child's sample such that half of the characters match the man's and the other half match the mother's, then the man is definitely ruled out as the father.
For example, suppose the child's sample is "ABCD" and the mother's sample is "AXCY" (all quotes for clarity only). The 'A' and 'C' in the child's sample must have come from the mother, so the 'B' and 'D' must have come from the father. If the man's sample is "SBTD", then he is most likely the father, but if the man's sample is "QRCD", then he is definitely not the father. Note in the latter case that the man was definitely ruled out even though half of his sample (the 'C' and 'D') did in fact match the child's.
Your method will take samples from the child and the mother, as well as samples from several men, and return the indices of the men who cannot be ruled out as the father, in increasing order.
Definition
    
Class:
PaternityTest
Method:
possibleFathers
Parameters:
String, String, String[]
Returns:
int[]
Method signature:
int[] possibleFathers(String child, String mother, String[] men)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
You may assume that the identity of the mother is not in question.
Constraints
-
men contains between 1 and 5 elements, inclusive.
-
child, mother, and all elements of men contain the same number of characters, which is even and between 2 and 20, inclusive.
-
child, mother, and all elements of men contain only uppercase letters ('A'-'Z').
-
At least half of the characters in mother match the characters in the corresponding positions in child.
Examples
0)

    
"ABCD"
"AXCY"
{ "SBTD", "QRCD" }
Returns: { 0 }
The example above.
1)

    
"ABCD"
"ABCX"
{ "ABCY", "ASTD", "QBCD" } 
Returns: { 1,  2 }
"ABCY" could not be the father. "ASTD" could be the father, with the 'A' and 'D' coming from the father and the 'B' and 'C' coming from the mother. "QBCD" could also be the father, with either the 'B' and 'D' or the 'C' and 'D' coming from the father.
2)

    
"ABABAB"
"ABABAB"
{ "ABABAB", "ABABCC", "ABCCDD", "CCDDEE" }
Returns: { 0,  1 }

3)

    
"YZGLSYQT"
"YUQRWYQT"
{"YZQLDPWT", "BZELSWQM", "OZGPSFKT", "GZTKFYQT", "WQJLSMQT"}
Returns: { }

4)

    
"WXETPYCHUWSQEMKKYNVP"
"AXQTUQVAUOSQEEKCYNVP"
{ "WNELPYCHXWXPCMNKDDXD",
  "WFEEPYCHFWDNPMKKALIW",
  "WSEFPYCHEWEFGMPKIQCK",
  "WAEXPYCHAWEQXMSKYARN",
  "WKEXPYCHYWLLFMGKKFBB" }
Returns: { 1,  3 }

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
import java.util.ArrayList;
import java.util.List;

public class  PaternityTest{
	public int[] possibleFathers(String child, String mother, String[] men){
		List<Integer> list=new ArrayList(men.length);
		StringBuilder pattern=new StringBuilder(child.length());
		final int N=child.length(); 
		for(int i=0;i<N;i++)
		{
			if(child.charAt(i)==mother.charAt(i)){
				pattern.append(".");
			}else{ 
				pattern.append(child.charAt(i));
			}
		}
		for(int i=0;i<men.length;i++){
			if(men[i].matches(pattern.toString())){
				int numEqual=0;
				for(int j=0;j<men[i].length();j++){
					if(child.charAt(j)==men[i].charAt(j)){
						numEqual++;
					}
				}
				if(numEqual>=N/2)
					list.add(i);
			}
		}
		int [] result=new int[list.size()];
		for(int i=0;i<list.size();i++)
			result[i]=list.get(i);
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String child="WXETPYCHUWSQEMKKYNVP";
		String mother="AXQTUQVAUOSQEEKCYNVP";
		String []men={ "WNELPYCHXWXPCMNKDDXD",
				  "WFEEPYCHFWDNPMKKALIW",
				  "WSEFPYCHEWEFGMPKIQCK",
				  "WAEXPYCHAWEQXMSKYARN",
				  "WKEXPYCHYWLLFMGKKFBB" };
		int []p=new PaternityTest().possibleFathers(child, mother, men);
		for(int i:p)
			System.out.print(i+"\t");
	}

}
