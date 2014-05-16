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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MessageMess {
	String[] dictionary;
	String message;
	int LEN;
	boolean[] possibles;
	int count;

	static class middleResult {
		LinkedList<Integer> start;
		LinkedList<Integer> end;
		int startIndex;
		int endIndex;

		middleResult() {
			startIndex = 0;
			endIndex = 0;
			start = new LinkedList<Integer>();

		}

	}

	boolean startWith(int index, String s) {
		int sLEN = s.length();
		if (index + sLEN > LEN)
			return false;
		for (int i = 0; i < sLEN; i++)
			if (message.charAt(i + index) != s.charAt(i))
				return false;
		return true;
	}

	LinkedList<LinkedList<Integer>> restore(int index) {
		if (false == possibles[index])
			return null;
		if(count>=2)
			return null;
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		for (int i = 0; i < dictionary.length; i++) {
			if (startWith(index, dictionary[i])) {
				if (index + dictionary[i].length() == LEN) {
					LinkedList<Integer> p = new LinkedList<Integer>();
					p.add(i);
					result.add(p);
					count++;
					if (count >= 2)
						return null;
				} else {
					LinkedList<LinkedList<Integer>> pResult = restore(index
							+ dictionary[i].length());
					if (null != pResult)
						for (LinkedList<Integer> list : pResult) {
							list.addFirst(i);
							result.add(list);
						}
					if (result.size() >= 2)
						break;
				}

			}
		}
		if (0 == result.size())
			possibles[index] = false;
		return result;
	}

	public String restore(String[] dictionary, String message) {
		this.dictionary = dictionary;
		this.message = message;
		this.LEN = message.length();
		count = 0;
		possibles = new boolean[LEN + 1];
		for (int i = 0; i <= LEN; i++)
			possibles[i] = true;
		LinkedList<LinkedList<Integer>> result = restore(0);
		if (count == 0)
			return "IMPOSSIBLE!";
		if (count > 1)
			return "AMBIGUOUS!";
		StringBuilder sResult = new StringBuilder(LEN + dictionary.length);
		for (int i : result.get(0)) {
			sResult.append(dictionary[i] + " ");
		}
		return sResult.toString().trim();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dictionary = {"A", "AA", "AAA", "AAAA", "AAAAA", "AAAAAA", "AAAAAAA", "AAAAAAAA", "AAAAAAAAA", "AAAAAAAAAA", "AAAAAAAAAAA", "AAAAAAAAAAAA", "AAAAAAAAAAAAA", "AAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"};
		String message = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		System.out.println(new MessageMess().restore(dictionary, message));

	}

}
