public class PowerOutage {
	int[] fromJunction;
	int[] toJunction;
	int[] ductLength;
	int extraLength(int start){
		final int len=fromJunction.length;
		int res=0;
		for(int i=0;i<len;i++){
			if(start==fromJunction[i]){
				res=Math.max(res, extraLength(toJunction[i])+ductLength[i]);
			}
		}
		return res;
	}
	public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength){
		int total=0;
		final int len=fromJunction.length;
		this.fromJunction=fromJunction;
		this.toJunction=toJunction;
		this.ductLength=ductLength;
		for(int i=0;i<len;i++)
			total+=ductLength[i]*2;
		total-=extraLength(0);
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fromJunction={0,0,0,0,0};
		int[] toJunction={1,2,3,4,5};
		int[] ductLength={100,200,300,400,500};
		System.out.println(new PowerOutage().estimateTimeOut(fromJunction,toJunction,ductLength));

	}

}
