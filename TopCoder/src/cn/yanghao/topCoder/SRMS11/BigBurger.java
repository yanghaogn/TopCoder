package cn.yanghao.topCoder.SRMS11;

public class BigBurger {
	public int maxWait(int[] arrival, int[] service){
		int max=0;
		int N=arrival.length;
		if(N<=1)
			return 0;
		int []wait=new int[N];
		int []complete=new int[N];
		wait[0]=0;
		complete[0]=arrival[0]+service[0];
		for(int i=1;i<N;i++){
			wait[i]=Math.max(0, complete[i-1]-arrival[i]);
			complete[i]=arrival[i]+wait[i]+service[i];
			max=Math.max(wait[i], max);
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrival={2,10,12};
		int[] service={15,1,15};
		System.out.println(new BigBurger().maxWait(arrival, service));

	}

}
