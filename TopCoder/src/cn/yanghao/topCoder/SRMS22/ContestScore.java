package cn.yanghao.topCoder.SRMS22;
/*
 * 
Problem Statement
    
Some competitions have judges who score one specific area of a performance. Unfortunately, bad judges do exist and can individually cause one group's rating to be affected drastically. In some sports, the highest and lowest scores are dropped. This works well when all judges are scoring the same thing. However, when each judge scores only one aspect of a performance, dropping a score is not an option.  One way to minimize the effects of a bad judge is to not use the score each judge gives, but to use the relative ranking the judge gives each group. The group that places first has a ranking of 1. The group that places second has a ranking of 2, third has a ranking of 3, and so forth. When multiple groups are given the same score from one judge, then they will all receive the same ranking. For example, if the groups A, B, C, D, and E receive the scores 98, 95, 95, 90, and 83 respectively, then they would receive rankings of 1, 2, 2, 4, and 5, respectively.  Each group's rankings from all of the judges are then added together to find the group's total ranking. The group with the lowest total ranking places first. The group with the second lowest total ranking places second and so forth. Ties are broken using the sum of all scores the group receives from the judges to find the group's total score. The group with the highest total score wins the tiebreaker. If multiple groups have the same total ranking and the same total score, then the group whose name comes first alphabetically wins.  Create a class ContestScore with a method sortResults that is given a String[] data and will return a String[] containing the group names and scores sorted from first to last place. Every String in data will be formatted as: ("<GROUPNAME> NN.N NN.N NN.N") (quotes for clarity) where <GROUPNAME> will be between 1 and 10 characters in length, inclusive, and NN.N is a decimal number. It will have leading zeros if necessary to follow the above format. Each String in the returned String[] will be formatted as "<GROUPNAME> <TOTALRANK> <TOTALSCORE>" (quotes for clarity) where <TOTALRANK> is the group's total ranking and is an integer. <TOTALSCORE> is the sum of the scores received from all judges and will always have exactly one decimal place and no extra leading 0's. For example, if a group's <TOTALRANK> is 7 and <TOTALSCORE> is 271, then the string would be "<GROUPNAME> 7 271.0" (quotes for clarity).  For example, we have three groups. Group A scored a 90.7, a 92.9, and an 87.4. Group B scored a 90.5, a 96.6, and an 88.0. Group C scored a 92.2, a 91.0, and a 95.3. Here is how you would receive the data (quotes for clarity).
  {"A 90.7 92.9 87.4",
   "B 90.5 96.6 88.0",
   "C 92.2 91.0 95.3"}
From judge 1, group C got 1st, group A got 2nd, and group B got 3rd. From judge 2, group B got 1st, group A got 2nd, and group C got 3rd. From judge 3, group C got 1st, group B got 2nd, and group A got 3rd.
   A  2 2 3
   B  3 1 2
   C  1 3 1
So A has a total ranking of 7, B has a total ranking of 6, and C has a total ranking of 5. Since C has the lowest total ranking, they place first. B places second, and A places third. You would return:
  {"C 5 278.5",
   "B 6 275.1",
   "A 7 271.0"}
Definition
    
Class:
ContestScore
Method:
sortResults
Parameters:
String[]
Returns:
String[]
Method signature:
String[] sortResults(String[] data)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
It is possible for a group to receive 00.0 for a score. Remember that leading and trailing zeros will be present if necessary in order to maintain formatting.
-
Remember that if a group's total score is an exact integer to display it with one decimal place. Also, if the total score is between 0.0 and 0.9, inclusive, display one zero to the left of the decimal point. The last example shows this.
Constraints
-
data will contain between 0 and 50 elements, inclusive.
-
Each element of data will contain the exact same number of scores.
-
Each element of data will contain between 6 and 50 characters, inclusive.
-
There will be at least one judge.
-
Each element of data will be formatted as a group name followed by a single space, followed by a single space delimited list of scores.
-
Group names will be between 1 and 10 characters in length, and will consist of only of uppercase letters ('A'-'Z').
-
No two groups will have the same name.
-
The score from each judge will be formatted as NN.N where N is a digit ('0'-'9').
-
There will be no leading or trailing spaces in each String of data.
Examples
0)

    
{"A 90.7 92.9 87.4",
 "B 90.5 96.6 88.0",
 "C 92.2 91.0 95.3"}
Returns: { "C 5 278.5",  "B 6 275.1",  "A 7 271.0" }
Example from above.
1)

    
{"STANFORD 85.3 90.1 82.6 84.6 96.6 94.5 87.3 90.3",
 "MIT 95.5 83.9 80.4 85.5 98.7 98.3 96.7 82.7",
 "PRINCETON 99.2 79.1 87.6 85.1 93.6 96.4 86.0 90.6",
 "HARVARD 83.6 92.0 85.5 94.3 97.5 91.5 92.5 83.0",
 "YALE 99.5 92.6 86.2 82.0 96.4 92.6 84.5 78.6",
 "COLUMBIA 97.2 87.6 81.7 93.7 88.0 86.3 95.9 89.6",
 "BROWN 92.2 95.8 92.1 81.5 89.5 87.0 95.5 86.4",
 "PENN 96.3 80.7 81.2 91.6 85.8 92.2 83.9 87.8",
 "CORNELL 88.0 83.7 85.0 83.8 99.8 92.1 91.0 88.9"}
Returns: 
{ "PRINCETON 34 717.6",
  "MIT 36 721.7",
  "HARVARD 38 719.9",
  "COLUMBIA 39 720.0",
  "STANFORD 39 711.3",
  "YALE 40 712.4",
  "BROWN 41 720.0",
  "CORNELL 42 712.3",
  "PENN 51 699.5" }

2)

    
{}
Returns: { }

3)

    
{"AA 90.0 80.0 70.0 60.0 50.0 40.0",
 "BBB 80.0 70.0 60.0 50.0 40.0 90.0",
 "EEE 70.0 60.0 50.0 40.0 90.0 80.0",
 "AAA 60.0 50.0 40.0 90.0 80.0 70.0",
 "DDD 50.0 40.0 90.0 80.0 70.0 60.0",
 "CCC 40.0 90.0 80.0 70.0 60.0 50.0"}
Returns: 
{ "AA 21 390.0",
  "AAA 21 390.0",
  "BBB 21 390.0",
  "CCC 21 390.0",
  "DDD 21 390.0",
  "EEE 21 390.0" }

4)

    
{"A 00.1", "B 05.2", "C 29.0","D 00.0"}
Returns: { "C 1 29.0",  "B 2 5.2",  "A 3 0.1",  "D 4 0.0" }
Remember that, for numbers between 0.0 and 0.9, inclusive, you must display a 0 before the decimal point. Do not display any extraneous leading zeros if a number is between 1.0 and 9.9, inclusive.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
 
class Group implements Comparable<Group>{
	String name;
	int rank;
	double score;
	static DecimalFormat df = new DecimalFormat("0.0");
	Group(String name,int rank,double score){
		this.name=name;
		this.rank=rank;
		this.score=score;
	}

	@Override
	public int compareTo(Group o) {
		// TODO Auto-generated method stub
		if(null!=o){
			if(rank!=o.rank)
				return rank<o.rank?-1:1;
			if(Math.abs(score*100-o.score*100)>1e-9)
				return score>o.score?-1:1;
			return name.compareTo(o.name);
			
		}
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Group){
		Group other=(Group)obj;
		return name==other.name&&score==other.score&&rank==other.rank;
		}
		return super.equals(obj);
	}

	@Override
	public String toString(){
		String result=name+" "+rank+" "+df.format(score);
		return result;
	}
}
public class ContestScore {

	/*
	 * 输入数据
	 * {"A 90.7 92.9 87.4",
 "B 90.5 96.6 88.0",
 "C 92.2 91.0 95.3"}
	 */
	public String[] sortResults(String[] data){
		if(null==data||0==data.length)
			return new String[0];
		final int numGroup=data.length;
		String []result=new String[numGroup];
		String []record=data[0].split(" ");
		final int numJudge=record.length-1;
		String []names=new String[numGroup];
		double [][]scores=new double[numGroup][numJudge];
		int [][]ranks=new int[numGroup][numJudge];
		TreeSet<Group> set=new TreeSet<Group>();
		for(int i=0;i<numGroup;i++){
			record=data[i].split(" ");
			names[i]=record[0];
			for(int j=0;j<numJudge;j++)
				scores[i][j]=Double.parseDouble(record[j+1]);
		}
		Map<Double,Integer> setScore=new TreeMap();
		for(int j=0;j<numJudge;j++){
			setScore.clear();
			for(int i=0;i<numGroup;i++){
				double key=-scores[i][j];
				if(setScore.containsKey(key))
					setScore.put(key, setScore.get(key)+1);
				else setScore.put(key,1);
			}
			for(int i=0;i<numGroup;i++){
				int rank=1;
				for(double p:setScore.keySet()){
					if(0==p+scores[i][j]){
						
						break;
					}
					rank+=setScore.get(p);	
				}	
				ranks[i][j]=rank;
			}
			 
		}
		for(int i=0;i<numGroup;i++){
			String name=names[i];
			int rank=0;
			double score=0;
			for(int j=0;j<numJudge;j++)
			{
				rank+=ranks[i][j];
				score+=scores[i][j];
			}
			set.add(new Group(name,rank,score));
		}
		int i=0;
		for(Group g:set){
			result[i++]=g.toString();
		}
		return result;
				
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []data={"AAA 85.7 98.1 86.4 46.9 01.8 88.2 04.6 54.5", "AAAAAA 37.3 15.5 96.1 67.1 75.8 42.4 32.7 20.7", "AAAAAAA 71.4 18.4 09.8 39.3 54.2 57.5 73.4 63.6", "AAAAA 31.7 30.0 39.0 68.5 42.1 88.2 54.6 41.0", "AA 76.5 98.1 15.3 88.7 01.8 54.7 94.1 54.5", "AAAAAAAA 35.3 33.1 86.4 18.5 65.8 47.3 00.7 84.4", "AAAAAAAAAA 65.4 19.4 22.2 46.9 39.6 37.4 63.5 54.2", "AAAA 71.2 80.0 50.2 72.5 70.8 31.1 02.3 17.0", "A 72.5 38.9 12.0 98.5 85.1 94.6 95.0 98.2", "AAAAAAAAA 31.1 45.8 24.4 68.4 23.1 12.0 04.6 94.9"
			};
String []result=new ContestScore().sortResults(data);
		for(String s:result)
			System.out.println(s);
	}

}
