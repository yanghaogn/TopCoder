package cn.yanghao.topCoder.SRMS17;
/*
 * 
Problem Statement
    
You're running a special TopCoder competition where all programs are written in a derivative of a restrictive language called Unefunge, and all programs must complete in under 80,000 cycles. Furthermore, all programs are required to be Quines. For the purpose of this problem, a Quine is a special type of program that prints out its own source code before it prints anything else. Thus, in order for the Unefunge program ":,:9#@_1+" to be a legal program it would first have to print the string ":,:9#@_1+".
The language Unefunge works like this: a program is just a single line of characters of length N, where N is between 1 and 50 inclusive. The program never changes. An instruction pointer starts with the value 0 (called the IP), a delta is given the value 1 (called D), and an empty stack is created. The stack will store integer values during program execution in a first-in-last-out manner; if a number is pushed, it is placed in the stack, and if a value is popped, the last number pushed is removed (or a 0 is popped if the stack is empty). During each cycle, the IPth character in the program is read, the instruction corresponding to that character is executed, and then IP is incremented to the new value (3*N+IP+D)%N. The instructions are as follows:
'0'-'9': pushes the number represented by that digit onto the stack.
'$' : pops a value off the stack, and discards it.
':' : pops a value off the stack, then pushes that same value onto the stack twice.
'W' : Pops a value A, then pops a value B, then pushes A, then pushes B.
',' : pops a value X off of the stack, and prints the (absolute value of X)%Nth character in the source code.
'+' : pops two values, adds them, and pushes the result back onto the stack.
'-' : pops two values, subtracts the second popped value from the first, and pushes the result back onto the stack.
'#' : multiplies D by 2 for this cycle only.
'R' : multiplies D by -1.
'S' : pops a value, and if positive pushes a 1, else pushes a -1.
'_' : pops a value X, and sets D to that value X%N.
'J' : pops a value X, and sets IP to the (absolute value of X)%N. (IP is not incremented after this step)
'@' : stops the program
You have to write a program that takes a String source and checks whether or not the program being submitted is valid. If the program doesn't end in 80,000 cycles or less, return "TIMEOUT". Otherwise you'll return a message with the ending condition replacing X with the cycle number in which this ending condition is reached.
If the program ends before printing out its source, return the string "BADEND X".
If a number less than -1000000000 or a number greater than 1000000000 is pushed onto the stack, return "OVERFLOW X".
If the result of an instruction makes it impossible for the output to match the source code, return "MISMATCH X".
If the result of an instruction makes the output match the source code, return "QUINES X".
Definition
    
Class:
QuiningTopCoder
Method:
testCode
Parameters:
String
Returns:
String
Method signature:
String testCode(String source)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
Start counting cycles at cycle 0. This should be obvious from the first example.
-
Note that digits are not grouped, but pushed on in order: the code "3004" pushes a 3, then a 0, then another 0, then finally a 4, so the stack would contain the four numbers [3,0,0,4] and not the single number [3004].
Constraints
-
source will contain between 1 and 50 characters inclusive.
-
source will only consist of characters contained in "0123456789:$W,+-#RS_J@" (quotes included for clarity).
Examples
0)

    
","
Returns: "QUINES 0"
The shortest quine.
1)

    
"_"
Returns: "TIMEOUT"
This pops a 0 from the stack and places it into delta, freezing the code where it stands.
2)

    
"1:+:1J"
Returns: "OVERFLOW 147"
This Unefunge code creates a stack of the powers of 2, until it overflows 1000000000.
3)

    
"0,1+:#@:$1J"
Returns: "QUINES 91"
Note the irrelevant commands in the center of this quine. If code starts with "0,1+:", ends with "1J", and the middle preserves the first two elements on the stack, then the code is a quine.
4)

    
"0,1+::9W-9W-S1W1W:+2_J_@_@"
Returns: "BADEND 437"
This code prints the first 18 characters of its code before halting.
5)

    
"#R,#:+1+:#,R#"
Returns: "QUINES 97"
This non-trivial code is both a quine and a palindrome. :)
6)

    
"R,#1+1:"
Returns: "MISMATCH 7"

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
import java.util.Stack;

class Data{
	public static class myStack extends Stack<Integer>{
 	 
		@Override
		public synchronized Integer pop() {
			// TODO Auto-generated method stub
			if(empty())
				return 0;
			return super.pop();
		}

		@Override
		public synchronized Integer peek() {
			// TODO Auto-generated method stub
			if(this.empty())
				return 0;
			return super.peek();
		}
		
		
		
	}
	String source;
	String print;
	myStack stack;
	int IP;
	int D;
	int N;
	public Data(String s){
		source=s;
		print="";
		stack=new myStack();
		IP=0;
		D=1;
		N=s.length();
		
	}
	
}
enum OPERATOR{
	//0123456789:$W,+-#RS_J@
	DIGITAL0('0'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL1('1'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL2('2'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL3('3'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL4('4'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL5('5'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL6('6'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL7('7'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL8('8'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		} 
	},
	DIGITAL9('9'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.push(self-'0');
			data.IP=(3*data.N+data.IP+data.D)%data.N; 
			
		} 
	},
	$('$'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.stack.pop();
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

	 
		
	},
	
	COLON(':'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int top=data.stack.pop();
			data.stack.push(top);
			data.stack.push(top);
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

		 
		
	},
	W('W'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int A=data.stack.pop();
			int B=data.stack.pop();
			data.stack.push(A);
			data.stack.push(B);
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

		 
		
	},
	COMMA(','){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int top=data.stack.pop();
			top=Math.abs(top)%data.N;
			data.print+=data.source.charAt(top);
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

	 
		
	},
	ADD('+'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int A=data.stack.pop();
			int B=data.stack.pop();
			data.stack.push(A+B);
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

	 
		
	},
	MINUS('-'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int A=data.stack.pop();
			int B=data.stack.pop();
			data.stack.push(A-B);
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

 
	},
	JIAN('#'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.IP=(3*data.N+data.IP+2*data.D)%data.N;
			
		}

		 
		
	},
	R('R'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			data.D*=-1;
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

		 
		
	},
	S('S'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int top=data.stack.pop();
	 
			if(top>0)
				data.stack.push(1);
			else
				data.stack.push(-1);
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			
		}

	 
		
	},
	UNDERLINE('_'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int top=data.stack.pop();
			data.D=top%data.N;
			data.IP=(3*data.N+data.IP+data.D)%data.N;
			 
		}

	 
		
	},
	J('J'){

		@Override
		void operate(Data data) {
			// TODO Auto-generated method stub
			int top=data.stack.pop();
			data.IP=Math.abs(top)%data.N;
			 
		}

	 
		
	};
	
	char self;
	OPERATOR(char c){
		self=c;
	}
	static OPERATOR get(char c){
		for(OPERATOR o:values()){
			if(c==o.self)
				return o;
		}
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+self;
	}
	abstract void operate(Data data);
}
public class QuiningTopCoder {
	public String testCode(String source){
 		Data data=new Data(source);
		int time;
		for(time=0;time<80000;time++){
		 
			char c=source.charAt(data.IP);
			 
			if('@'==c){
				return "BADEND "+time;
			}
			OPERATOR o=OPERATOR.get(c);
			o.operate(data);
			int top=data.stack.peek();
			if(top<-1000000000||top>1000000000)
				return "OVERFLOW "+time;
			if(!source.startsWith(data.print))
				return "MISMATCH "+time;
			if(source.equals(data.print))
				return "QUINES "+time;
		 
			 
			
		}
		return "TIMEOUT";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0,1+::9W-9W-S1W1W:+2_J_@_@
		String s="0,1+::9W-9W-S1W1W:+2_J_@_@";
		QuiningTopCoder q=new QuiningTopCoder();
		 
		System.out.println(q.testCode(s));
	}

}
