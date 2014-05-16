package cn.yanghao.topCoder.SRMS4;
/*
 
Problem Statement
    
You are writing firmware for an exercise machine. Each second, a routine in your firmware is called which decides whether it should display the percentage of the workout completed. The display does not have any ability to show decimal points, so the routine should only display a percentage if the second it is called results in a whole percentage of the total workout.
Given a String time representing how long the workout lasts, in the format "hours:minutes:seconds", return the number of times a percentage will be displayed by the routine. The machine should never display 0% or 100%.
Definition
    
Class:
ExerciseMachine
Method:
getPercentages
Parameters:
String
Returns:
int
Method signature:
int getPercentages(String time)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
time will be a String formatted as "HH:MM:SS", HH = hours, MM = minutes, SS = seconds.
-
The hours portion of time will be an integer with exactly two digits, with a value between 00 and 23, inclusive.
-
The minutes portion of time will be an integer with exactly two digits, with a value between 00 and 59, inclusive.
-
The seconds portion of time will be an integer with exactly two digits, with a value between 00 and 59, inclusive
-
time will not be "00:00:00".
Examples
0)

    
"00:30:00"
Returns: 99
The standard 30 minute workout. Each one percent increment can be displayed every 18 seconds.
1)

    
"00:28:00"
Returns: 19
The 28 minute workout. The user completes 5 percent of the workout every 1 minute, 24 seconds.
2)

    
"23:59:59"
Returns: 0
This is the longest workout possible, given the constraints. No percentages are ever displayed on the screen.
3)

    
"00:14:10"
Returns: 49

4)

    
"00:19:16"
Returns: 3

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ExerciseMachine {

	public int getPercentages(String time){
 		String []t=time.split(":");
		int h=Integer.parseInt(t[0]);
		int m=Integer.parseInt(t[1]);
		int s=Integer.parseInt(t[2]);
		int seconds=h*3600+m*60+s;
		int modules[]={100,50,25,20,10,5,4,2,1};
		for(int result:modules){
			if(0==seconds%result)
				return result-1;
		}
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ExerciseMachine().getPercentages("00:19:16"));
	}

}
