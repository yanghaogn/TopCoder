package cn.yanghao.topCoder.Tournaments2Inv2001SemiAplusB;

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
