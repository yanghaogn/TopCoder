package cn.yanghao.topCoder.SRMS2;

import java.util.Scanner;

public class Time {
	public String whatTime(int seconds){
		String result="";
		int h=seconds/3600;
		seconds%=3600;
		int m=seconds/60;
 		int s=seconds%60;
		result=h+":"+m+":"+s;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Time time=new Time();
		while(in.hasNext()){
			System.out.println(time.whatTime(in.nextInt()));
		}

	}

}
