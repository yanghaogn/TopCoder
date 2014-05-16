package cn.yanghao.topCoder;

import java.util.Scanner;

public class CompositeSmash {
	boolean isPrime(int N){
		boolean isPrime=true;
		if(N<=1)
			return false;
		for(int i=2;i*i<=N;i++)
			if(0==N%i)
				return false;
		return isPrime;
	}
	public String thePossible(int N,int target){
		//target大于N
		if(0<N%target) return "No";
		//本身
		if(0==target-N)
			return "Yes";
		//质数
		//
		boolean ret=true;
		int i;
		for(i=1;i*i<=N;i++)
		{
			if(0==N%i)
			{
				System.out.println(N+":"+i+","+N/i);
			}
		}
		return ret?"Yes":"No";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompositeSmash com=new CompositeSmash();
		Scanner in=new Scanner(System.in);
		int N,target;
		while(in.hasNext()){
			N=in.nextInt();
			target=in.nextInt();
			System.out.println(com.thePossible(N,target));
		}
	}

}
