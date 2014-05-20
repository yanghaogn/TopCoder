package cn.yanghao.topCoder.SRMS19;
/*
 * 
Problem Statement
    
With today's high gas prices, drivers often go to great lengths to find the cheapest gas. In this problem, you are to write a method for a system that helps a person plan where to stop for gas on a long trip. You can assume that the person has already planned the route, and that it is fixed. With the route information, the system (which might be built into a car, for example) can retrieve price information about the gas at all of the gas stations along the way. With this information, your method must plan which gas stations to stop at, and how much gas to get at each station to minimize the cost of the trip.  More specifically, you will be given a int[] dist, a int[] prices, an int mpg, an int tankSize, and an int tripLength and are to return the lowest possible cost of the trip. Each element of dist, and the corresponding element of prices, represents the distance to the gas station from the start of the trip (in miles) and the price of the gas at that station (in thousandths of a dollar per gallon). mpg stands for miles per gallon, and represents the number of miles the car may travel on a single gallon of gas. Note that gallons need not be used in whole amounts. tankSize represents the maximum number of gallons that the tank of gas may hold. The trip starts at mile 0 and ends at mile tripLength, and you start the trip with a full tank of gas. You may purchase any quantity of gas (including fractional amounts of gallons) at any gas station.
Definition
    
Class:
GasStations
Method:
tripCost
Parameters:
int[], int[], int, int, int
Returns:
double
Method signature:
double tripCost(int[] dist, int[] price, int mpg, int tankSize, int tripLength)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
Your solution need not be exactly correct to be evaluated as correct. As long as the relative error between your result and the true result is less than 1e-9, your result will be evaluated as correct.
Constraints
-
distances and prices will contain the same number of elements.
-
distances and prices will contain between 1 and 50 elements, inclusive.
-
mpg will be between 1 and 1000, inclusive.
-
tankSize will be between 1 and 1000, inclusive.
-
tripLength will be between 2 and 10,000, inclusive.
-
Each element of distances will be between 1 and tripLength-1, inclusive.
-
Each element of prices will be between 50 and 20,000, inclusive.
-
The trip will be possible.
Examples
0)

    
{100,100}
{1000,1500}
20
10
300
Returns: 5000.0
The 10 gallon tank allows the car to go 200 miles on a full tank. So, in order to get from the station at 100 miles to the end of the trip at 300 miles, the tank has to be filled up at one of the gas stations after 100 miles. Clearly, we should fill it up at the cheaper one, and since we have gone 100 miles so far, we need to buy 5 gallons of gas, for 5,000 thousandths of a dollar.
1)

    
{300,450,525}
{1659,1529,1439}
20
20
600
Returns: 15277.5

2)

    
{300,450,525}
{1659,1439,1529}
20
20
600
Returns: 14940.0

3)

    
{300,125,450,525}
{1659,1729,1439,1529}
20
20
600
Returns: 14940.0

4)

    
{200}
{1000}
20
20
400
Returns: 0.0

5)

    
{100,400}
{1549,1649}
25
16
600
Returns: 12792.0

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class GasStations {
	int[] getOrderIndex(double[] price, int N) {
		int[] index = new int[N];
		for (int i = 0; i < N; i++)
			index[i] = i;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++) {
				if (price[index[j]] < price[index[i]]) {
					index[i] = index[i] + index[j];
					index[j] = index[i] - index[j];
					index[i] = index[i] - index[j];
				}
			}
		return index;
	}

	public boolean isOver(double[] DIS, double[] remaingGas, int N) {
		for (int i = 0; i < N; i++)
			if (DIS[i+1]-DIS[i] > remaingGas[i])
				return false;
		return true;
	}

	public double tripCost(int[] dist, int[] p, int mpg, int tankSize, int tripLength) {
		final int N = dist.length;
		int i;
		double result = 0;
		tankSize *= mpg;
		final double CAPACITY = tankSize;
		double[] remainingGas = new double[N + 1];
		//double[] remainingDistance = new double[N + 1];
		double[] price = new double[N + 1];
		double[] DIS = new double[N + 1];
		double[] lackGas=new double[N+1];
		for(i=0;i<N;i++)
			for(int j=i+1;j<N;j++){
				if(dist[j]<dist[i]){
					dist[i]=dist[i]+dist[j];
					dist[j]=dist[i]-dist[j];
					dist[i]=dist[i]-dist[j];
					
					p[i]=p[i]+p[j];
					p[j]=p[i]-p[j];
					p[i]=p[i]-p[j];
				}
			}
		for (i = 0; i < N; i++) {
			remainingGas[i]=Math.max(0, tankSize-dist[i]);

			price[i] = p[i] * 1.0 / mpg;
			DIS[i] = dist[i];
			lackGas[i]=tripLength-DIS[i]-remainingGas[i];
		}
		remainingGas[N] = Math.max( CAPACITY-tripLength, 0);
 		price[N] = Double.MAX_VALUE;
		DIS[N] = tripLength;
		lackGas[N]=0;
 
		int[] indexs = getOrderIndex(price, N );
		for (int index : indexs) {
			 
			for(i=0;i<=N;i++)
 
			if (isOver(DIS, remainingGas, N))
				break;
			double add = 0;
			int j = index + 1;
			for (; j < N; j++)
			{
				if (0==lackGas[j] ||CAPACITY==remainingGas[j])
					break;
			}
			double dis = DIS[j] - DIS[index];
			for(i=j-1;i>=index;i--){
				double tmp= Math.max(0, DIS[i+1]-DIS[i]-remainingGas[i]);
				//tmp=Math.min(tmp, CAPACITY-remainingGas[i]);
				add+=tmp;
				add=Math.min(add,CAPACITY-remainingGas[i]);
			}
			
			if(add<=0) continue;
			 
			result += add * price[index];
			for(i=0;i<index;i++)
				lackGas[i]-=add;
			for (j = index; j < N; j++) {
				dis =Math.max(0,  DIS[j + 1] - DIS[j] - remainingGas[j]);
				remainingGas[j] += add;
				lackGas[j]-=add;
				add -= dis;
				if (add <= 0)
					break;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 

 
		int[] dist={300,450,525}; 
		int[] p={1659,1529,1439};
		int mpg=20;
		int tankSize=20;
		int tripLength=600;
		 
		System.out.println(new GasStations().tripCost(dist, p, mpg, tankSize, tripLength));
	}

}
