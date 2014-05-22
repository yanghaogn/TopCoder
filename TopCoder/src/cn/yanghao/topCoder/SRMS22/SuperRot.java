package cn.yanghao.topCoder.SRMS22;
/*
 * 
Problem Statement
    
There exists a basic encryption method known as ROT13. One property of ROT13 is that the encryption and decryption processes are exactly the same. These processes work by doing a simple transformation from one letter of the alphabet to another. The letters A through M become N through Z, such that A->N, B->O, ..., M->Z. The letters N through Z become A through M, such that N->A, O->B, ..., Z->M.  One of the problems with most implementations is that everything is converted to upper case. Another problem is that numbers are ignored completely, leaving them unencrypted. One way to overcome these limitations is to extend ROT13 to cover lowercase letters as well as numbers. Here is how our extended ROT transformations will work:
characters   become
   A-M        N-Z
   N-Z        A-M
   a-m        n-z
   n-z        a-m
   0-4        5-9
   5-9        0-4
 For example, the message "Uryyb 28" would become "Hello 73" after being transformed.
   U -> H        2 -> 7
   r -> e        8 -> 3
   y -> l
   y -> l
   b -> 0
Notice that the spaces were left as is.  You have intercepted a message which you believe to be encrypted using this process. Create a class SuperRot with a method decoder that takes a String message and returns the decoded message as a String.
Definition
    
Class:
SuperRot
Method:
decoder
Parameters:
String
Returns:
String
Method signature:
String decoder(String message)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
All spaces occuring in message are left as spaces in the decoded String.
Constraints
-
message will have between 0 and 50 characters inclusive.
-
message will consist only of letters 'a' - 'z' and 'A' - 'Z', digits '0' - '9', and the space character.
-
message will not contain two or more consecutive spaces.
-
There will be no leading or trailing spaces.
Examples
0)

    
"Uryyb 28"
Returns: "Hello 73"
This is the example from above.
1)

    
"GbcPbqre"
Returns: "TopCoder"
G -> T
b -> o
c -> p
P -> C
b -> o
q -> d
r -> e
e -> r
2)

    
""
Returns: ""
Remember the empty String.
3)

    
"5678901234"
Returns: "0123456789"

4)

    
"NnOoPpQqRr AaBbCcDdEe"
Returns: "AaBbCcDdEe NnOoPpQqRr"

5)

    
"Gvzr vf 54 71 CZ ba Whyl 4gu bs gur lrne 7558 NQ"
Returns: "Time is 09 26 PM on July 9th of the year 2003 AD"

6)

    
"Gur dhvpx oebja sbk whzcf bire n ynml qbt"
Returns: "The quick brown fox jumps over a lazy dog"

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class SuperRot{
	/*
	A-M        N-Z
   N-Z        A-M
   a-m        n-z
   n-z        a-m
   0-4        5-9
   5-9        0-4
   */
	char encrypt(char source){
		if(' '==source)return ' ';
		if (source>='A'&&source<='M') {
			return (char) (source+('N'-'A'));
		}
		if (source>='N'&&source<='Z') {
			return (char) (source-('N'-'A'));
		}
		if (source>='a'&&source<='m') {
			return (char) (source+('n'-'a'));
		}
		if (source>='n'&&source<='z') {
			return (char) (source-('n'-'a'));
		}
		if (source>='0'&&source<='4') {
			return (char) (source+5);
		}
		if (source>='5'&&source<='9') {
			return (char) (source-5);
		}
		return ' ';

	}
	public String decoder(String message){
		StringBuilder result=new StringBuilder(message.length());
		for (int i=0;i<message.length();i++ ) {
			result.append(encrypt(message.charAt(i)));
		}
		return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(new SuperRot().decoder("Gur dhvpx oebja sbk whzcf bire n ynml qbt"));
	}
}