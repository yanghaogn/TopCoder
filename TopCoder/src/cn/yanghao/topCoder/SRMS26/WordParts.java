package cn.yanghao.topCoder.SRMS26;
/*
 * 
Problem Statement
    
Given a base word, original, and a compound word, compound, decide if the compound word is valid. A compound word is valid if and only if it is comprised solely of a concatenation of prefixes and/or suffixes of original. That is, if the compound word can be partitioned into N parts, such that each part is equal to either a prefix or a suffix of original, then it is valid. If the word is invalid, return -1. Otherwise, return the minimum value of N for which this is possible.
Definition
    
Class:
WordParts
Method:
partCount
Parameters:
String, String
Returns:
int
Method signature:
int partCount(String original, String compound)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
The entire base word original is considered a valid prefix/suffix of itself. See example 3.
Constraints
-
original will contain between 1 and 50 characters, inclusive.
-
original will consist only of uppercase letters (A-Z).
-
compound will contain between 0 and 50 characters, inclusive.
-
compound will consist only of uppercase letters (A-Z).
Examples
0)

    
"ANTIDISESTABLISHMENTARIANISM"
"ANTIDISIANISMISM"
Returns: 3
"ANTIDISIANISMISM" can be split into "ANTIDIS", "IANISM", and "ISM", all of which are substrings from the beginning or end of the base word.
1)

    
"ANTIDISESTABLISHMENTARIANISM"
"ESTABLISHMENT"
Returns: -1
While "ESTABLISHMENT" is contained in "ANTIDISESTABLISHMENTARIANISM", it neither starts at the beginning nor ends at the end of that string. Furthermore, "ESTABLISHMENT" cannot be broken into any number of parts which satisfy this rule.
2)

    
"TOPCODERDOTCOM"
"TOMTMODERDOTCOM"
Returns: 5
The five strings are "TO", "M", "T", "M", and "ODERDOTCOM".
3)

    
"HELLO"
"HELLOHEHELLOLOHELLO"
Returns: 5
Note that the entire original word is considered a valid prefix/suffix.
4)

    
"DONTFORGETTHEEMPTYCASE"
""
Returns: 0

5)

    
"BAAABA"
"BAAABAAA"
Returns: 2

6)

    
"ABBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABB"
"BBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABAA"
Returns: 17

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class WordParts {
	int []PARTION;
	char[]ORIGIN;
	char []COMPOUND;
	int numCompound;
	int numOriginal;
	public int partCount(String original, String compound){

		numOriginal=original.length();
		numCompound=compound.length();
		if(0==numOriginal)
			return 0;
		if(0==numOriginal)
			return -1;
		PARTION=new int[numCompound];
		ORIGIN=original.toCharArray();
		COMPOUND=compound.toCharArray();
		for(int i=0;i<numCompound;i++)
			PARTION[i]=Integer.MAX_VALUE;
		return countNumPartion(0);
	}
	int countNumPartion(int fromIndex){
		if(fromIndex>=numCompound)
			return 0;
		if(Integer.MAX_VALUE!=PARTION[fromIndex])
			return PARTION[fromIndex];
		int min=Integer.MAX_VALUE;
		final int endIndex=Math.min(fromIndex+numOriginal-1,numCompound-1);
		for(int i=endIndex;i>=fromIndex;i--){
			if(is(fromIndex,i)){
				int t=countNumPartion(i+1);
				if(-1==t)
					continue;
				min=Math.min(min, 1+t);
			}
		}
		PARTION[fromIndex]=Integer.MAX_VALUE==min?-1:min;
		return PARTION[fromIndex];
	}
	boolean is(int fromIndex,int endIndex){
		return isPrefix(fromIndex,endIndex)||isSuffix(fromIndex,endIndex);
	}
	boolean isPrefix(int fromIndex,int endIndex){
		if(endIndex-fromIndex+1>numOriginal)
			return false;
		for(int i=0;i+fromIndex<=endIndex;i++)
			if(ORIGIN[i]!=COMPOUND[i+fromIndex])
				return false;
		return true;
	}
	boolean isSuffix(int fromIndex,int endIndex){
		if(endIndex-fromIndex+1>numOriginal)
			return false;
		for(int i=0;i+fromIndex<=endIndex;i++)
			if(ORIGIN[numOriginal-i-1]!=COMPOUND[endIndex-i])
				return false;
		return true;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original="ABBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABB";
		String compound="BBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABAA";
		System.out.println(new WordParts().partCount(original, compound));
	}

}
