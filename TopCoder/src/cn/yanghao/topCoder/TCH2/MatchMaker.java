package cn.yanghao.topCoder.TCH2;
/*
 * 
Problem Statement
    
THIS PROBLEM WAS TAKEN FROM THE SEMIFINALS OF THE TOPCODER INVITATIONAL
TOURNAMENT

DEFINITION
Class Name: MatchMaker
Method Name: getBestMatches
Paramaters: String[], String, int
Returns: String[]
Method signature (be sure your method is public):  String[]
getBestMatches(String[] members, String currentUser, int sf);

PROBLEM STATEMENT
A new online match making company needs some software to help find the "perfect
couples".  People who sign up answer a series of multiple-choice questions.
Then, when a member makes a "Get Best Mates" request, the software returns a
list of users whose gender matches the requested gender and whose answers to
the questions were equal to or greater than a similarity factor when compared
to the user's answers.

Implement a class MatchMaker, which contains a method getBestMatches.  The
method takes as parameters a String[] members, String currentUser, and an int
sf:
- members contains information about all the members.  Elements of members are
of the form "NAME G D X X X X X X X X X X" 
   * NAME represents the member's name
   * G represents the gender of the current user. 
   * D represents the requested gender of the potential mate. 
* Each X indicates the member's answer to one of the multiple-choice
questions.  The first X is the answer to the first question, the second is the
answer to the second question, et cetera. 
- currentUser is the name of the user who made the "Get Best Mates" request.  
- sf is an integer representing the similarity factor.

The method returns a String[] consisting of members' names who have at least sf
identical answers to currentUser and are of the requested gender.  The names
should be returned in order from most identical answers to least.  If two
members have the same number of identical answers as the currentUser, the names
should be returned in the same relative order they were inputted.

TopCoder will ensure the validity of the inputs.  Inputs are valid if all of
the following criteria are met:
- members will have between 1 and 50 elements, inclusive.
- Each element of members will have a length between 7 and 44, inclusive.
- NAME will have a length between 1 and 20, inclusive, and only contain
uppercase letters A-Z.
- G can be either an uppercase M or an uppercase F.
- D can be either an uppercase M or an uppercase F.
- Each X is a capital letter (A-D).
- The number of Xs in each element of the members is equal.  The number of Xs
will be between 1 and 10, inclusive. 
- No two elements will have the same NAME.
- Names are case sensitive.
- currentUser consists of between 1 and 20, inclusive, uppercase letters, A-Z,
and must be a member.
- sf is an int between 1 and 10, inclusive.
- sf must be less than or equal to the number of answers (Xs) of the members.

NOTES
The currentUser should not be included in the returned list of potential mates.


EXAMPLES

For the following examples, assume members =
{"BETTY F M A A C C",
 "TOM M F A D C A",
 "SUE F M D D D D",
 "ELLEN F M A A C A",
 "JOE M F A A C A",
 "ED M F A D D A",
 "SALLY F M C D A B",
 "MARGE F M A A C C"}

If currentUser="BETTY" and sf=2, BETTY and TOM have two identical answers and
BETTY and JOE have three identical answers, so the method should return
{"JOE","TOM"}.

If currentUser="JOE" and sf=1, the method should return
{"ELLEN","BETTY","MARGE"}.

If currentUser="MARGE" and sf=4, the method should return [].
Definition
    
Class:
MatchMaker
Method:
getBestMatches
Parameters:
String[], String, int
Returns:
String[]
Method signature:
String[] getBestMatches(String[] param0, String param1, int param2)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class MatchMaker {

	Map<Integer,ArrayList<String>>map=new TreeMap();
	 
	static class Member{
		String user;
		char gender;
		char requestGender;
		char[]answer;
		Member(String member){
			String[]splits=member.split(" ");
			user=splits[0];
			gender=splits[1].charAt(0);
			requestGender=splits[2].charAt(0);
			int len=splits.length-3;
			answer=new char[len];
			for(int i=0;i<len;i++)
				answer[i]=splits[i+3].charAt(0);
			
		}
		int countSame(final Member other){
			if(requestGender!=other.gender)
				return -1;
			if(this==other)
				return -1;
			int result=0;
			for(int i=0;i<answer.length;i++)
				if(other.answer[i]==answer[i])
					result++;
			return result;
		}
	}
 
	public String[] getBestMatches(String[] members, String currentUser, int sf){
		int num=members.length;
		Member[] listMember=new Member[num];
		Member currentMember=null;
		for(int i=0;i<num;i++){
			listMember[i]=new Member(members[i]);
			if(currentUser.equals(listMember[i].user))
				currentMember=listMember[i];
		}
		for(int i=0;i<num;i++){
			int similor=currentMember.countSame(listMember[i]);
			if(similor>=sf){
				ArrayList<String> allMembers=map.get(-similor);
				if(null==allMembers){
					allMembers=new ArrayList();
				}
				allMembers.add(listMember[i].user);
				map.put(-similor,allMembers);
			}	
		}
		
		ArrayList<String> orderedMembers=new ArrayList();
		for(ArrayList list:map.values())
			orderedMembers.addAll(list);
		String []result=new String[orderedMembers.size()];
		return orderedMembers.toArray(result);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []members={"BETTY F M A A C C",
			 "TOM M F A D C A",
			 "SUE F M D D D D",
			 "ELLEN F M A A C A",
			 "JOE M F A A C A",
			 "ED M F A D D A",
			 "SALLY F M C D A B",
			 "MARGE F M A A C C"};
		String[]dest=new MatchMaker().getBestMatches(members,"BETTY",2);
		System.out.println();

	}

}
