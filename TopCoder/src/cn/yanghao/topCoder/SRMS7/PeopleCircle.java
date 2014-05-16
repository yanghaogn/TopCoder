package cn.yanghao.topCoder.SRMS7;
/*
 * 
 
Problem Statement
    
There are numMales males and numFemales females arranged in a circle. Starting from a given point, you count clockwise and remove the K'th person from the circle (where K=1 is the person at the current point, K=2 is the next person in the clockwise direction, etc...). After removing that person, the next person in the clockwise direction becomes the new starting point. After repeating this procedure numFemales times, there are no females left in the circle.
Given numMales, numFemales and K, your task is to return what the initial arrangement of people in the circle must have been, starting from the starting point and in clockwise order.
For example, if there are 5 males and 3 females and you remove every second person, your return String will be "MFMFMFMM".
Definition
    
Class:
PeopleCircle
Method:
order
Parameters:
int, int, int
Returns:
String
Method signature:
String order(int numMales, int numFemales, int K)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
numMales is between 0 and 25 inclusive
-
numFemales is between 0 and 25 inclusive
-
K is between 1 and 1000 inclusive
Examples
0)

    
5
3
2
Returns: "MFMFMFMM"
Return "MFMFMFMM". On the first round you remove the second person - "M_MFMFMM". Your new circle looks like "MFMFMMM" from your new starting point. Then you remove the second person again etc.
1)

    
7
3
1
Returns: "FFFMMMMMMM"
Starting from the starting point you remove the first person, then you continue and remove the next first person etc. Clearly, all the females are located at the beginning. Hence return "FFFMMMMMMM"
2)

    
25
25
1000
Returns: "MMMMMFFFFFFMFMFMMMFFMFFFFFFFFFMMMMMMMFFMFMMMFMFMMF"

3)

    
5
5
3
Returns: "MFFMMFFMFM"
Here we mark the removed people with '_', and the starting position with lower-case:
Number of      | People Remaining
Rounds         | (in initial order)
---------------+-----------------
 0             | mFFMMFFMFM
 1             | MF_mMFFMFM
 2             | MF_MM_fMFM
 3             | MF_MM_FM_m
 4             | M__mM_FM_M
 5             | M__MM__m_M
4)

    
1
0
245
Returns: "M"

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class PeopleCircle {
	public String order(int numMales, int numFemales, int K){
		int LEN=numMales+numFemales;
		int i=0,j,times,index=0,mod=0;
		char []result=new char[LEN];
		for(i=0;i<LEN;i++)
			result[i]='M';
		for(i=0;i<numFemales;i++){
			mod=K%(LEN-i);
			if(0==mod)
				mod=LEN-i;
			for(j=1;j<mod;j++){
				while(result[index=(++index)%LEN]=='F');
			}
			result[index]='F';
			times=0;
			while(result[index=(++index)%LEN]=='F'&&times++<LEN);
		}
		return new String(result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PeopleCircle().order(0, 1, 23));
	}

}
