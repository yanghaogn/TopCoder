package cn.yanghao.topCoder.SRMS27;
/*
 * 
Problem Statement
    
A table is a common structure used in HTML when doing the layout of a home page. A table without any merged cells simply contains rows*columns basic cells (see figure 1 below). It's often desirable to merge several basic cells, either horizontally, vertically, or both, in which case the table may look like the one in figure 2. A merged cell will always be of rectangular shape, so the table in figure 3 is not a valid table.
 
Each cell in the table is described with a 3-tuple in the format (colspan,rowspan,content) where colspan and rowspan are integers between 1 and 9, inclusive, representing the width and height of the cell (in basic cell units) and content is an upper case letter ('A'-'Z').
The table will be described as a String[] where each element corresponds to a row of basic cells in the table, and the cells in each row are described from left to right. The merged cells are defined in the input by their upper left corner, the other parts of a merged cell are not explicitly defined in the input. Thus, element i will represent all cells whose upper left corner are in the ith row. Consider figure 4 below: the shaded "cells" are part of a merged cell and will not be mentioned in the description.
 
Thus this table will be described like this:
{"(1,1,A)(2,1,B)(1,1,C)(1,1,D)",
 "(1,1,E)(1,1,F)(1,1,G)(1,1,H)(1,1,I)",
 "(1,3,J)(1,1,K)(3,2,L)",
 "(1,1,M)",
 "(1,1,N)(1,1,O)(1,1,P)(1,1,Q)",
 "(1,1,R)(1,1,S)(1,1,T)(1,1,U)(1,1,V)"}
The desired output is the same table but in matrix form. That is, each basic cell should occupy one character in a String[]. You may assume that the input table is valid, that all rows will contain the same number of basic cells, that no cell will be missing or overlapped.
Create a class Table containing the method layout which takes a String[] tbl which describes a table in the format above and returns a String[] containing the table in the matrix form described above.
Definition
    
Class:
Table
Method:
layout
Parameters:
String[]
Returns:
String[]
Method signature:
String[] layout(String[] tbl)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
It's possible that a row might be empty, see example 1.
-
If you are using a plugin and you don't see the pictures, you may want to read the problem statement in the applet.
Constraints
-
tbl will contain between 1 and 50 elements, inclusive.
-
Each element in tbl will contain between 0 and 50 characters, inclusive.
-
Each element in tbl will contain zero or more tuples in the format above, with no extra characters.
-
tbl will describe a valid table with no cells missing or overlapping.
-
The return value will contain between 1 and 50 elements, inclusive, and each element will contain between 1 and 50 characters, inclusive.
Examples
0)

    
{"(1,1,A)(2,1,B)(1,1,C)(1,1,D)",
 "(1,1,E)(1,1,F)(1,1,G)(1,1,H)(1,1,I)",
 "(1,3,J)(1,1,K)(3,2,L)",
 "(1,1,M)",
 "(1,1,N)(1,1,O)(1,1,P)(1,1,Q)",
 "(1,1,R)(1,1,S)(1,1,T)(1,1,U)(1,1,V)"}
Returns: { "ABBCD",  "EFGHI",  "JKLLL",  "JMLLL",  "JNOPQ",  "RSTUV" }
This is the example in the problem text:
ABBCD
EFGHI
JKLLL
JMLLL
JNOPQ
RSTUV
1)

    
{"(1,3,N)(3,2,E)(3,1,M)(1,1,Q)",
 "(1,1,T)(3,1,U)",
 "(1,1,Y)(4,5,A)(1,2,V)(1,2,W)",
 "(1,3,G)(1,3,Z)",
 "(1,2,S)(1,3,D)",
 "",
 "(1,2,P)(1,2,F)(1,3,J)",
 "(1,1,L)(3,3,K)(1,1,R)",
 "(3,2,B)(1,1,D)",
 "(2,1,A)",
 "(2,3,O)(4,1,X)(1,1,I)(1,1,B)",
 "(3,2,H)(3,2,C)",
 ""}
Returns: 
{ "NEEEMMMQ",
  "NEEETUUU",
  "NYAAAAVW",
  "GZAAAAVW",
  "GZAAAASD",
  "GZAAAASD",
  "PFAAAAJD",
  "PFLKKKJR",
  "BBBKKKJD",
  "BBBKKKAA",
  "OOXXXXIB",
  "OOHHHCCC",
  "OOHHHCCC" }
Note the two empty rows!
2)

    
{"(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
 "","","","","","","","",
 "(9,9,G)(9,9,H)(9,9,I)(9,9,J)(9,9,K)(5,9,L)",
 "","","","","","","","",
 "(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
 "","","","","","","","",
 "(9,9,G)(9,9,H)(9,9,I)(9,9,J)(9,9,K)(5,9,L)",
 "","","","","","","","",
 "(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
 "","","","","","","","",
 "(9,5,G)(9,5,H)(9,5,I)(9,5,J)(9,5,K)(5,5,L)",
 "","","",""}
Returns: 
{ "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",
  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL" }

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
import java.util.LinkedList;
import java.util.List;

public class Table {

	int ROW;
	int COL;
	public static class Matrix{
		int col;
		int row;
		char c;
		Matrix(int col,int row,char c){
			this.col=col;
			this.row=row;
			this.c=c;
		}
		//格式如"1,2,c"
		Matrix(String matrix){
			String []s=matrix.split(",");
			col=Integer.parseInt(s[0]);
			row=Integer.parseInt(s[1]);
			c=s[2].charAt(0);
		}
	}
	public List<Matrix> parseROW(String row){
		List result=new LinkedList<Matrix>();
	 
		int LEN=row.length();
		for(int i=1;i<LEN;){
			int indexRightBracket=row.indexOf(')',i);
			result.add(new Matrix(row.substring(i, indexRightBracket)));
			i=indexRightBracket+2;
		}
		return result;
	} 
	public void fill(char[][]tables,int row,List<Matrix>currentRow){
		int col=0;
		for(Matrix matrix:currentRow){
			for(;col<COL;col++)
				if(' '==tables[row][col])
					break;
			for(int i=0;i<matrix.row;i++){
				for(int j=0;j<matrix.col;j++){
					tables[row+i][col+j]=matrix.c;
				}
			}
		}
		
	}
	public String[] layout(String[] tbl){
		ROW=tbl.length;
		//int row=0,col=0;
		List<Matrix> currentRow=parseROW(tbl[0]);
		COL=0;
		for(Matrix m:currentRow){
			COL+=m.col;
		}
		final char tables[][]=new char[ROW][COL];
		for(int row=0;row<ROW;row++)
			for(int col=0;col<COL;col++)
				tables[row][col]=' ';
		fill(tables,0,currentRow);
		for(int row=1;row<ROW;row++){
			currentRow=parseROW(tbl[row]);
			fill(tables,row,currentRow);
			
		}
		
		String []result=new String[ROW];
		for(int i=0;i<ROW;i++)
			result[i]=new String(tables[i]);
		return result;
		
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []tbl={"(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
				 "","","","","","","","",
				 "(9,9,G)(9,9,H)(9,9,I)(9,9,J)(9,9,K)(5,9,L)",
				 "","","","","","","","",
				 "(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
				 "","","","","","","","",
				 "(9,9,G)(9,9,H)(9,9,I)(9,9,J)(9,9,K)(5,9,L)",
				 "","","","","","","","",
				 "(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
				 "","","","","","","","",
				 "(9,5,G)(9,5,H)(9,5,I)(9,5,J)(9,5,K)(5,5,L)",
				 "","","",""};
		String []result=new Table().layout(tbl);
		for(String s:result){
			System.out.println(s);
		}
	}

}
