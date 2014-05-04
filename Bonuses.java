package cn.yanghao.topCoder.SRMS3;

 
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Point implements Comparable<Point>{
	public int index;
	public int value;
	public int bonus;

	Point(int index,int value){
		this.index=index;
		this.value=value;
		bonus=0;
	}
	@Override
	public int compareTo(Point other) {
		// TODO Auto-generated method stub
		if(value<other.value) return 1;
		if(value>other.value) return -1;
		if(index<other.index)	return -1;
		if(index>other.index)	return 1;
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Point){
			Point other=(Point)obj;
			return (index==other.index)&&(value==other.value);
			//return value==other.value;
		}
		return false;
	}
	 Integer i;
	
}
public class Bonuses {
	Set <Point>set=new TreeSet<Point>();

	public int[] getDivision(int[] points){
		int i;
		int sum=0,bonusSum=0;
		int N=points.length;
		int []result=new int[N];
		for(i=0;i<N;i++){
			Point p=new Point(i,points[i]);
			set.add(p); 
			sum+=points[i];
			result[i]=0;
		}
		for(Point p:set){
			p.bonus=(int) ((100.0*p.value)/sum);
			bonusSum+=p.bonus;
		}
		Point []allPoints=set.toArray(new Point[N]);
		for(i=0;i+bonusSum<100;i++)
		{
			allPoints[i].bonus+=1;
		}
		for(i=0;i<N;i++){
			result[allPoints[i].index]=allPoints[i].bonus;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

 
		Bonuses bonus=new Bonuses();
		int[]points={485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,
				 255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470};
		int []result=bonus.getDivision(points);
		for(int i=0;i<result.length;i++)
			System.out.println(result[i]);
	}

}
