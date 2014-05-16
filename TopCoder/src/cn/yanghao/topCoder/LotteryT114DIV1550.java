package cn.yanghao.topCoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LotteryT114DIV1550 {
	static double[]factorial=new double[109];
	static{
		factorial[0]=1;
		for(int i=1;i<factorial.length;i++)
			factorial[i]=i*factorial[i-1];
	}
	double A(int n,int m){
		return factorial[n]/factorial[n-m];
	}
	double C(int n,int m){
		double result=A(n,m);
		return result/factorial[m];
	}
 
	public double getOptions(int choices,int blank,boolean sorted,boolean unique){
		double result=0;
 
		if(unique){
			result=C(choices,blank);
			if(!sorted)
				result*=A(blank,blank);
		}
		else{
			if(!sorted)
				result=Math.pow(choices, blank);
			else{
				result=C(blank+choices-1,blank);
			}
		}
		System.out.println(choices+" "+blank+" "+sorted+" "+unique+":"+result);
		return result;
	}
 
	public String[] sortByOdds(String []rules){
		Map<Double,List<String>> map=new TreeMap();
		String []result=new String[rules.length];
		List<String> orderedRules=new ArrayList<String>();
		for(String rule:rules){
			String name=rule.split(":")[0];
			String[]ruleSplit=rule.split(":")[1].trim().split(" ");
			int choices=Integer.parseInt(ruleSplit[0]);
			int blank=Integer.parseInt(ruleSplit[1]);
			boolean sorted=ruleSplit[2].equals("T");
			boolean unique=ruleSplit[3].equals("T");
			double key=getOptions(choices,blank,sorted,unique);
			//≤Â»Î
 
			List<String>allRules=map.get(key);
			if(null==allRules){
				allRules=new ArrayList();
			}
			allRules.add(name);
			Collections.sort(allRules);
			map.put(key, allRules);
			 
		}
		int i=0;
		for(List<String> value:map.values()){
			orderedRules.addAll(value);
		}
		return   orderedRules.toArray(result);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String []in={"INDIGO: 93 8 T F",
				 "ORANGE: 29 8 F T",
				 "VIOLET: 76 6 F F",
				 "BLUE: 100 8 T T",
				 "RED: 99 8 T T",
				 "GREEN: 78 6 F T",
				 "YELLOW: 75 6 F F"};
		String []result=new LotteryT114DIV1550().sortByOdds(in);
		for(int i=0;i<in.length;i++)
			System.out.println(result[i]);
		
	}

}
