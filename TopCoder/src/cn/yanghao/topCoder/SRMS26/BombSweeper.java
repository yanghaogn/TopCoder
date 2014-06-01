package cn.yanghao.topCoder.SRMS26;
/*
 * 
Problem Statement
    
The game of BombSweeper is a single-player game played on a rectangular grid. Each square in the grid is either a bomb (represented by 'B') or empty space (represented by '.'). The true identity of each square is hidden when the game begins. The object of the game is to correctly determine both the number of bombs on the board and their positions.
You are trying to write a program which predicts the percent likelihood that you will win a given game of BombSweeper. You've recently become so good at the game that your success or failure depends only on your first few moves. To start, you pick a random square on the gameboard and uncover it. If the square you uncover is a bomb, you lose the game. If the square is not a bomb, but one or more of its horizontal, vertical, and diagonal neighbors is, you are no better off than when you started and you must take another turn. If the square is not a bomb, and none of its (up to) eight neighbors are bombs either, then you win the game.
Given a String[] board, representing the game board, return a number between 0.0 and 100.0, inclusive, representing the percent likelihood of you winning the game.
Definition
    
Class:
BombSweeper
Method:
winPercentage
Parameters:
String[]
Returns:
double
Method signature:
double winPercentage(String[] board)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
In calculating the probability, let wins be the number of non-bomb squares which have no bomb neighbors, and let losses be the number of bombs on the board. The odds of winning are then (wins / (wins + losses)), which returns a number between 0.0 and 1.0, inclusive.
-
As long as you calculate wins and losses correctly, you need not worry about minor double imprecisions.
-
Your solution need only be accurate to 1e-9 (relative or absolute). Thus, if your result is within 1e-9 (relative or absolute) of the result shown, your result will be judged correct.
Constraints
-
board will contain between 1 and 50 elements, inclusive.
-
Each element of board will contain between 1 and 50 characters, inclusive.
-
Each element of board will contain the same number of characters.
-
Each character in board will be either '.' or 'B'.
Examples
0)

    
{".....",
 ".....",
 "..B..",
 ".....",
 "....."}
Returns: 94.11764705882354
If you uncover the bomb in the center of the gameboard, you lose. If you uncover one of the eight squares surrounding the bomb, you would need to take another turn. If you uncover one of the 16 squares on the perimeter of the gameboard, you would win, since none of these squares has a neighboring square which is a bomb. Since there are 16 ways to win and only 1 way to die, your odds of winning are 16/17, or about 94.1%.
1)

    
{"BBBBB",
 "B...B",
 "B...B",
 "B...B",
 "BBBBB"}
Returns: 5.882352941176471
As far as your odds of winning are concerned, this board is the opposite of the previous one. The only way to win is to uncover the square in the exact center of the gameboard, while any of the 16 bombs on the perimeter will cause you to lose. 1/17 is about 0.0588, or about 5.88%.
2)

    
{".........",
 ".B..B..B.",
 ".........",
 ".........",
 ".B..B..B.",
 ".........",
 ".........",
 ".B..B..B.",
 "........."}
Returns: 0.0
Every square on this board is either a bomb, or has a bomb as a neighbor. Therefore, there is no way to win.
3)

    
{".........................",
 ".........................",
 ".........................",
 "........................."}
Returns: 100.0
Now there are no bombs, so any square you uncover will cause you to win.
4)

    
{"......B.......B..B...........................B....",
 "..............B..................BB..B............",
 "B.B.B.............B.....B..............B..........",
 "...................B...B....................BB....",
 "...B.....B.........................B.......B.....B",
 "B.B.........B.....B.......B..B......B.B...B.BB....",
 "..B...................BB...............B..........",
 ".........B...B................B..B................",
 ".......BB.......B....B................B.....BBB...",
 ".......BB..........B..............B......BB.......",
 "...................BB.....................B.......",
 "...B.B.B......B..............B...B......B.........",
 "B................B................................",
 "....B..........B.....B..BB....B...............BB..",
 "..B....B.....B.............B.....B............B...",
 "...................B.B........B..B.........B.B....",
 ".....B.....B......................................",
 "...........BB......BB...B.B........B...B..........",
 ".....BBB..........................................",
 ".B...........B....B...BB......B......B...B.B......",
 "..................B........BB................B....",
 "...............................B..B....BBB.B....B.",
 "..........B.......................................",
 ".....B..........B....BB......B.B......B......B....",
 ".....B..................B........B................",
 "............B.....B..B....BB...B....BB........B...",
 "..B.................B.........B...................",
 ".BB..............B................................",
 "...B....B..................B.................B....",
 "......B...B......B......................B.B.......",
 "..............B..................B.......B........",
 ".....B........BB...B.....B........................",
 ".......B......B.B..B..........B...........B....B..",
 "B...B...........B...B...B......B.B...B..B......B..",
 "....B..B.....B.B.......BB..B............B.B....B..",
 "B.......B..........B.........B...B.BB......B......",
 "....B...............................B.............",
 ".....B.B..........................................",
 "..........B............B......B.B..B....B.........",
 "....B...B.......................B.................",
 "B.................B...........B..B....B...........",
 "...B.....B........................................",
 "...B..B......................................BBB..",
 ".B...B....................................B....B..",
 "...B...B..........B...B.B.........................",
 ".....B.............B...BB..........B..BBB.BB......",
 "....................B.....B.......................",
 "........B..BB..........B.B....B...........B......B",
 ".........B.....BB..B.............B....BB..........",
 "....B..B..............B...B..B..........B........."}
Returns: 77.67558528428094
This board has 267 bombs, 1304 empty spaces with bomb neighbors, and 929 empty spaces without bomb neighbors. (929 / (929 + 267)) is about 0.7768.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class BombSweeper {
	public double winPercentage(String[] board){
		int wins=0;
		int losses=0;
		final int ROW=board.length;
		final int COL=board[0].length();
		for(int i=0;i<ROW;i++)
			for(int j=0;j<COL;j++){
				if('B'==board[i].charAt(j))
					losses++;
				else{
					if(willWin(board,i,j,ROW,COL))
						wins++;
				}
			}
		return wins*100.0/(wins+losses);
	}
	boolean willWin(String[]board,int i,int j,int ROW,int COL){
		
		if('B'==board[i].charAt(j))
			return false;
		if(j>=1){
			if('B'==board[i].charAt(j-1))
				return false;
		}
		if(j+1<COL){
			if('B'==board[i].charAt(j+1))
				return false;
		}
		if(i>=1){
			if('B'==board[i-1].charAt(j))
				return false;
			if(j>=1){
				if('B'==board[i-1].charAt(j-1))
					return false;
			}
			if(j+1<COL){
				if('B'==board[i-1].charAt(j+1))
					return false;
			}
		}
		if(i+1<ROW){
			if('B'==board[i+1].charAt(j))
				return false;
			if(j>=1){
				if('B'==board[i+1].charAt(j-1))
					return false;
			}
			if(j+1<COL){
				if('B'==board[i+1].charAt(j+1))
					return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]board={"......B.......B..B...........................B....",
				 "..............B..................BB..B............",
				 "B.B.B.............B.....B..............B..........",
				 "...................B...B....................BB....",
				 "...B.....B.........................B.......B.....B",
				 "B.B.........B.....B.......B..B......B.B...B.BB....",
				 "..B...................BB...............B..........",
				 ".........B...B................B..B................",
				 ".......BB.......B....B................B.....BBB...",
				 ".......BB..........B..............B......BB.......",
				 "...................BB.....................B.......",
				 "...B.B.B......B..............B...B......B.........",
				 "B................B................................",
				 "....B..........B.....B..BB....B...............BB..",
				 "..B....B.....B.............B.....B............B...",
				 "...................B.B........B..B.........B.B....",
				 ".....B.....B......................................",
				 "...........BB......BB...B.B........B...B..........",
				 ".....BBB..........................................",
				 ".B...........B....B...BB......B......B...B.B......",
				 "..................B........BB................B....",
				 "...............................B..B....BBB.B....B.",
				 "..........B.......................................",
				 ".....B..........B....BB......B.B......B......B....",
				 ".....B..................B........B................",
				 "............B.....B..B....BB...B....BB........B...",
				 "..B.................B.........B...................",
				 ".BB..............B................................",
				 "...B....B..................B.................B....",
				 "......B...B......B......................B.B.......",
				 "..............B..................B.......B........",
				 ".....B........BB...B.....B........................",
				 ".......B......B.B..B..........B...........B....B..",
				 "B...B...........B...B...B......B.B...B..B......B..",
				 "....B..B.....B.B.......BB..B............B.B....B..",
				 "B.......B..........B.........B...B.BB......B......",
				 "....B...............................B.............",
				 ".....B.B..........................................",
				 "..........B............B......B.B..B....B.........",
				 "....B...B.......................B.................",
				 "B.................B...........B..B....B...........",
				 "...B.....B........................................",
				 "...B..B......................................BBB..",
				 ".B...B....................................B....B..",
				 "...B...B..........B...B.B.........................",
				 ".....B.............B...BB..........B..BBB.BB......",
				 "....................B.....B.......................",
				 "........B..BB..........B.B....B...........B......B",
				 ".........B.....BB..B.............B....BB..........",
				 "....B..B..............B...B..B..........B........."};
		System.out.println(new BombSweeper().winPercentage(board));

	}

}
