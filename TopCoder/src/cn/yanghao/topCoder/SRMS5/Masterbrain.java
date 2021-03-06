package cn.yanghao.topCoder.SRMS5;
/*
 * 
 * 
Problem Statement
    
Masterbrain is a two player board game in which one player decides on a secret combination of digits, while the other must figure it out in 10 guesses or less. The game differs from Mastermind in that the player making the secret combination is allowed to lie once.
The game consists of one player making a sequence of guesses about what the secret combination is, and the other player giving him or her certain information about the quality of the guess. The following is how each guess is analyzed: if a digit is in the correct position then a black peg is given. If a digit is in the guess but in the wrong position then a white peg is given. For all other cases no pegs are given.
For example, if guess = "1234", secret = "2335". Analyzing the guess digit by digit; the '1' is not in secret - no pegs given. The '2' is in secret but not in the right place - white peg given. The '3' is in secret and in the right place - black peg given. The '4' is not in secret - no pegs given. Result should be "1b 1w", meaning one black peg and one white peg. Now, if guess is "2334" and secret is "3224", we have the following: '2' is in secret, but not in the right place - white peg given. The first '3' is in secret, but not in the right place - white peg given. Since the '3' in secret has been used, the second '3' in guess should return no pegs. The '4' is in secret and in the right place - black peg given. Result should be "1b 2w".
Given a String[] of guesses and a String[] of results for those guesses, return the total number of possible secret combinations, assuming that exactly one of the results is incorrect. Each element of results will be formatted as "<x>b <y>w", where <x> and <y> are the number of black and white pegs respectively.
Definition
    
Class:
Masterbrain
Method:
possibleSecrets
Parameters:
String[], String[]
Returns:
int
Method signature:
int possibleSecrets(String[] guesses, String[] results)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
The second player must lie exactly once.
-
Black pegs always take precedence over white pegs. Thus, when analyzing a guess, black pegs are assigned first, and then white pegs are assigned.
-
No digit in either a guess or a secret combination may be involved in giving more than one peg.
Constraints
-
guesses and results will have the same number of elements.
-
guesses will have between 1 and 10 elements inclusive.
-
results will have between 1 and 10 elements inclusive.
-
each element in guesses will contain exactly 4 characters and will only contain digits between '1' and '7' inclusive.
-
each element in results will contain exactly 5 characters.
-
each element of results will be formatted as follows: "<x>b <y>w", where <x> represents the number of black pegs and <y> represents the number of white pegs in a guess. <x> and <y> are non-negative integers whose sum is less than or equal to 4.
-
results will never have "3b 1w", because that is impossible.
Examples
0)

    
{"1575"} 
{"4b 0w"}
Returns: 2400
If the result was true, we would conclude that 1575 is the only possible combination. However, we know that the second player must lie exactly once, thus we know that 1575 is the only combination NOT possible. Since there are 7^4 = 2401 total combinations, the method should return 2401-1 = 2400.
1)

    
{"1234"}
{"0b 4w"}
Returns: 2392
If the result was true then the set of secret combinations would have 9 elements: {2143, 2341, 2413, 3142, 3412, 3421, 4123, 4312, 4321}. But since the result is false, we must subtract this number from the total. The method should return 2401-9 = 2392.
2)

    
{"6172","6162","3617"}
{"3b 0w","2b 1w","0b 3w"}
Returns: 14
If all results were true, then the secret must be 6176. If the first result is false then the set of secret combinations is {1362, 1762, 2163, 6123, 6136, 6176, 6361, 6761, 7166}. If the second result is false then set is {6132, 6171, 6174, 6175, 6176, 6372}. Finally, if the third result is false then the set is {6176, 6672}. Thus the method should return (9-1)+(6-1)+(2-1) = 14.
3)

    
{"1513","5654","4564","1377","1671","1342"}
{"1b 0w","0b 1w","1b 0w","1b 0w","0b 1w","0b 1w"}
Returns: 6

4)

    
{"2611", "1371", "7417", "2647", "3735", "4272", "2442", "3443", "1252", "3353"}
{"0b 2w","0b 2w","0b 1w","0b 2w","1b 0w","1b 0w","1b 0w","0b 1w","1b 1w","0b 1w"}
Returns: 1

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Masterbrain {
	public int possibleSecrets(String[] guesses, String[] results){
		int result=0;
		int unMatch=0;
		String correct;
		char []digits={'1','2','3','4','5','6','7'};
		for(char first:digits){
			for(char second:digits){
				for(char third:digits){
					for(char fourth:digits){
						correct=""+first+second+third+fourth;
						unMatch=0;
						for(int j=0;j<guesses.length;j++){
							if(!getResult(guesses[j],correct).equals(results[j]))
								unMatch++;
							if(unMatch>=2)
								break;
						}
						if(1==unMatch)
							result++;
					}
				}
			}
			
		}
		return result;
	}
	String getResult(final String guess,final String correct){
		int numBlack=0;
		int numWhite=0;
		int []c={0,0,0,0,0,0,0};
		int []g={0,0,0,0,0,0,0};
		for(int i=0;i<4;i++){
			if(correct.charAt(i)==guess.charAt(i))
				numBlack++;
			else{
				 
				c[correct.charAt(i)-'1']++;
				g[guess.charAt(i)-'1']++;
			}
		}
		for(int i=0;i<7;i++)
			numWhite+=Math.min(g[i], c[i]);
		return numBlack+"b "+numWhite+"w";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] guesses={"2611", "1371", "7417", "2647", "3735", "4272", "2442", "3443", "1252", "3353"} ;
		String[] results={"0b 2w","0b 2w","0b 1w","0b 2w","1b 0w","1b 0w","1b 0w","0b 1w","1b 1w","0b 1w"};
		System.out.println(new Masterbrain().possibleSecrets(guesses, results));
	}

}
