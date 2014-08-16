package cn.yanghao.topCoder.SRMS11;
/*
 * 
Problem Statement
    
It is a common practice in cryptography to remove the spaces from a message before encoding it to help to disguise its structure. Even after it is then decoded, we are left with the problem of putting the spaces back in the message.
Create a class MessageMess that contains a method restore that takes a String[] dictionary of possible words and a String message as inputs. It returns the message with single spaces inserted to divide the message into words from the dictionary. If there is more than one way to insert spaces, it returns "AMBIGUOUS!" If there is no way to insert spaces, it returns "IMPOSSIBLE!" The return should never have any leading or trailing spaces.
Definition
    
Class:
MessageMess
Method:
restore
Parameters:
String[], String
Returns:
String
Method signature:
String restore(String[] dictionary, String message)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
Don't forget the '!' at the end of the two special returns
-
A proper message may require 0 spaces to be inserted
Constraints
-
dictionary will contain between 1 and 50 elements inclusive
-
the elements of dictionary will be distinct
-
each element of dictionary will contain between 1 and 50 characters
-
message will contain between 1 and 50 characters
-
every character in message and in each element of dictionary will be an uppercase letter 'A'-'Z'
Examples
0)

    
{"HI", "YOU", "SAY"}
"HIYOUSAYHI"
Returns: "HI YOU SAY HI"
A word from dictionary may appear multiple times in the message.
1)

    
{"ABC", "BCD", "CD", "ABCB"}
"ABCBCD"
Returns: "AMBIGUOUS!"
"ABC BCD" and "ABCB CD" are both possible interpretations of message.
2)

    
{"IMPOSS", "SIBLE", "S"}
"IMPOSSIBLE"
Returns: "IMPOSSIBLE!"
There is no way to concatenate words from this dictionary to form "IMPOSSIBLE"
3)

    
{"IMPOSS", "SIBLE", "S", "IMPOSSIBLE"}
"IMPOSSIBLE"
Returns: "IMPOSSIBLE"
This message can be decoded without ambiguity. This requires the insertion of no spaces since the entire message appears as a word in the dictionary.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
import java.util.LinkedList;
public class MessageMess {
	String[] dictionary;
	boolean[] possibles;
	int LEN;
	int count;
	String message;

	boolean startWith(int index, String s) {
		//System.out.println(message.substring(index)+"\t"+s);
		if (LEN - index < s.length()){
			//System.out.println(message.substring(index)+"\t"+s);
			return false;
			}
		for (int i = 0; i < s.length(); i++)
			if (message.charAt(i + index) != s.charAt(i)){
				return false;
			}
		
		return true;
	}

	LinkedList<Integer> restore(int index) {
		
		if (index>=LEN||possibles[index] == false||count>1)
			return null;
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < dictionary.length; i++) {
			String dic = dictionary[i];
			if (startWith(index, dic)) {
				if (index + dic.length() == LEN ) {
					count++;
					if (count > 1)
						return null;
					result.add(i);
				}else{
					LinkedList<Integer>tmp=restore(index+dic.length());
					if(tmp!=null){
						result.add(i);
						result.addAll(tmp);
					}
				}
			} 
		}
		if(result.size()==0)
		{
			possibles[index]=false;
			return null;
		}
		return result;
	}

	public String restore(String[] dictionary, String message) {
		StringBuilder result = null;
		this.dictionary = dictionary;
		this.message = message;
		this.LEN = message.length();
		count = 0;
		this.possibles = new boolean[LEN];
		for (int i = 0; i < LEN; i++)
			possibles[i] = true;
		LinkedList<Integer> linkResult = restore(0);
		if (count == 0)
			return "IMPOSSIBLE!";
		if (count > 1)
			return "AMBIGUOUS!";
		result = new StringBuilder(LEN + linkResult.size());
		for (int i : linkResult)
			result.append(dictionary[i] + " ");
		return result.toString().trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dictionary = 
			 {"IMPOSS", "SIBLE", "S"}
		;
		String message = 
				 "IMPOSSIBLE"
				;
		System.out.println(new MessageMess().restore(dictionary, message));
	}

}
